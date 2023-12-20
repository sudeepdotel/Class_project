package org.nepalimarket.electronicshopproject.service;

import org.nepalimarket.electronicshopproject.dao.CustomerDAO;
import org.nepalimarket.electronicshopproject.model.Customer;
import org.nepalimarket.electronicshopproject.utils.DatabaseUtils;

import java.sql.Connection;

public class LoginService {
    private final CustomerDAO customerDAO;
    public LoginService() throws Exception {
        Connection conn = DatabaseUtils.getConnection();
        this.customerDAO = new CustomerDAO (conn);
    }
    public Customer authenticateUser( String username, String password) {
        // Add logic to authenticate user (check username and password)
        return customerDAO.getCustomerByUsernameAndPassword(username, password);
    }
}
