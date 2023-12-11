package com.example.servlet;


import com.example.dbConnection.ConnectionByProperties;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/insert")
    public class MyServlet extends HttpServlet {

    public void init() {
        System.out.println("Servlet initiation !!");
    }

    protected void doPost(HttpServletRequest httpServletRequest,
                          HttpServletResponse httpServletResponse) {
        try {
            Connection connection = ConnectionByProperties.initializeDatabase();

            PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT into students values (0,?, ?, ?, ?)");

            // Fetch the data from the request
            String firstName = httpServletRequest.getParameter("fName");
            String lastName = httpServletRequest.getParameter("lName");
            String age = httpServletRequest.getParameter("age");
            String gender = httpServletRequest.getParameter("gender");

            // Set parameters in the prepared statement
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setInt(3, Integer.parseInt(age));
            preparedStatement.setString(4, gender);

            // Execute the update
            preparedStatement.executeUpdate();

            // Close resources
            preparedStatement.close();
            connection.close();

            PrintWriter out = httpServletResponse.getWriter();
            out.println("<html><body><b>Successfully Inserted Data to your mysql db!! "
                    + "</b></body></html>");

        } catch (Exception e) {
            System.err.println("Error Details :" + e.getMessage());
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            Connection connection = ConnectionByProperties.initializeDatabase();

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM students");

            ResultSet resultSet = preparedStatement.executeQuery();

            // Build an HTML table to display the results
            StringBuilder htmlResponse = new StringBuilder();
            htmlResponse.append("<html><body>");
            htmlResponse.append("<h2>Student Information:</h2>");
            htmlResponse.append("<table border='1'><tr><th>ID</th><th>First Name</th><th>Last Name</th><th>Age</th><th>Gender</th></tr>");

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String fName = resultSet.getString("fName");
                String lName = resultSet.getString("lName");
                int age = resultSet.getInt("age");
                String gender = resultSet.getString("gender");

                htmlResponse.append("<tr><td>").append(id).append("</td><td>").append(fName).append("</td><td>").append(lName)
                        .append("</td><td>").append(age).append("</td><td>").append(gender).append("</td></tr>");
            }

            htmlResponse.append("</table>");
            htmlResponse.append("</body></html>");

            // Send the HTML response back to the client
            PrintWriter out = response.getWriter();
            out.println(htmlResponse.toString());

            // Close resources
            resultSet.close();
            preparedStatement.close();
            connection.close();

        } catch (Exception e) {
            System.err.println("Error Details: " + e.getMessage());
        }
    }
}



