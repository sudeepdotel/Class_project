package org.nepalimarket.electronicshopproject.controller;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.nepalimarket.electronicshopproject.HelloServlet;
import org.nepalimarket.electronicshopproject.dao.ProductDAO;
import org.nepalimarket.electronicshopproject.model.Product;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/ProductUpdate")
public class ProductUpdateServlet extends HttpServlet {



    protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws IOException {

        try {
            ProductDAO productDAO = new ProductDAO ();

        // need product name to  update

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Fetch all products using ProductDAO
        List<Product> products = productDAO.getAllProducts();
        String productNameToBeUpdated = request.getParameter ( "productName" );
        int quantityToBeUpdated = Integer.parseInt ( request.getParameter ( "productQuantity" ) );

        //search all the products by name ... not implemented here btw
        productDAO.searchProductByName ( productNameToBeUpdated );


        productDAO.updateProductQuantities ( productNameToBeUpdated, quantityToBeUpdated);

            out.checkError ();
            out.println ( "congrats products updated!!" );
            response.sendRedirect("registerProduct.jsp");
            out.close ();
        } catch (Exception e) {
            throw new RuntimeException ( e );
        }

    }
}
