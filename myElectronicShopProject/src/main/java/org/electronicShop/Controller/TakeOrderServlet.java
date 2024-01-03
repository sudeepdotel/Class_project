package org.electronicShop.Controller;

import org.electronicShop.DAO.OrderOperation;
import org.electronicShop.Service.OrderService;
import org.electronicShop.Service.ProductService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@WebServlet("/takeOrder")
public class TakeOrderServlet extends HttpServlet {

    protected void doPost( HttpServletRequest request, HttpServletResponse response ){

        // perform the order taking mechanism and save it to the data base

        ProductService productService = new ProductService ( );
        OrderService orderService = new OrderService ( );
        OrderOperation orderOperation = new OrderOperation ( productService, orderService );

        orderOperation.placeOrderFromRequest ( request,productService,orderService );

    }
}
