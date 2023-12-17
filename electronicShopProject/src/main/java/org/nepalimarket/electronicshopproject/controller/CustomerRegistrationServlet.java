package org.nepalimarket.electronicshopproject.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.nepalimarket.electronicshopproject.model.Customer;
import org.nepalimarket.electronicshopproject.service.CustomerService;

import java.io.IOException;

@WebServlet("/CustomerRegistrationServlet")
public class CustomerRegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final CustomerService customerService;

    public CustomerRegistrationServlet() throws Exception {
        this.customerService = new CustomerService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String fullName = request.getParameter("fullName");

        Customer existingCustomer = customerService.getCustomerByUsername(username);

        if (existingCustomer == null) {
            Customer newCustomer = customerService.registerCustomer(username, password, email, fullName);
            if (newCustomer != null) {
                response.getWriter().println("<p>Registration successful! Welcome, " + newCustomer.getFullName() + ".</p>");
            } else {
                response.getWriter().println("<p>Error in registration. Please try again.</p>");
            }
        } else {
            response.getWriter().println("<p>Username already exists. Choose a different username.</p>");
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }
}
