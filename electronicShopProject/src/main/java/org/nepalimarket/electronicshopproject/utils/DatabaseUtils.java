package org.nepalimarket.electronicshopproject.utils;

// DatabaseUtils.java
import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseUtils {

    public static Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerceDB", "****", "****");
    }
}
