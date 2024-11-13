package com.siemens.productapi.services;

import com.siemens.productapi.models.Product;

import java.util.List;

public interface ProductService {
    Product addProduct(Product product);
    List<Product> getAllProducts();
    Product getProductById(long productId);
    Product updateProduct(long productId, long cost);
    boolean deleteProduct(long productId);

}
