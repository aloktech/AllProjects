package com.imos.sample;

import lombok.Getter;

/**
 *
 * @author Pintu
 */
public enum EventType {

    NONE("None"),
    OPEN_CONNECTION("Open Connection"),
    CLOSE_CONNECTION("Close Connection"),
    CONFIGURATION("Configuration"),
    DATABASE_CONFIGURATION("Database Configuration"),
    JDBC_CONFIGURATION("JDBC Configuration"),
    INDEX_INCREMENT("Table Index increment"),
    EXECUTE("Execute"),
    ADD("Add"),
    GET("Get"),
    UPDATE("Update"),
    ROLLBACK("Rollback"),
    DELETE("Delete");

    @Getter
    private final String name;

    private EventType(String name) {
        this.name = name;
    }
}
