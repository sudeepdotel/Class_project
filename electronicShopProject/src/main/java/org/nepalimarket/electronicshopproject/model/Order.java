package org.nepalimarket.electronicshopproject.model;

import java.sql.Timestamp;

public class Order {
    private int orderId;
    private int customerId;

    private int productId;


    private String productName;
    private int quantity;
    private double pricePerUnit;
    private double totalPrice;
    private Timestamp orderDate;

    // Constructors, getters, and setters

    // Constructor without orderId and orderDate (for insertion)
    public Order(int customerId,int productId, String productName, int quantity, double pricePerUnit, double totalPrice) {
        this.customerId = customerId;
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.pricePerUnit = pricePerUnit;
        this.totalPrice = totalPrice;

    }

    // Constructor with orderId and orderDate (for retrieval)
    public Order(int orderId, int customerId, String productName, int quantity, double pricePerUnit, double totalPrice, Timestamp orderDate) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.productName = productName;
        this.quantity = quantity;
        this.pricePerUnit = pricePerUnit;
        this.totalPrice = totalPrice;
        this.orderDate = orderDate;
    }
    public int getProductId ( ) {
        return productId;
    }

    public void setProductId ( int productId ) {
        this.productId = productId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }
}
