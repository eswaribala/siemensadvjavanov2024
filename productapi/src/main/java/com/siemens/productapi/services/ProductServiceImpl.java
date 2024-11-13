package com.siemens.productapi.services;

import com.siemens.productapi.exceptions.ProductInstanceNotAvailable;
import com.siemens.productapi.exceptions.ProductNotAvailable;
import com.siemens.productapi.models.Product;
import com.siemens.productapi.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;
    @Override
    public Product addProduct(Product product) {
        if(product!=null)
           return productRepository.save(product);
        else
            throw new ProductInstanceNotAvailable("Product Instance Not Available...");

    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(long productId) {
        return productRepository.findProductByProductId(productId).orElseThrow(()->new ProductNotAvailable("Product not found.... "));
    }

    @Override
    public Product updateProduct(long productId, long cost) {
        Product product=getProductById(productId);
        if(product!=null) {
            product.setCost(cost);
            return productRepository.save(product);
        }else
            throw new ProductInstanceNotAvailable("Product Instance Not Available...");

    }

    @Override
    public boolean deleteProduct(long productId) {
        boolean status=false;
        Product product=getProductById(productId);
        if(product!=null) {
            productRepository.deleteProductByProductId(productId);
            status=true;
        }
        return status;
    }
}
