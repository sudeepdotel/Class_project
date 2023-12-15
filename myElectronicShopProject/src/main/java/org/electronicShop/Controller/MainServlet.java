// MainServlet
package org.electronicShop.Controller;

import org.electronicShop.Service.OrderService;
import org.electronicShop.Service.ReceiptGenerator;
import org.electronicShop.model.Order;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/receipt")
public class MainServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        int orderIdFromRequest = Integer.parseInt(request.getParameter("orderId"));

        OrderService orderService = new OrderService();
        Order order = orderService.getOrderById(orderIdFromRequest);

        if (order != null) {
            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "inline; filename=receipt.pdf");
            try {
                ReceiptGenerator.generateReceipt(order, response.getOutputStream());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            response.getWriter().println("Order not found, try again");
        }
    }
}
