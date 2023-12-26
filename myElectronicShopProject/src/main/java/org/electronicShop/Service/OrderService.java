package org.electronicShop.Service;

import org.electronicShop.model.Order;
import org.electronicShop.utils.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class OrderService {
    private Connection conn;

    public OrderService ( ) {
        this.conn = DbConnection.getConnection ( );
    }

    public void saveOrderPlacedBYCustomer ( Order order ) {
        String sql = "INSERT INTO orders (product_name, qty, price, total_price, discount) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement ps = conn.prepareStatement ( sql, PreparedStatement.RETURN_GENERATED_KEYS )) {
            ps.setString ( 1, order.getProductName ( ) );
            ps.setInt ( 2, order.getQty ( ) );
            ps.setDouble ( 3, order.getPrice ( ) );
            ps.setDouble ( 4, order.getTotalPrice ( ) );
            ps.setDouble ( 5, order.getDiscount ( ) );

            int affectedRows = ps.executeUpdate ( );
            if (affectedRows == 0) {

                throw new SQLException ( "Placing order failed, no rows affected." );
            }
            try (ResultSet generatedKeys = ps.getGeneratedKeys ( )) {
                if (generatedKeys.next ( )) {
                    int orderId = generatedKeys.getInt ( 1 );
                    order.setOrderId ( orderId );
                } else {
                    throw new SQLException ( "Placing order failed, no ID obtained." );
                }
            }
            // Update product quantity
            updateProductQuantity ( order.getProductName ( ), order.getQty ( ) );

            System.out.println ( "Order placed successfully. Order ID: " + order.getOrderId ( ) );

        } catch (SQLException e) {
            e.printStackTrace ( );
        }
    }

    private void updateProductQuantity ( String productName, int orderQty ) {
        String updateSql = "UPDATE products SET qty_available = qty_available - ? WHERE name = ?";

        try (PreparedStatement ps = conn.prepareStatement ( updateSql )) {
            ps.setInt ( 1, orderQty );
            ps.setString ( 2, productName );

            ps.executeUpdate ( );
        } catch (SQLException e) {
            e.printStackTrace ( );
        }
    }

    public Order getOrderById ( int orderId ) {
        //TODO implement get order by id
        String getIdSql = "SELECT * FROM orders where id=?";

        try (PreparedStatement ps = conn.prepareStatement ( getIdSql )) {
            ps.setInt ( 1, orderId );

            ResultSet rs = ps.executeQuery ( );
            if (rs.next ( )) {
                Order order = new Order ( );
                order.setOrderId ( rs.getInt ( "id" ) );
                order.setProductName ( rs.getString ( "product_name" ) );
                order.setQty ( rs.getInt ( "qty" ) );
                order.setPrice ( rs.getDouble ( "price" ) );
                order.setTotalPrice ( rs.getDouble ( "total_price" ) );
                order.setDiscount ( rs.getDouble ( "discount" ) );
                return order;
            }

        } catch (SQLException e) {
            throw new RuntimeException ( e );
        }
        return null;
    }
}
