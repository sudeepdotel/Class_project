package org.nepalimarket.electronicshopproject.dao;

import org.nepalimarket.electronicshopproject.model.Product;
import org.nepalimarket.electronicshopproject.utils.DatabaseUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    private Connection connection;


    public ProductDAO() throws Exception {
        // Initialize your database connection (modify accordingly)
        this.connection = DatabaseUtils.getConnection();

    }

    public Product searchProductByName(String searchName) {
        String sql = "SELECT * FROM products WHERE name=?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, searchName);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Product product = new Product (  );
                product.setProductId(rs.getInt("product_id"));
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

        try (Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {

            while (rs.next()) {
                Product product = new Product (  );
                product.setProductId(rs.getInt("product_id"));
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

    public void updateProductQuantity(String productName, int quantity) {
        String updateSql = "UPDATE products SET qty_available = qty_available - ? WHERE name = ?";

        try (PreparedStatement ps = connection.prepareStatement(updateSql)) {
            ps.setInt(1, quantity);
            ps.setString(2, productName);

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
