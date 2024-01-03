package backend.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String uName = request.getParameter("userName");
        String uPassword = request.getParameter("password");


        PrintWriter out = response.getWriter();
        if ("koolsudeep".equals(uName) && "123".equals(uPassword)) {
            // Successful login
            //out.println("<html><body><b>Login Successful! Welcome, " + uName + "!</b></body></html>");
            response.sendRedirect(request.getContextPath() + "/webapp/html/index.html");
        } else {
            // Failed login
            out.println("<html><body><b>Login Failed! Please check your username and password.</b></body></html>");

        }

//        response.sendRedirect("../webapps/html/index.html");
    }
}
