package com.example.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/student-directory")
public class SubmitRegistration extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form data
        String firstName = request.getParameter("fName");
        String lastName = request.getParameter("lName");
        int age = Integer.parseInt(request.getParameter("age"));
        String gender = request.getParameter("gender");

        // Perform any processing or validation as needed

        // For now, let's just print the received data
        PrintWriter out = response.getWriter();
        out.println("First Name: " + firstName);
        out.println("Last Name: " + lastName);
        out.println("Age: " + age);
        out.println("Gender: " + gender);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.getRequestDispatcher("/html/studentDirectory.html").forward(request, response);
        } catch (ServletException | IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
