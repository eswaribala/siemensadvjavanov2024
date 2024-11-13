package com.siemens.productapi.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {

    private long productId;

    @NotNull(message = "name cannot be null")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Product Name must contain only alphabets")
    private String name;

    private String description;

    private long cost;

    private long unit;


}
