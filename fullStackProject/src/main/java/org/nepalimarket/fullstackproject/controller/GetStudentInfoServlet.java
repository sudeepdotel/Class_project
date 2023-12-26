package org.nepalimarket.fullstackproject.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.SessionFactory;

import org.nepalimarket.fullstackproject.fileOperation.ExcelFileWriter;
import org.nepalimarket.fullstackproject.model.Student;
import org.nepalimarket.fullstackproject.service.StudentService;


import java.io.IOException;
import java.util.List;
@WebServlet("/getStudentInfo")
public class GetStudentInfoServlet extends HttpServlet {

    private SessionFactory sessionFactory;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Fetch all student data from the database
        StudentService studentService = new StudentService(sessionFactory);
        //List<Student> students = studentService.getAllStudentDetails();

        List<Student> students = ExcelFileWriter.readStudentDataFromExcel (  );
        // Display student information directly in the servlet
        response.setContentType("text/html");
        response.getWriter().println("<html><head><title>Student Information</title></head><body>");
        response.getWriter().println("<h2>Student Information</h2>");
        response.getWriter().println("<table border=\"1\">");
        response.getWriter().println("<tr><th>Student ID</th><th>First Name</th><th>Last Name</th><th>Age</th><th>Address</th><th>Department</th></tr>");

        for (Student student : students) {
            response.getWriter().println("<tr>");
            response.getWriter().println("<td>" + student.getStudentId() + "</td>");
            response.getWriter().println("<td>" + student.getFirstName() + "</td>");
            response.getWriter().println("<td>" + student.getLastName() + "</td>");
            response.getWriter().println("<td>" + student.getAge() + "</td>");
            response.getWriter().println("<td>" + student.getAddress() + "</td>");
            response.getWriter().println("<td>" + student.getStudentDepartment() + "</td>");
            response.getWriter().println("</tr>");
        }

        response.getWriter().println("</table></body></html>");


    }
}
