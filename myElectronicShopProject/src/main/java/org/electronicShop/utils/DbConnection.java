package org.electronicShop.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {

    public static Connection getConnection ( ) {
        Connection conn = null;
        try {
            Class.forName ( "com.mysql.cj.jdbc.Driver" );
            conn = DriverManager.getConnection ( "jdbc:mysql://127.0.0.1:3306/product_order", "root", "******" );
        } catch (Exception e) {
            e.getMessage ( );
        }
        return conn;
    }
}