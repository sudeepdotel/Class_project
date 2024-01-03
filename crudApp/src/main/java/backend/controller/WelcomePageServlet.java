package backend.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/")
public class WelcomePageServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter pw = response.getWriter();
        pw.println("Welcome to the Home page!!");

        // Forward the request to index.html in WEB-INF directory
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/index.html");
        dispatcher.forward(request, response);
    }
}

