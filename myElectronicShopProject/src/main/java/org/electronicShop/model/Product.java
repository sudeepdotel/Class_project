package org.electronicShop.model;

public class Product {

    private int productId;
    private String name;
    private String description;
    private double price;
    private int qtyAvailable;

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
