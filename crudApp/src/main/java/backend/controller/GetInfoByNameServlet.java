package backend.controller;


import backend.dao.StudentDAO;
import backend.model.Student;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/studentName")
public class GetInfoByNameServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, IOException {
        String searchName = request.getParameter("search");

        if (searchName != null && !searchName.isEmpty()) {
            List<Student> studentList = null;
            try {
                studentList = StudentDAO.getStudentDetailsByName(searchName);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            PrintWriter pw = response.getWriter();
            pw.println("<html><body><b>Successfully retrieved data by name!! </b><br>");

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
        } else {
            // Handle the case where no search name is provided
            response.getWriter().write("Please provide a search name.");
        }
    }
}
