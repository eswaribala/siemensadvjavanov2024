package com.siemens.productapi.repositories;

import com.siemens.productapi.models.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product,Long> {
}
