package com.siemens.productapi.controllers;

import com.siemens.productapi.dtos.GenericResponse;
import com.siemens.productapi.dtos.ProductRequest;
import com.siemens.productapi.models.Product;
import com.siemens.productapi.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {

    @Autowired
    private ProductService productService;

   @PostMapping("/v1.0")
   public ResponseEntity<GenericResponse> saveProduct(@Valid @RequestBody ProductRequest productRequest){

       Product product=Product.builder()
               .productId(productRequest.getProductId())
               .name(productRequest.getName())
               .cost(productRequest.getCost())
               .unit(productRequest.getUnit())
               .description(productRequest.getDescription())
               .build();

      Product productResponse= productService.addProduct(product);

      return ResponseEntity.status(HttpStatus.CREATED).body(new GenericResponse<Product>(productResponse));

   }

   @GetMapping("/v1.0")
   public ResponseEntity<GenericResponse> findAllProducts(){
       return ResponseEntity.status(HttpStatus.OK).body(new GenericResponse<List<Product>>(productService.getAllProducts()));
   }

    @GetMapping("/v1.0/{productId}")
    public ResponseEntity<GenericResponse> findProductById(@PathVariable("productId") long productId){
        return ResponseEntity.status(HttpStatus.OK).body(new GenericResponse<Product>(productService.getProductById(productId)));
    }


    @PutMapping("/v1.0")
    public ResponseEntity<GenericResponse> updateProductCost(@RequestParam("productId") long productId, @RequestParam("cost") long cost){
        return ResponseEntity.status(HttpStatus.CREATED).body(new GenericResponse<Product>(productService.updateProduct(productId,cost)));
    }
    @DeleteMapping("/v1.0")
    public ResponseEntity<GenericResponse> deleteProduct(@RequestParam("productId") long productId){
       if(productService.deleteProduct(productId))
           return ResponseEntity.status(HttpStatus.OK).body(new GenericResponse<String>("Product Deleted"));
       else
           return ResponseEntity.status(HttpStatus.OK).body(new GenericResponse<String>("Product Not Exist to Delete"));

    }
}
