package com.siemens.productapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.codecs.pojo.annotations.BsonId;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "products")
public class Product {
    @BsonId
    @Field("Product_Id")
    private long productId;
    @Field("Product_Name")
    @TextIndexed
    private String name;
    @Field("Description")
    private String description;
    @Field("Cost")
    private long cost;
    @Field("Unit")
    private long unit;
}
