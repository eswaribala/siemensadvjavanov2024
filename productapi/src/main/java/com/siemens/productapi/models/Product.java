package com.siemens.productapi.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.codecs.pojo.annotations.BsonId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "products")
public class Product {
    @Id
    @Field("Product_Id")
    @Indexed(unique = true)
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
