package org.nepalimarket.electronicshopproject.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.nepalimarket.electronicshopproject.model.Customer;
import org.nepalimarket.electronicshopproject.model.Order;
import org.nepalimarket.electronicshopproject.service.CustomerService;
import org.nepalimarket.electronicshopproject.service.OrderService;

import java.io.IOException;
import java.util.List;

@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final OrderService orderService;
    public OrderServlet() throws Exception {
        this.orderService = new OrderService();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Retrieve order details from the form
            HttpSession session = request.getSession();
            Integer customerId = (Integer) session.getAttribute("customerId");

            // Ensure customerId is not null
            if (customerId != null) {
                String productName = request.getParameter("productName");
                int quantity = Integer.parseInt(request.getParameter("quantity"));
                // Place the order
                Order placedOrder = orderService.placeOrder(customerId, productName, quantity);
                // Retrieve all orders for the customer
                List<Order> customerOrders = orderService.getOrdersByCustomerId(customerId);

                // Set attributes for the order confirmation page
                request.setAttribute("placedOrder", placedOrder);
                request.setAttribute("customerOrders", customerOrders);

                // Forward to the order confirmation page
                RequestDispatcher dispatcher = request.getRequestDispatcher("orderConfirmation.jsp");
                dispatcher.forward(request, response);
            } else {
                // Handle the case where customerId is null (customer not logged in)
                response.getWriter().println("<p>Error processing the order. Customer not logged in.</p>");
            }
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception for debugging
            // Handle the exception and show an error page or message to the user
            response.getWriter().println("<p>Product not available in sufficient quantity. Please try again.</p>");
        }
    }

}


