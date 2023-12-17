package org.nepalimarket.electronicshopproject.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.nepalimarket.electronicshopproject.dao.ProductDAO;
import org.nepalimarket.electronicshopproject.model.Product;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/ProductDetailsServlet")
public class ProductDetailsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final ProductDAO productDAO;

    public ProductDetailsServlet() throws Exception {
        this.productDAO = new ProductDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Fetch all products using ProductDAO
        List<Product> products = productDAO.getAllProducts();

        // Set response content type
        response.setContentType("text/html");

        // Get PrintWriter
        PrintWriter out = response.getWriter();

        // Write HTML content to display product details
        out.println("<html>");
        out.println("<head><title>Product Details</title></head>");
        out.println("<body>");

        // Display all products
        out.println("<h2>Product Details</h2>");
        out.println("<ul>");
        for (Product product : products) {
            out.println("<li>");
            out.println("<strong>Name:</strong> " + product.getName() + "<br>");
            out.println("<strong>Description:</strong> " + product.getDescription() + "<br>");
            out.println("<strong>Price:</strong> $" + product.getPrice() + "<br>");
            out.println("<strong>Available Quantity:</strong> " + product.getQtyAvailable() + "<br>");
            out.println("</li>");
        }
        out.println("</ul>");

        out.println("</body>");
        out.println("</html>");

        // Close PrintWriter
        out.close();
    }
}
