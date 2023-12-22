package org.nepalimarket.electronicshopproject.controller;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.nepalimarket.electronicshopproject.utils.DatabaseUtils;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

@WebServlet("/ProductRegistrationServlet")
public class ProductRegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost( HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String productName = request.getParameter("productName");
        String description = request.getParameter("description");
        double price = Double.parseDouble(request.getParameter("price"));
        int quantityAvailable = Integer.parseInt(request.getParameter("quantityAvailable"));

        try {
            Connection con = DatabaseUtils.getConnection();

            PreparedStatement ps = con.prepareStatement("INSERT INTO products (name, description, price, qty_available) VALUES (?, ?, ?, ?)");
            ps.setString(1, productName);
            ps.setString(2, description);
            ps.setDouble(3, price);
            ps.setInt(4, quantityAvailable);

            int result = ps.executeUpdate();
            if (result > 0) {
                out.println("<p>Product registered successfully!</p>");
            } else {
                out.println("<p>Error in product registration.</p>");
            }

            con.close();
        } catch (Exception e) {
            out.println(e);
        }

        out.close();
    }
}
