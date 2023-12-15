package org.electronicShop;
import org.electronicShop.DAO.OrderOperation;
import org.electronicShop.Service.OrderService;
import org.electronicShop.Service.PdfService;
import org.electronicShop.Service.ProductService;
import org.electronicShop.Service.ReceiptGenerator;
import org.electronicShop.model.Order;
import org.electronicShop.model.Product;

import java.util.List;
import java.util.Scanner;

public class MainOperation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductService productService = new ProductService();
        OrderService orderService = new OrderService();
        OrderOperation orderOperation = new OrderOperation(productService,orderService);

        while (true) {
            System.out.println("1. Admin - Register Product");
            System.out.println("2. Customer - Search Product by name");
            System.out.println("3. Customer - Place Order");
            System.out.println("4. Employee - pdf (Receipt)");
            System.out.println("5. Search our inventory");
            System.out.println("0. Checkout");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    productService.registerProduct();
                    break;

                case 2:
                    System.out.print("Enter product name to search: ");
                    String searchName = scanner.next();
                    productService.searchProductByName(searchName);
                    Product product = productService.searchProductByName(searchName);
                    if (product != null) {
                        System.out.println("Product found:");
                        System.out.println("ID: " + product.getProductId());
                        System.out.println("Name: " + product.getName());
                        System.out.println("Description: " + product.getDescription());
                        System.out.println("Price: $" + product.getPrice());
                        System.out.println("Quantity Available: " + product.getQtyAvailable());
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;

                case 3:
                      orderOperation.placeOrder(scanner,productService,orderService);
                    break;



//                case 4:
//                    System.out.println("Enter the order Id to generate receipt");
//                    int receiptId = scanner.nextInt();
//                    Order order = orderService.getOrderById(receiptId);
//
//                    if (order != null) {
//                        ReceiptGenerator.generateReceipt(order);
//                    } else {
//                        System.out.println("Order not found, try again!!");
//                    }
//                    break;

                case 5:
                    List<Product> productList = productService.getAllProducts();
                    if (!productList.isEmpty()) {
                        System.out.println("All Products:");
                        for (Product products : productList) {
                            System.out.println("Product ID: " + products.getProductId());
                            System.out.println("Name: " + products.getName());
                            System.out.println("Description: " + products.getDescription());
                            System.out.println("Price: $" + products.getPrice());
                            System.out.println("Quantity Available: " + products.getQtyAvailable());
                            System.out.println("---------------------------");
                        }
                    } else {
                        System.out.println("No products found.");
                    }
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