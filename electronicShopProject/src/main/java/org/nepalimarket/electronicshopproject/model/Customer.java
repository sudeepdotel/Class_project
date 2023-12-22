package org.nepalimarket.electronicshopproject.model;

public class Customer {
    private int customerId;
    private String username;
    private String password;
    private String email;
    private String fullName;

    // Constructors, getters, and setters

    // Constructor without customerId (for insertion)
    public Customer(String username, String password, String email, String fullName) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.fullName = fullName;
    }

    // Constructor with customerId (for retrieval)
    public Customer(int customerId, String username, String password, String email, String fullName) {
        this.customerId = customerId;
        this.username = username;
        this.password = password;
        this.email = email;
        this.fullName = fullName;
    }

    public Customer ( ) {
    }

    public int getCustomerId ( ) {
        return customerId;
    }

    public void setCustomerId ( int customerId ) {
        this.customerId = customerId;
    }

    public String getUsername ( ) {
        return username;
    }

    public void setUsername ( String username ) {
        this.username = username;
    }

    public String getPassword ( ) {
        return password;
    }

    public void setPassword ( String password ) {
        this.password = password;
    }

    public String getEmail ( ) {
        return email;
    }

    public void setEmail ( String email ) {
        this.email = email;
    }

    public String getFullName ( ) {
        return fullName;
    }

    public void setFullName ( String fullName ) {
        this.fullName = fullName;
    }

    // Getters and setters

}
