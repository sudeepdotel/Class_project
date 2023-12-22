package org.electronicShop.Service;

import org.electronicShop.model.Order;

import java.util.Scanner;

public class PdfService {

    public void generatePdf ( Order order ) {
        // TODO: Implement PDF generation logic using a PDF library
        System.out.println ( "Generating PDF for Order ID: " + order.getOrderId ( ) );
        displayOrderDetails ( order );
    }

    public void generatePDF ( Scanner scanner, OrderService orderService ) {
        System.out.print ( "Enter Order ID to generate PDF: " );
        int orderId = scanner.nextInt ( );
        Order order = orderService.getOrderById ( orderId );
        if (order != null) {
            generatePdf ( order );
        } else {
            System.out.println ( "Order not found." );
        }
    }

    private void displayOrderDetails ( Order order ) {
        System.out.println ( "Order Details:" );
        System.out.println ( "Product Name: " + order.getProductName ( ) );
        System.out.println ( "Quantity: " + order.getQty ( ) );
        System.out.println ( "Price: $" + order.getPrice ( ) );
        System.out.println ( "Total Price: $" + order.getTotalPrice ( ) );
        System.out.println ( "Discount: $" + order.getDiscount ( ) );
    }


}
