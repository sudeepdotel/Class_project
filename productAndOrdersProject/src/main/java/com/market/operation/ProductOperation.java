package com.market.operation;

import com.market.model.Products;
import com.market.service.ProductService;

import java.util.Scanner;

public class ProductOperation {
    private ProductService productService;

    public ProductOperation(ProductService productService) {
        this.productService = productService;
    }

    public void registerProduct(Scanner scanner) {
        try {
            System.out.println("Enter product details:");

            Products product = new Products();
            System.out.print("Name: ");
            product.setName(scanner.nextLine());

            System.out.print("Description: ");
            product.setDescription(scanner.nextLine());

            System.out.print("Price: ");
            while (!scanner.hasNextDouble()) {
                System.out.println("Invalid input. Please enter a valid price.");
                scanner.next(); // Consume the invalid input
            }
            product.setPrice(scanner.nextDouble());

            System.out.print("Quantity Available: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a valid quantity.");
                scanner.next(); // Consume the invalid input
            }
            product.setQtyAvailable(scanner.nextInt());

            productService.registerProduct();
            System.out.println("Product registered successfully.");
        } catch (Exception e) {
            System.out.println("An error occurred while registering the product. Please try again.");
            // Log the exception for debugging purposes
            e.printStackTrace();
        }
    }

    public void searchProducts(Scanner scanner) {
        System.out.print("Enter product name to search: ");
        String searchName = scanner.next();

        Products product = productService.searchProductByName(searchName);

        if (product != null) {
            System.out.println("Product found:");
            System.out.println("ID: " + product.getId());
            System.out.println("Name: " + product.getName());
            System.out.println("Description: " + product.getDescription());
            System.out.println("Price: $" + product.getPrice());
            System.out.println("Quantity Available: " + product.getQtyAvailable());
        } else {
            System.out.println("Product not found.");
        }
    }

    private static void searchProducts(Scanner scanner, ProductService productService) {
        System.out.print("Enter product name to search: ");
        String searchName = scanner.next();

        Products product = productService.searchProductByName(searchName);

        if (product != null) {
            System.out.println("Product found:");
            System.out.println("ID: " + product.getId());
            System.out.println("Name: " + product.getName());
            System.out.println("Description: " + product.getDescription());
            System.out.println("Price: $" + product.getPrice());
            System.out.println("Quantity Available: " + product.getQtyAvailable());
        } else {
            System.out.println("Product not found.");
        }
    }
}
