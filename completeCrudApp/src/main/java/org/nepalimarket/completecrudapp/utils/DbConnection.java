package org.nepalimarket.completecrudapp.utils;

import java.sql.Connection;
import java.sql.DriverManager;


public class DbConnection {

    public static void main(String[] args) {
        getConnection();
    }

    public static Connection getConnection(){
        Connection conn = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3333/studentdb","root","");
        }catch (Exception e){
            e.getMessage();
        }
        return conn;
    }
}
