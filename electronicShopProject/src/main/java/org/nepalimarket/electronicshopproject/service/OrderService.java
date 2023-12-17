package org.nepalimarket.electronicshopproject.service;

import org.nepalimarket.electronicshopproject.dao.OrderDAO;
import org.nepalimarket.electronicshopproject.dao.ProductDAO;
import org.nepalimarket.electronicshopproject.model.Order;
import org.nepalimarket.electronicshopproject.model.Product;
import org.nepalimarket.electronicshopproject.utils.DatabaseUtils;

import java.sql.Connection;
import java.util.List;

public class OrderService {
    private final OrderDAO orderDAO;
    private final ProductDAO productDAO;

    private final ProductService productService;

    public OrderService() throws Exception {
        Connection conn = DatabaseUtils.getConnection();
        this.orderDAO = new OrderDAO(conn);
        this.productDAO = new ProductDAO();
        this.productService = new ProductService ();
    }

    public void saveOrderPlacedByCustomer(Order order) {
        order = orderDAO.placeOrder(order);

        // Update product quantity by subtracting the ordered quantity
        productDAO.updateProductQuantity(order.getProductName(), order.getQuantity());

        System.out.println("Order placed successfully. Order ID: " + order.getOrderId());
    }

    public int getProductIdByName(String productName) {
        Product product = productService.getProductByName(productName);
        if (product != null) {
            return product.getProductId (); // Assuming getId() returns the product_id from the database
        }
        return 0; // Default to 0 if product is not found (you should handle this case appropriately)
    }

    public List<Order> getOrdersByCustomerId(int customerId) {
        return orderDAO.getOrdersByCustomerId(customerId);
    }


    // Add this method to your OrderService class
    public Order placeOrder(int customerId, String productName, int quantity) {
        // Assuming you have logic to calculate price and total price based on the product name
        double pricePerUnit = calculatePricePerUnit(productName);
        double totalPrice = calculateTotalPrice(quantity, pricePerUnit);

        // Check if the product is available in sufficient quantity
        if (!isProductAvailable(productName, quantity)) {
            // Product not available in sufficient quantity
            throw new RuntimeException("Product not available in sufficient quantity.");
        }

        int productId = getProductIdByName ( productName );

        Order newOrder = new Order(customerId,productId, productName, quantity, pricePerUnit, totalPrice);


        // Set the fetched product_id in the order
        newOrder.setProductId(productId);

        // save the order to the database
        newOrder = orderDAO.placeOrder ( newOrder );

        // Update product quantity
        updateProductQuantity(productName, quantity);

        return newOrder;
    }

    private double calculateTotalPrice ( int quantity, double pricePerUnit ) {

        return pricePerUnit * quantity;
    }

    // Add any additional methods or logic as needed
    private double calculatePricePerUnit(String productName) {
        Product product = productService.getProductByName(productName);
        if (product != null) {
            return product.getPrice(); // Assuming getPrice() returns the actual price from the database
        }
        return 0.0; // Default to 0.0 if product is not found (you should handle this case appropriately)
    }

    // Modify this method to retrieve the actual available quantity from the database
    private boolean isProductAvailable(String productName, int orderQty) {
        Product product = productService.getProductByName(productName);
        return product != null && product.getQtyAvailable() >= orderQty;
    }




    // Add this method to your OrderService class
    private void updateProductQuantity(String productName, int orderQty) {
        Product product = productService.getProductByName(productName);
        if (product != null) {
            int newQtyAvailable = product.getQtyAvailable() - orderQty;
            productService.updateProductQuantity(productName, newQtyAvailable);
        }
    }


    public Order getOrderById ( int orderIdFromRequest ) {
        //TODO implement for pdf generator
        return null;
    }
}
