package com.example.servlets;



import com.example.servlets.dbConnection.Connect;

import com.example.servlets.model.User;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet("/signup")
public class SignUpServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

        try {
            Connection conn = Connect.getConnection();

            // Retrieve parameters from the request
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String email = request.getParameter("email");
            String dateOfBirth = request.getParameter("dateOfBirth");

// Create a User object
            User user = new User();
            user.setUserName(username);
            user.setPassword(password);
            user.setEmail(email);
            user.setDateOfBirth(dateOfBirth);




            // Use the User object to set values in the PreparedStatement
            PreparedStatement ps = conn.prepareStatement("INSERT INTO users (username, password, email, date_of_birth) VALUES (?, ?, ?, ?)");
            ps.setString(1, user.getUserName());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getDateOfBirth());

            // Execute the update
            int status = ps.executeUpdate();

            // Send the status as a response
            response.getWriter().println(status);
        } catch ( SQLException | IOException e) {
            System.err.println("Error message :: " + e.getMessage());
        }

    }
}





