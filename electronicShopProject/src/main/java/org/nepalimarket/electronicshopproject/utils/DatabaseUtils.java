//
//package org.nepalimarket.electronicshopproject.utils;
//
//import java.io.InputStream;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.util.Properties;
//
//public class DatabaseUtils {
//
//    public static void main ( String[] args ) throws Exception {
//        getConnection ();
//    }
//
//    public static Connection getConnection() throws Exception {
//        try (InputStream input = DatabaseUtils.class.getClassLoader().getResourceAsStream("db.properties")) {
//            Properties prop = new Properties();
//            prop.load(input);
//
//            String dbDriver = prop.getProperty("db.driver");
//            String dbURL = prop.getProperty("db.url");
//            String dbUsername = prop.getProperty("db.username");
//            String dbPassword = prop.getProperty("db.password");
//
//            dbDriver = getEnvironmentVariable ( "DB_DRIVER",dbDriver );
//            dbURL = getEnvironmentVariable("DB_URL", dbURL);
//            dbUsername = getEnvironmentVariable("DB_USERNAME", dbUsername);
//            dbPassword = getEnvironmentVariable("DB_PASSWORD", dbPassword);
//
//
//            Class.forName(dbDriver);
//            return DriverManager.getConnection(dbURL, dbUsername, dbPassword);
//        } catch (Exception e) {
//            throw new SQLException ("Error initializing database connection: " + e.getMessage());
//        }
//    }
//
//    private static String getEnvironmentVariable(String variableName, String defaultValue) {
//        String value = System.getenv(variableName);
//        return (value != null && !value.isEmpty()) ? value : defaultValue;
//    }
//}


package org.nepalimarket.electronicshopproject.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;

public class DatabaseUtils {

    public static void main(String[] args) throws Exception {
        Map<String, String> env = System.getenv();
        env.forEach((key, value) -> System.out.println(key + ": " + value));
        getConnection();
    }

    public static Connection getConnection() throws Exception {
        //String dbDriver = getEnvironmentVariable("DB_DRIVER");
        String dbURL = getEnvironmentVariable("DB_URL");
        String dbUsername = getEnvironmentVariable("DB_USERNAME");
        String dbPassword = getEnvironmentVariable("DB_PASSWORD");

        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(dbURL, dbUsername, dbPassword);
    }

    private static String getEnvironmentVariable(String variableName) {
        String value = System.getenv(variableName);
        if (value == null || value.isEmpty()) {
            throw new RuntimeException("Environment variable " + variableName + " not set.");
        }
        return value;
    }
}
