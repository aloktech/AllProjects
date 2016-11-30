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

    private static final Logger LOGGER = LoggerFactory.getLogger(JdbcService.class
            .getSimpleName());

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

    public static JdbcService getInstance(DatabaseInfo databaseInfo) {
        init(databaseInfo);
        return INSTANCE;
    }

    private static void init(DatabaseInfo databaseInfo1) {
        databaseInfo = databaseInfo1;
        log = new LogService.LogServiceBuilder()
                .logger(LOGGER)
                .infoMsg("{0}")
                .warningMsg("{0}")
                .errorMsg("{0} {1}")
                .eventType(EventType.CONFIGURATION)
                .parameters(new ArrayList<>())
                .build();
        try {
            Class.forName(databaseInfo1.getDriver());
            connection = DriverManager.getConnection(getURL(), databaseInfo1.getUserName(), databaseInfo1.getPassword());
            log.setLogType(LogType.INFO);
        } catch (ExceptionInInitializerError e) {
            setLogError(log, e);
        } catch (LinkageError | ClassNotFoundException | SQLException e) {
            setLogError(log, e);
        } finally {
            log.execute();
        }
    }

    private void openConnection() {
        log = new LogService.LogServiceBuilder()
                .logger(LOGGER)
                .infoMsg("{0}")
                .warningMsg("{0}")
                .errorMsg("{0} {1}")
                .eventType(EventType.OPEN_CONNECTION)
                .parameters(new ArrayList<>())
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

    public void execute(String queryStr, List<ParameterPair> parameters) {

        log = new LogService.LogServiceBuilder()
                .logger(LOGGER)
                .infoMsg("{0}")
                .warningMsg("{0}")
                .errorMsg("{0} {1}")
                .eventType(EventType.ADD)
                .parameters(new ArrayList<>())
                .build();

        executeTryAndCatch(execute, queryStr, parameters, log);
    }

    public void add(String queryStr, List<ParameterPair> parameters) {

        log = new LogService.LogServiceBuilder()
                .logger(LOGGER)
                .infoMsg("{0}")
                .warningMsg("{0}")
                .errorMsg("{0} {1}")
                .eventType(EventType.ADD)
                .parameters(new ArrayList<>())
                .build();

        executeTryAndCatch(execute, queryStr, parameters, log);
    }

    public Object executeQuery(String queryStr, List<ParameterPair> parameter, List<DataType> dataTypes) {

        log = new LogService.LogServiceBuilder()
                .logger(LOGGER)
                .infoMsg("{0}")
                .warningMsg("{0}")
                .errorMsg("{0} {1}")
                .eventType(EventType.GET)
                .parameters(new ArrayList<>())
                .build();

        return executeTryAndCatch(executeQuery, queryStr, parameter, dataTypes, log);
    }

    public void delete(String queryStr, List<ParameterPair> parameter) {

        log = new LogService.LogServiceBuilder()
                .logger(LOGGER)
                .infoMsg("{0}")
                .warningMsg("{0}")
                .errorMsg("{0} {1}")
                .eventType(EventType.DELETE)
                .parameters(new ArrayList<>())
                .build();

        executeTryAndCatch(execute, queryStr, parameter, log);
    }

    public void update(String queryStr, List<ParameterPair> parameter) {

        log = new LogService.LogServiceBuilder()
                .logger(LOGGER)
                .infoMsg("{0}")
                .warningMsg("{0}")
                .errorMsg("{0} {1}")
                .eventType(EventType.UPDATE)
                .parameters(new ArrayList<>())
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
        openConnection();
        String query = String.format("SELECT id FROM %s.index_sequence", databaseInfo.getDatabaseName());
        PreparedStatement ps = null;
        try {
            ResultSet rs = connection.createStatement().executeQuery(query);
            while (rs.next()) {
                index = rs.getLong("id");
                break;
            }
            index = index == 0 ? 1 : index;
            query = "UPDATE index_sequence SET id=?";
            ps = connection.prepareStatement(query);
            ps.setLong(1, index + 1);
            ps.execute();

        } catch (SQLException ex) {
            LoggerFactory.getLogger(JdbcService.class).error(ex.getMessage());
        } finally {
            closePrepareStatement(ps);
            closeConnection();
        }
        return index;
    }

    private Object executeTryAndCatch(ExceptionFunction<PreparedStatement, SQLException> function, String statement, List<ParameterPair> parameters, LogService log) {
        return executeTryAndCatch(function, statement, parameters, new ArrayList<>(), log);
    }

    private Object executeTryAndCatch(ExceptionFunction<PreparedStatement, SQLException> function, String statement, List<ParameterPair> parameters, List<DataType> dataTypes, LogService log) {
        PreparedStatement ps = null;
        try {
            openConnection();
            ps = connection.prepareStatement(statement);
            for (int pIndex = 1, size = parameters.size(); pIndex <= size; pIndex++) {
                setParameters(ps, pIndex, parameters.get(pIndex - 1));
            }
            Object result = function.accept(ps);

            List<List<Object>> data = new ArrayList<>();
            if (result instanceof ResultSet) {
                try (ResultSet rs = (ResultSet) function.accept(ps)) {
                    while (rs.next()) {
                        List<Object> row = new ArrayList<>();
                        for (int pIndex = 1, size = dataTypes.size(); pIndex <= size; pIndex++) {
                            row.add(getParameter(dataTypes.get(pIndex - 1), rs, pIndex));
                        }
                        data.add(row);
                    }
                }
            }
            log.setLogType(LogType.INFO);

            return data;
        } catch (SQLTimeoutException e) {
            doRollBack();

            setLogError(log, e);
        } catch (SQLException e) {
            doRollBack();

            setLogError(log, e);
        } finally {
            log.execute();

            closePrepareStatement(ps);
            closeConnection();
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
                .infoMsg("{0}")
                .warningMsg("{0}")
                .errorMsg("{0} {1}")
                .eventType(EventType.ROLLBACK)
                .parameters(new ArrayList<>())
                .build();

        try {
            connection.rollback();
            log.setLogType(LogType.INFO);
        } catch (SQLException ex) {
            setLogError(log, ex);
        }
    }

    private void closePrepareStatement(PreparedStatement ps) {
        log = new LogService.LogServiceBuilder()
                .logger(LOGGER)
                .infoMsg("{0}")
                .warningMsg("{0}")
                .errorMsg("{0} {1}")
                .eventType(EventType.CLOSE_PREPARESTATEMENT)
                .parameters(new ArrayList<>())
                .build();

        try {
            if (ps != null) {
                ps.close();
                log.setLogType(LogType.INFO);
            }
        } catch (SQLException ex) {
            setLogError(log, ex);
        }
    }

    private void closeConnection() {
        log = new LogService.LogServiceBuilder()
                .logger(LOGGER)
                .infoMsg("{0}")
                .warningMsg("{0}")
                .errorMsg("{0} {1}")
                .eventType(EventType.CLOSE_CONNECTION)
                .parameters(new ArrayList<>())
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
        if (databaseInfo.getOptional() == null || databaseInfo.getOptional().isEmpty()) {
            return String.format(URL.substring(0, URL.indexOf("?")),
                    databaseInfo.getProtocol() == null ? "" : databaseInfo.getProtocol(),
                    databaseInfo.getSubProtocol() == null ? "" : databaseInfo.getSubProtocol(),
                    databaseInfo.getHost() == null ? "" : databaseInfo.getHost(),
                    databaseInfo.getPort(),
                    databaseInfo.getDatabaseName() == null ? "" : databaseInfo.getDatabaseName());
        } else {
            return String.format(URL,
                    databaseInfo.getProtocol() == null ? "" : databaseInfo.getProtocol(),
                    databaseInfo.getSubProtocol() == null ? "" : databaseInfo.getSubProtocol(),
                    databaseInfo.getHost() == null ? "" : databaseInfo.getHost(),
                    databaseInfo.getPort(),
                    databaseInfo.getDatabaseName() == null ? "" : databaseInfo.getDatabaseName(),
                    databaseInfo.getOptional() == null ? "" : databaseInfo.getOptional());
        }
    }
}
