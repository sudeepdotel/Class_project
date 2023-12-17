package org.nepalimarket.electronicshopproject.dao;

import org.nepalimarket.electronicshopproject.model.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {
    private final Connection conn;

    public OrderDAO(Connection conn) {
        this.conn = conn;
    }

    public Order placeOrder(Order order) {
        String sql = "INSERT INTO orders (customer_id, product_name, quantity, price_per_unit, total_price) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, order.getCustomerId());
            ps.setString(2, order.getProductName());
            ps.setInt(3, order.getQuantity());
            ps.setDouble(4, order.getPricePerUnit());
            ps.setDouble(5, order.getTotalPrice());

            int affectedRows = ps.executeUpdate();
            if (affectedRows > 0) {
                ResultSet generatedKeys = ps.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int orderId = generatedKeys.getInt(1);
                    order.setOrderId(orderId);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
    }



    public List<Order> getOrdersByCustomerId(int customerId) {
        List<Order> orders = new ArrayList<>();
        String sql = "SELECT * FROM orders WHERE customer_id=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, customerId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                orders.add(extractOrderFromResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    private Order extractOrderFromResultSet(ResultSet rs) throws SQLException {
        int orderId = rs.getInt("order_id");
        int customerId = rs.getInt("customer_id");
        String productName = rs.getString("product_name");
        int quantity = rs.getInt("quantity");
        double pricePerUnit = rs.getDouble("price_per_unit");
        double totalPrice = rs.getDouble("total_price");
        Timestamp orderDate = rs.getTimestamp("order_date");
        return new Order(orderId, customerId, productName, quantity, pricePerUnit, totalPrice, orderDate);
    }
}
