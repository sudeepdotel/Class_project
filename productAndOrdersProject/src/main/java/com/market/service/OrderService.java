package com.market.service;

import com.market.model.Orders;
import com.market.utils.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class OrderService {
    private Connection conn;

    public OrderService() {
        this.conn = DbConnection.getConnection();
    }

    public void placeOrder(Orders order) {

        System.out.println("Order placed successfully:");
        System.out.println("Product Name: " + order.getProductName());
        System.out.println("Quantity: " + order.getQty());
        System.out.println("Price: $" + order.getPrice());
        System.out.println("Total Price: $" + order.getTotalPrice());
        System.out.println("Discount: $" + order.getDiscount());

        // Save the order to the database
        saveOrder(order);
    }

    public Orders getOrderById(int orderId) {
        // TODO: Implement logic to retrieve order details by ID from the database

        return null;
    }

    public void saveOrder(Orders order) {
        String sql = "INSERT INTO orders (product_name, quantity, price, total_price, discount) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, order.getProductName());
            ps.setInt(2, order.getQty());
            ps.setDouble(3, order.getPrice());
            ps.setDouble(4, order.getTotalPrice());
            ps.setDouble(5, order.getDiscount());

            int affectedRows = ps.executeUpdate();
            if (affectedRows > 0) {
                ResultSet generatedKeys = ps.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int orderId = generatedKeys.getInt(1);
                    System.out.println("Order ID: " + orderId);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
