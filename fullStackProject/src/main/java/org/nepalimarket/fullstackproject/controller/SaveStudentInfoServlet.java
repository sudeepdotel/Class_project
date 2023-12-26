package org.nepalimarket.fullstackproject.controller;


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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/saveInfo")
public class SaveStudentInfoServlet extends HttpServlet {

    private SessionFactory sessionFactory;
    protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws IOException {


        // Retrieve student details from the request parameters
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        int age = Integer.parseInt(request.getParameter("age"));
        String address = request.getParameter("address");
        String studentDepartment = request.getParameter("studentDepartment");

        // Create a Student object with the retrieved details
        Student student = new Student();
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setAge(age);
        student.setAddress(address);
        student.setStudentDepartment(studentDepartment);

        // Save the student using the StudentService
        StudentService studentService = new StudentService(sessionFactory);
        studentService.saveStudentDetails (student);

        List<Student> studentList = studentService.getAllStudentDetails();
        ExcelFileWriter.writeStudentDataToExcel ( studentList );


        // Redirect to a success page or display a success message
        response.getWriter ().println ( "Saved successfully" );
//        response.sendRedirect("success.jsp");

    }
}
