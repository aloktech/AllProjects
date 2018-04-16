/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample.database.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pintu
 */
public final class QueryBuilder {

    private static final String SEPARATOR = "|";
    private static final String HASH = "#";
    private static final String COLON = ":";
    private static final String BLANK = " ";
    private static final String EMPTY = "";
    private static final String NEW_LINE = "\n";
    private static final Map<String, String> QUERIES_MAP = new HashMap<>();

    private final StringBuilder queryBuilder;

    private String queryName;

    public QueryBuilder() {
        queryBuilder = new StringBuilder();
    }

    public QueryBuilder addQueryName(String queryName) {
        this.queryName = queryName;
        return this;
    }

    public QueryBuilder addQuery(String query) {
        queryBuilder.append(query.trim());
        appendToQuery();
        return this;
    }

    public QueryBuilder addQuery(Number query) {
        queryBuilder.append(query);
        appendToQuery();
        return this;
    }

    public String build() {
        return queryBuilder.toString().replace(SEPARATOR, EMPTY);
    }

    public String generateQuery() {
        String query = queryBuilder.toString().replace(SEPARATOR, NEW_LINE);
        if (queryName == null || query.isEmpty()) {
            QUERIES_MAP.put(String.valueOf(query.hashCode()), query);
        } else {
            QUERIES_MAP.put(queryName, query);
        }
        queryName = null;
        return query;
    }

    public static void writeQueriesToFile() {
        writeQueriesToFile(null);
    }

    public static void writeQueriesToFile(String filePath) {
        StringBuilder strBuilder = new StringBuilder();

        QUERIES_MAP.forEach((k, v) -> {
            strBuilder.append(HASH);
            strBuilder.append(k);
            strBuilder.append(BLANK);
            strBuilder.append(COLON);
            strBuilder.append(NEW_LINE);
            strBuilder.append(v);
            strBuilder.append(NEW_LINE);
        });

        try {
            Files.write(Paths.get(filePath == null ? "D:/temp/sqlQueries.txt" : filePath), strBuilder.toString().getBytes());
            Files.write(Paths.get(filePath == null ? "./sqlQueries.txt" : filePath), strBuilder.toString().getBytes());
        } catch (IOException ex) {
            Logger.getLogger(QueryBuilder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void appendToQuery() {
        queryBuilder.append(BLANK);
        queryBuilder.append(SEPARATOR);
    }

}
