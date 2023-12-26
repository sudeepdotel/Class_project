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
import org.nepalimarket.fullstackproject.util.HibernateConnection;

import java.io.IOException;
import java.util.List;

@WebServlet("/fetchData")
public class GetStudentInfoServlet extends HttpServlet {

    private SessionFactory sessionFactory;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Fetch all student data from the database
        StudentService studentService = new StudentService(sessionFactory);
        List<Student> students = studentService.getAllStudentDetails();

        // Write data to Excel file
        ExcelFileWriter.readStudentDataFromExcel ();

        // Set the retrieved data as an attribute to be used in the JSP page
        request.setAttribute("students", students);

        // Forward the request to the JSP page for display
        request.getRequestDispatcher("/displayStudents.jsp").forward(request, response);
    }
}
