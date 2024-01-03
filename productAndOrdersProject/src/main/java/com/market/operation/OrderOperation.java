package com.market.operation;

import com.market.model.Orders;
import com.market.model.Products;
import com.market.service.OrderService;
import com.market.service.ProductService;

import java.util.Scanner;

public class OrderOperation {

    private ProductService productService;
    private OrderService orderService;

    public OrderOperation(ProductService productService, OrderService orderService) {
        this.productService = productService;
        this.orderService = orderService;
    }

    public void placeOrder(Scanner scanner) {
        System.out.print("Enter product name to place an order: ");
        String productName = scanner.next();
        Products product = productService.searchProductByName(productName);

        if (product == null) {
            System.out.println("Product not found.");
            return;
        }

        if (product.getQtyAvailable() == 0) {
            System.out.println("Product is out of stock. Cannot place an order.");
            return;
        }

        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();

        if (quantity <= 0 || quantity > product.getQtyAvailable()) {
            System.out.println("Invalid quantity. Please enter a valid quantity.");
            return;
        }

        Orders order = new Orders();
        order.setProductName(product.getName());
        order.setQty(quantity);
        order.setPrice(product.getPrice());
        order.setTotalPrice(order.getQty() * order.getPrice());

        order.setDiscount(10.0);

        orderService.placeOrder(order);

        // Update product quantity
        product.setQtyAvailable(product.getQtyAvailable() - quantity);

        System.out.println("Order placed successfully.");
    }
}
