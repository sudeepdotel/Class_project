package org.nepalimarket.electronicshopproject.controller;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.nepalimarket.electronicshopproject.dao.ProductDAO;

import java.io.PrintWriter;

@WebServlet("/DeleteProduct")
public class ProductDeleteServlet extends HttpServlet {

    //
    protected void doPost( HttpServletRequest request, HttpServletResponse response ){

        try {
            ProductDAO productDAO = new ProductDAO ();
            String productNameToBeDeleted = request.getParameter ( "productName" );

            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

            // delete product by the name
            productDAO.deleteProductByName ( productNameToBeDeleted );
            out.println ( "Successfully Deleted !!" );
            out.close ();

        } catch (Exception e) {
            throw new RuntimeException ( e );
        }

    }

}
