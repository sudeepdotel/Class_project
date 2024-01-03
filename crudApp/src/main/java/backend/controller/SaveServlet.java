package backend.controller;

import backend.model.Student;
import backend.service.StudentService;

import javax.servlet.DispatcherType;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/register")
public class SaveServlet extends HttpServlet {

    public void init(){
        System.out.print("Initialization successful");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        int id = Integer.parseInt(request.getParameter("id "));
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String address = request.getParameter("address");
        long phone = Long.parseLong(request.getParameter("phone"));
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");


        Student student = new Student(firstName,lastName,address,phone,userName,password);


        //StudentService service = new StudentService();
        StudentService.studentRegistration(student);

        PrintWriter pw = response.getWriter();
        pw.println("<html><body><b>Successfully Inserted Data to your mysql db!! "
                + "</b></body></html>");
//        request.getRequestDispatcher("/frontend/WEB-INF/index.html").forward(request,response);

    }


}
