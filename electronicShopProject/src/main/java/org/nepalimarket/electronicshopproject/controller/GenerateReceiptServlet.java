package org.nepalimarket.electronicshopproject.controller;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.nepalimarket.electronicshopproject.model.Order;
import org.nepalimarket.electronicshopproject.service.OrderService;
import org.nepalimarket.electronicshopproject.utils.PdfGenerator;

import java.io.IOException;
import java.util.List;

@WebServlet("/receipt")
public class GenerateReceiptServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int customerIdFromRequest = Integer.parseInt(request.getParameter("customerId"));

        OrderService orderService = null;
        try {
            orderService = new OrderService();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        List<Order> orders = orderService.getOrdersByCustomerId(customerIdFromRequest);

        if (!orders.isEmpty()) {
            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "inline; filename=receipt.pdf");

            // retrive customer name from the session
            HttpSession session = request.getSession();
            String customerName = (String) session.getAttribute("customerFullName");
            try {
                PdfGenerator.generateReceipts(orders, response.getOutputStream(), customerName);
                System.out.println("Receipts generated successfully.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            response.getWriter().println("No orders found for the customer, try again");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Handle POST requests
        int customerIdFromRequest = Integer.parseInt(request.getParameter("customerId"));

        OrderService orderService = null;
        try {
            orderService = new OrderService();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        List<Order> orders = orderService.getOrdersByCustomerId(customerIdFromRequest);

        if (!orders.isEmpty()) {
            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "inline; filename=receipt.pdf");

            // retrive customer name from the session
            HttpSession session = request.getSession();
            String customerName = (String) session.getAttribute("customerFullName");
            try {
                PdfGenerator.generateReceipts(orders, response.getOutputStream(), customerName);
                System.out.println("Receipts generated successfully.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            response.getWriter().println("No orders found for the customer, try again");
        }
    }
}
