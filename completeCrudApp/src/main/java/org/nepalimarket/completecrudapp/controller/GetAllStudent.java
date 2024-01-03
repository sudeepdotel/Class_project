package org.nepalimarket.completecrudapp.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.nepalimarket.completecrudapp.dao.StudentDAO;
import org.nepalimarket.completecrudapp.model.Student;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/studentList")
public class GetAllStudent extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<Student> studentList = StudentDAO.getAllStudentDetails();

        PrintWriter pw = response.getWriter();
        pw.println("<html><body><b>Successfully retrieved data!! </b><br>");

        // Display each student's details
        for (Student student : studentList) {

            pw.println("Name: " + student.getName() + "<br>");
            pw.println("Email: " + student.getEmail() + "<br>");
            pw.println("Phone: " + student.getPhone() + "<br>");
            pw.println("User Name: " + student.getUserName() + "<br>");
            pw.println("Password: " + student.getcPassword() + "<br><br>");
        }

        pw.println("</body></html>");
    }
}
