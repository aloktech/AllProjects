/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLTimeoutException;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Pintu
 */
public enum JdbcService {

    INSTANCE;

    private static final Logger LOGGER = LoggerFactory.getLogger(JdbcService.class);

    private final ExceptionFunction<PreparedStatement, SQLException> execute = p -> {
        return p.execute();
    };
    private final ExceptionFunction<PreparedStatement, SQLException> executeUpdate = p -> {
        return p.executeUpdate();
    };
    private final ExceptionFunction<PreparedStatement, SQLException> executeQuery = p -> {
        return p.executeQuery();
    };

    @Getter
    private static long index;

    @Getter
    private static DatabaseInfo databaseInfo;

    private static LogService log;

    private static Connection connection;

    private static final String URL = "%s:%s://%s:%d/%s?%s";

    public void configure(DatabaseInfo pDatabaseInfo) {
        databaseInfo = pDatabaseInfo;

        log = new LogService.LogServiceBuilder()
                .logger(LOGGER)
                .eventType(EventType.JDBC_CONFIGURATION)
                .build();

        try {
            Class.forName(pDatabaseInfo.getDriver());

            connection = DriverManager.getConnection(getURL(), pDatabaseInfo.getUserName(), pDatabaseInfo.getPassword());

            log.setLogType(LogType.INFO);
        } catch (ExceptionInInitializerError e) {
            setLogError(log, e);
        } catch (LinkageError | ClassNotFoundException | SQLException e) {
            setLogError(log, e);
        } finally {
            log.execute();
        }
    }

    public void openConnection() {
        log = new LogService.LogServiceBuilder()
                .logger(LOGGER)
                .eventType(EventType.OPEN_CONNECTION)
                .build();

        try {
            if (connection == null || connection.isClosed()) {

                connection = DriverManager.getConnection(getURL(),
                        databaseInfo.getUserName(),
                        databaseInfo.getPassword());
            }
            log.setLogType(LogType.INFO);
        } catch (SQLTimeoutException e) {
            setLogError(log, e);
        } catch (SQLException e) {
            setLogError(log, e);
        } finally {
            log.execute();
        }
    }

    public Object execute(String queryStr, List<ParameterPair> parameters) {

        log = new LogService.LogServiceBuilder()
                .logger(LOGGER)
                .eventType(EventType.EXECUTE)
                .build();

        return executeTryAndCatch(execute, queryStr, parameters, log);
    }

    public void add(String queryStr, List<ParameterPair> parameters) {

        log = new LogService.LogServiceBuilder()
                .logger(LOGGER)
                .eventType(EventType.ADD)
                .build();

        executeTryAndCatch(execute, queryStr, parameters, log);
    }

    public Object executeQuery(String queryStr, List<ParameterPair> parameter, List<DataType> dataTypes) {

        log = new LogService.LogServiceBuilder()
                .logger(LOGGER)
                .eventType(EventType.GET)
                .build();

        return executeTryAndCatch(executeQuery, queryStr, parameter, dataTypes, log);
    }

    public void delete(String queryStr, List<ParameterPair> parameter) {

        log = new LogService.LogServiceBuilder()
                .logger(LOGGER)
                .eventType(EventType.DELETE)
                .build();

        executeTryAndCatch(execute, queryStr, parameter, log);
    }

    public void update(String queryStr, List<ParameterPair> parameter) {

        log = new LogService.LogServiceBuilder()
                .logger(LOGGER)
                .eventType(EventType.UPDATE)
                .build();

        executeTryAndCatch(executeUpdate, queryStr, parameter, log);
    }

    public void setParameters(PreparedStatement ps, int index, ParameterPair pp) {
        try {
            switch (pp.getDataType()) {
                case INTEGER:
                    ps.setInt(index, ((Integer) pp.getData()));
                    break;
                case DOUBLE:
                    ps.setDouble(index, ((Double) pp.getData()));
                    break;
                case LONG:
                    ps.setLong(index, ((Long) pp.getData()));
                    break;
                case STRING:
                    ps.setString(index, ((String) pp.getData()));
                    break;

            }
        } catch (SQLException ex) {
            LoggerFactory.getLogger(JdbcService.class).error(ex.getMessage());
        }
    }

    public Object getParameter(DataType pp, ResultSet rs, int index) {
        try {
            switch (pp) {
                case INTEGER:
                    return rs.getInt(index);
                case LONG:
                    return rs.getLong(index);
                case DOUBLE:
                    return rs.getDouble(index);
                case STRING:
                    return rs.getString(index);

            }
        } catch (SQLException ex) {
            LoggerFactory.getLogger(JdbcService.class).error(ex.getMessage());
        }
        return null;
    }

    public long nextIndex() {
        log = new LogService.LogServiceBuilder()
                .logger(LOGGER)
                .eventType(EventType.INDEX_INCREMENT)
                .build();

        try (ResultSet resultSet = connection.createStatement().executeQuery("SELECT next_val FROM index_sequence")) {
            while (resultSet.next()) {
                index = resultSet.getLong("next_val");
                break;
            }
            index = index == 0 ? 1 : index;
            log.setLogType(LogType.INFO);
        } catch (SQLException ex) {
            setLogError(log, ex);
        }

        try (PreparedStatement prepareStatement = connection.prepareStatement("UPDATE index_sequence SET next_val = ?")) {
            prepareStatement.setLong(1, index + 1);
            prepareStatement.execute();
            log.setLogType(LogType.INFO);
        } catch (SQLException ex) {
            setLogError(log, ex);
        } finally {
            log.execute();
        }
        return index;
    }

    private Object executeTryAndCatch(ExceptionFunction<PreparedStatement, SQLException> function, String statement, List<ParameterPair> parameters, LogService log) {
        return executeTryAndCatch(function, statement, parameters, new ArrayList<>(), log);
    }

    private Object executeTryAndCatch(ExceptionFunction<PreparedStatement, SQLException> function, String statement, List<ParameterPair> parameters, List<DataType> dataTypes, LogService log) {
        try (PreparedStatement prepareStatement = connection.prepareStatement(statement)) {

            for (int pIndex = 1, size = parameters.size(); pIndex <= size; pIndex++) {
                setParameters(prepareStatement, pIndex, parameters.get(pIndex - 1));
            }
            Object result = function.accept(prepareStatement);

            List<List<Object>> dataList = new ArrayList<>();
            if (result instanceof ResultSet) {
                try (ResultSet resultSet = (ResultSet) function.accept(prepareStatement)) {
                    while (resultSet.next()) {
                        List<Object> row = new ArrayList<>();
                        for (int pIndex = 1, size = dataTypes.size(); pIndex <= size; pIndex++) {
                            row.add(getParameter(dataTypes.get(pIndex - 1), resultSet, pIndex));
                        }
                        dataList.add(row);
                    }
                }
            }
            log.setLogType(LogType.INFO);

            return dataList;
        } catch (SQLTimeoutException e) {
            doRollBack();

            setLogError(log, e);
        } catch (SQLException e) {
            doRollBack();

            setLogError(log, e);
        } catch (Exception e) {
            doRollBack();

            setLogError(log, e);
        } finally {
            log.execute();
        }
        return null;
    }

    private static <T extends Throwable> void setLogError(LogService log, T e) {
        log.getParameters().add(e.getMessage());
        log.setLogType(LogType.ERROR);
    }

    private void doRollBack() {
        log = new LogService.LogServiceBuilder()
                .logger(LOGGER)
                .eventType(EventType.ROLLBACK)
                .build();

        try {
            if (connection != null) {
                connection.rollback();
                log.setLogType(LogType.INFO);
            }
        } catch (SQLException ex) {
            setLogError(log, ex);
        } finally {
            log.execute();
        }
    }

    public void closeConnection() {
        log = new LogService.LogServiceBuilder()
                .logger(LOGGER)
                .eventType(EventType.CLOSE_CONNECTION)
                .build();

        try {
            if (connection != null) {
                connection.close();
                log.setLogType(LogType.INFO);
            }
        } catch (SQLException ex) {
            setLogError(log, ex);
        } finally {
            log.execute();
        }
    }

    private static String getURL() {
        List<Object> parameters = new ArrayList<>();
        parameters.add(databaseInfo.getProtocol() == null ? "" : databaseInfo.getProtocol());
        parameters.add(databaseInfo.getSubProtocol() == null ? "" : databaseInfo.getSubProtocol());
        parameters.add(databaseInfo.getHost() == null ? "" : databaseInfo.getHost());
        parameters.add(databaseInfo.getPort());
        parameters.add(databaseInfo.getDatabaseName() == null ? "" : databaseInfo.getDatabaseName());

        String urlStr;
        if (databaseInfo.getOptional() == null || databaseInfo.getOptional().isEmpty()) {
            urlStr = URL.substring(0, URL.indexOf("?"));
        } else {
            parameters.add(databaseInfo.getOptional());
            urlStr = URL;
        }
        return String.format(urlStr, parameters.toArray(new Object[0]));
    }
}
