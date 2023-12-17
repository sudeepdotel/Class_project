package org.nepalimarket.electronicshopproject.model;

public class Product {
    private int productId;
    private String name;
    private String description;
    private double price;
    private int qtyAvailable;

    // Constructors, getters, and setters

    // Constructor without productId (for insertion)
    public Product(String name, String description, double price, int qtyAvailable) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.qtyAvailable = qtyAvailable;
    }

    // Constructor with productId (for retrieval)
    public Product(int productId, String name, String description, double price, int qtyAvailable) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.qtyAvailable = qtyAvailable;
    }

    public Product ( ) {

    }


    // Getters and setters

    public int getProductId ( ) {
        return productId;
    }

    public void setProductId ( int productId ) {
        this.productId = productId;
    }

    public String getName ( ) {
        return name;
    }

    public void setName ( String name ) {
        this.name = name;
    }

    public String getDescription ( ) {
        return description;
    }

    public void setDescription ( String description ) {
        this.description = description;
    }

    public double getPrice ( ) {
        return price;
    }

    public void setPrice ( double price ) {
        this.price = price;
    }

    public int getQtyAvailable ( ) {
        return qtyAvailable;
    }

    public void setQtyAvailable ( int qtyAvailable ) {
        this.qtyAvailable = qtyAvailable;
    }
}
