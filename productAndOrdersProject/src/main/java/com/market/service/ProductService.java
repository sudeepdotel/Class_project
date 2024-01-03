package com.market.service;

import com.market.model.Products;
import com.market.utils.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ProductService {
    private Connection conn;
    Scanner scanner = new Scanner(System.in);



    public ProductService() {
        this.conn = DbConnection.getConnection();
    }

    public Products registerProduct() {
        Products product = new Products();
        try {
            System.out.println("Enter product details:");


            System.out.print("Name: ");
            product.setName(scanner.nextLine());

            System.out.print("Description: ");
            product.setDescription(scanner.nextLine());

            System.out.print("Price: ");
            while (!scanner.hasNextDouble()) {
                System.out.println("Invalid input. Please enter a valid price.");
                scanner.next();
            }
            product.setPrice(scanner.nextDouble());

            System.out.print("Quantity Available: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a valid quantity.");
                scanner.next(); // Consume the invalid input
            }
            product.setQtyAvailable(scanner.nextInt());

            // Save product to the database
            saveProduct(product);
            System.out.println("Product registered successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return product;
    }

    public Products searchProductByName(String searchName) {
        String sql = "SELECT * FROM products WHERE name=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, searchName);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Products product = new Products();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setDescription(rs.getString("description"));
                product.setPrice(rs.getDouble("price"));
                product.setQtyAvailable(rs.getInt("qty_available"));

                return product;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }



    private void saveProduct(Products product) {
        String sql = "INSERT INTO products (name, description, price, qty_available) VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, product.getName());
            ps.setString(2, product.getDescription());
            ps.setDouble(3, product.getPrice());
            ps.setInt(4, product.getQtyAvailable());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void searchProducts(Scanner scanner, ProductService productService) {
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
