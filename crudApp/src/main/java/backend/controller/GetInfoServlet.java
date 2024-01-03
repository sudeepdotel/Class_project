package backend.controller;


import backend.dao.StudentDAO;
import backend.model.Student;
import backend.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import static backend.service.StudentService.dao;

@WebServlet("/studentList")
public class GetInfoServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<Student> studentList = StudentDAO.getAllStudentDetails();

        PrintWriter pw = response.getWriter();
        pw.println("<html><body><b>Successfully retrieved data!! </b><br>");

        // Display each student's details
        for (Student student : studentList) {

            pw.println("First Name: " + student.getFirstName() + "<br>");
            pw.println("Last Name: " + student.getLastName() + "<br>");
            pw.println("Address: " + student.getAddress() + "<br>");
            pw.println("Phone: " + student.getPhone() + "<br>");
            pw.println("User Name: " + student.getUserName() + "<br>");
            pw.println("Password: " + student.getPassword() + "<br><br>");
        }

        pw.println("</body></html>");
    }
}
