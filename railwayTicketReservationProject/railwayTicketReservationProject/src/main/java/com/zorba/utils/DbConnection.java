package com.zorba.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbConnection {

    public static Connection getConnection() throws Exception {
        try (InputStream input = DbConnection.class.getClassLoader().getResourceAsStream("db.properties")) {
            Properties prop = new Properties();
            prop.load(input);

            String dbDriver = prop.getProperty("db.driver");
            String dbURL = prop.getProperty("db.url");
            String dbUsername = prop.getProperty("db.username");
            String dbPassword = prop.getProperty("db.password");

            Class.forName(dbDriver);
            return DriverManager.getConnection(dbURL, dbUsername, dbPassword);
        } catch (Exception e) {
            throw new SQLException ("Error initializing database connection: " + e.getMessage());
        }
    }
}
