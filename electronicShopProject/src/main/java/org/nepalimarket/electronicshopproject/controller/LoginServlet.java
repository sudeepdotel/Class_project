package org.nepalimarket.electronicshopproject.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.nepalimarket.electronicshopproject.model.Customer;
import org.nepalimarket.electronicshopproject.service.LoginService;

import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final LoginService loginService;

    public LoginServlet() throws Exception {
        this.loginService = new LoginService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Customer authenticatedCustomer = loginService.authenticateUser(username, password);




        if (authenticatedCustomer != null) {
            // Add logic for successful login, e.g., setting session attributes
            HttpSession session = request.getSession();
            session.setAttribute("customerId", authenticatedCustomer.getCustomerId());
            session.setAttribute("customerFullName", authenticatedCustomer.getFullName());

            // Redirect to index.jsp with a welcome message
            response.sendRedirect("index.jsp");
        } else {
            // Add logic for failed login
            response.getWriter().println("<p>Invalid username or password. Please try again.</p>");
        }
    }
}
