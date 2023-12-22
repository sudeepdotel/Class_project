package org.electronicShop.model;

public class Order {

    private int orderId;
    private String productName;
    private int qty;
    private double price;
    private double totalPrice;
    private double discount;

    public int getOrderId ( ) {
        return orderId;
    }

    public void setOrderId ( int orderId ) {
        this.orderId = orderId;
    }

    public String getProductName ( ) {
        return productName;
    }

    public void setProductName ( String productName ) {
        this.productName = productName;
    }

    public int getQty ( ) {
        return qty;
    }

    public void setQty ( int qty ) {
        this.qty = qty;
    }

    public double getPrice ( ) {
        return price;
    }

    public void setPrice ( double price ) {
        this.price = price;
    }

    public double getTotalPrice ( ) {
        return totalPrice;
    }

    public void setTotalPrice ( double totalPrice ) {
        this.totalPrice = totalPrice;
    }

    public double getDiscount ( ) {
        return discount;
    }

    public void setDiscount ( double discount ) {
        this.discount = discount;
    }
}
