package com.siemens.productapi.repositories;

import com.siemens.productapi.models.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ProductRepository extends MongoRepository<Product,Long> {

    Optional<Product> findProductByProductId(long productId);
    long deleteProductByProductId(long productId);

}
