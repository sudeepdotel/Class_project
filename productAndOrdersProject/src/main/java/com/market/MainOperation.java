package com.market;

import com.market.model.Orders;
import com.market.model.Products;
import com.market.service.OrderService;
import com.market.service.ProductService;
import com.market.operation.OrderOperation;

import java.util.Scanner;

public class MainOperation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductService productService = new ProductService();
        OrderService orderService = new OrderService();
        OrderOperation orderOperation = new OrderOperation(productService, orderService);

        while (true) {
            System.out.println("1. Admin - Register Product");
            System.out.println("2. Customer - Search Products");
            System.out.println("3. Customer - Place Order");
            System.out.println("4. Generate Bill (PDF)");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    productService.registerProduct();
                    break;
                case 2:
                    ProductService.searchProducts(scanner, productService);
                    break;
                case 3:
                    // Call the placeOrder method from OrderOperation
                    orderOperation.placeOrder(scanner);
                    break;
                case 4:

                    System.out.print("Enter Order ID to generate bill: ");
                    int orderId = scanner.nextInt();
                   // orderService.generateBillPDF(orderId);
                    break;
                case 0:
                    System.out.println("Exiting the application.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
