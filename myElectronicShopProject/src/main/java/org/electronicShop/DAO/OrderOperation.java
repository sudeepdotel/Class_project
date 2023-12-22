package org.electronicShop.DAO;

import org.electronicShop.Service.OrderService;
import org.electronicShop.Service.PdfService;
import org.electronicShop.Service.ProductService;
import org.electronicShop.model.Order;
import org.electronicShop.model.Product;
import java.util.Scanner;


public class OrderOperation {

    private ProductService productService;
    private OrderService orderService;

    public OrderOperation ( ProductService productService, OrderService orderService ) {
        this.productService = productService;
        this.orderService = orderService;
    }

    public void placeOrder ( Scanner scanner, ProductService productService, OrderService orderService ) {
        System.out.print ( "Enter product name to place an order: " );
        String productName = scanner.next ( );
        Product product = productService.searchProductByName ( productName );

        if (product == null) {
            System.out.println ( "Product not found." );
            return;
        }

        if (product.getQtyAvailable ( ) == 0) {
            System.out.println ( "Product is out of stock. Cannot place an order." );
            return;
        }

        System.out.print ( "Enter quantity: " );
        int quantity = scanner.nextInt ( );

        if (quantity <= 0 || quantity > product.getQtyAvailable ( )) {
            System.out.println ( "Invalid quantity. Please enter a valid quantity." );
            return;
        }

        Order order = new Order ( );
        order.setProductName ( product.getName ( ) );
        order.setQty ( quantity );
        order.setPrice ( product.getPrice ( ) );
        order.setDiscount ( 10.0 );
        order.setTotalPrice ( order.getQty ( ) * order.getPrice ( ) - order.getDiscount ( ) );


        orderService.saveOrderPlacedBYCustomer ( order );

        System.out.println ( "Order placed successfully." );
    }

    public void generatePDF ( Scanner scanner, OrderService orderService, PdfService pdfService ) {
        pdfService.generatePDF ( scanner, orderService );
    }
}
