package org.nepalimarket.electronicshopproject.dao;

import org.nepalimarket.electronicshopproject.model.Order;
import org.nepalimarket.electronicshopproject.service.OrderService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {
    private final Connection conn;


    public OrderDAO(Connection conn) {
        this.conn = conn;
    }

    public Order saveOrderPlacedBYCustomer(Order order) {
        String sql = "INSERT INTO orders (customer_id,product_id, product_name, quantity, price_per_unit, total_price) VALUES (?,?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, order.getCustomerId());
            ps.setInt ( 2,order.getProductId () );
            ps.setString(3, order.getProductName());
            ps.setInt(4, order.getQuantity());
            ps.setDouble(5, order.getPricePerUnit());
            ps.setDouble(6, order.getTotalPrice());

            int affectedRows = ps.executeUpdate();
            if (affectedRows > 0) {
                ResultSet generatedKeys = ps.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int orderId = generatedKeys.getInt(1);
                    order.setOrderId(orderId);
                }
            }

            // update product quantity to product table
            updateProductQuantity ( order.getProductName ( ), order.getQuantity ( ) );

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
    }

    public List<Order> getOrdersByCustomerId(int customerId) {
        ArrayList<Order> orders = new ArrayList<>();

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
        int productId = rs.getInt ( "product_id" );
        String productName = rs.getString("product_name");
        int quantity = rs.getInt("quantity");
        double pricePerUnit = rs.getDouble("price_per_unit");
        double totalPrice = rs.getDouble("total_price");
        Timestamp orderDate = rs.getTimestamp("order_date");
        return new Order(orderId, customerId,productId, productName, quantity, pricePerUnit, totalPrice, orderDate);
    }

    private void updateProductQuantity ( String productName, int orderQty ) {
        String updateSql = "UPDATE products SET qty_available = qty_available - ? WHERE name = ?";

        try (PreparedStatement ps = conn.prepareStatement ( updateSql )) {
            ps.setInt ( 1, orderQty );
            ps.setString ( 2, productName );

            int rowsUpdated = ps.executeUpdate();
            System.out.println(rowsUpdated + " rows updated in products table.");

        } catch (SQLException e) {
            e.printStackTrace ( );
        }
    }

}
