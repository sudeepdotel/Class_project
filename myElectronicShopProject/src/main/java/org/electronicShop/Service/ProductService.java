package org.electronicShop.Service;

import org.electronicShop.model.Product;
import org.electronicShop.utils.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductService {
    private Connection conn;
    private Scanner scanner;

    public ProductService() {
        this.conn = DbConnection.getConnection();
        this.scanner = new Scanner(System.in);
    }

    public void registerProduct() {
        try {
            System.out.println("Enter product details:");
            Product product = new Product();

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

            // Save the product to the database
            saveProduct(product);

            System.out.println("Product registered successfully.");

        } catch (Exception e) {
            System.out.println("An error occurred while registering the product. Please try again.");
            e.printStackTrace();
        }
    }


    private int saveProduct(Product product) {
        String sql = "INSERT INTO products (name, description, price, qty_available) VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, product.getName());
            ps.setString(2, product.getDescription());
            ps.setDouble(3, product.getPrice());
            ps.setInt(4, product.getQtyAvailable());

            int affectedRows = ps.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating product failed, no rows affected.");
            }

            // Return a status indicating success
            return 1;
        } catch (SQLException e) {
            e.printStackTrace();
            // Return a status indicating failure
            return -1;
        }
    }

    public Product searchProductByName(String searchName) {
        String sql = "SELECT * FROM products WHERE name=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, searchName);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Product product = new Product();
                product.setProductId(rs.getInt("id"));
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

    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM products";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Product product = new Product();
                product.setProductId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setDescription(rs.getString("description"));
                product.setPrice(rs.getDouble("price"));
                product.setQtyAvailable(rs.getInt("qty_available"));
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return products;
    }

}


