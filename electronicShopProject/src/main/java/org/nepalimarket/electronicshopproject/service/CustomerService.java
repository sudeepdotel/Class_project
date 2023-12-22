package org.nepalimarket.electronicshopproject.service;

import org.nepalimarket.electronicshopproject.dao.CustomerDAO;
import org.nepalimarket.electronicshopproject.model.Customer;
import org.nepalimarket.electronicshopproject.utils.DatabaseUtils;

import java.sql.Connection;

public class CustomerService {
    private final CustomerDAO customerDAO;

    public CustomerService() throws Exception {
        Connection conn = DatabaseUtils.getConnection();
        this.customerDAO = new CustomerDAO(conn);
    }
    public Customer registerCustomer(String username, String password, String email, String fullName) {
        Customer newCustomer = new Customer(username, password, email, fullName);
        return customerDAO.insertCustomer(newCustomer);
    }
    public Customer getCustomerByUsername(String username) {
        return customerDAO.getCustomerByUsername(username);
    }
    public int getCustomerId( ){
        return customerDAO.getCustomerById (  ).getCustomerId ( );

    }
}



