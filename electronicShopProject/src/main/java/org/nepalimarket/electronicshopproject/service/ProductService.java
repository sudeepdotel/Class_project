package org.nepalimarket.electronicshopproject.service;

import org.nepalimarket.electronicshopproject.dao.ProductDAO;
import org.nepalimarket.electronicshopproject.model.Product;

import java.util.List;

public class ProductService {
    private final ProductDAO productDAO;

    public ProductService() throws Exception {
        this.productDAO = new ProductDAO();
    }

    public Product getProductByName(String searchName) {
        // Implement logic to call DAO method
        return productDAO.searchProductByName(searchName);
    }

    public List<Product> getAllProducts() {
        // Implement logic to call DAO method
        return productDAO.getAllProducts();
    }



    public void updateProductQuantity(String productName, int newQtyAvailable) {
        productDAO.updateProductQuantity(productName, newQtyAvailable);
    }
}
