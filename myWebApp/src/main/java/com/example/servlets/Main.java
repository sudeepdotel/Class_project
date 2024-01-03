package com.example.servlets;


import com.example.servlets.dbConnection.Connect;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connect.getConnection();
    }
}
