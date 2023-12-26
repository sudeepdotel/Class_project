package com.example.dbConnection;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionByProperties {

    public static void main ( String[] args ) throws SQLException, ClassNotFoundException {
        initializeDatabase ();
        System.out.println ("successfully connected" );
    }
    public static Connection initializeDatabase() throws SQLException, ClassNotFoundException {
        try (InputStream input = ConnectionByProperties.class.getClassLoader().getResourceAsStream("db.properties")) {
            Properties prop = new Properties();
            prop.load(input);

            String dbDriver = prop.getProperty("db.driver");
            String dbURL = prop.getProperty("db.url");
            String dbUsername = prop.getProperty("db.username");
            String dbPassword = prop.getProperty("db.password");

            Class.forName(dbDriver);
            return DriverManager.getConnection(dbURL, dbUsername, dbPassword);
        } catch (Exception e) {
            throw new SQLException("Error initializing database connection: " + e.getMessage());
        }
    }
}
