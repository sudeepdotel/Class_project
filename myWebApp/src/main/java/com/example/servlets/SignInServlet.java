package com.example.servlets;

import com.example.servlets.dbConnection.Connect;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/signin")
public class SignInServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

        try {
            Connection conn = Connect.getConnection();

            // Retrieve parameters from the request
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            // Query to check user credentials
            String query = "SELECT * FROM users WHERE username = ? AND password = ?";
            try (PreparedStatement ps = conn.prepareStatement(query)) {
                ps.setString(1, username);
                ps.setString(2, password);

                // Execute the query
                ResultSet rs = ps.executeQuery();

                // Check if a user with the provided credentials exists
                if (rs.next()) {
                    // Successful sign-in
                    response.getWriter().println("Sign-in successful!");
                } else {
                    // Failed sign-in
                    response.getWriter().println("Invalid username or password.");
                }
            }

        } catch (SQLException | IOException e) {
            System.err.println("Error message :: " + e.getMessage());
        }
    }
}
