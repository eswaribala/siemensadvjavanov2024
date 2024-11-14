package com.siemens.registrationapi.dtos;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FullNameRequest {
    @NotNull(message = "firstname cannot be null")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "First Name must contain only alphabets")
    private String firstName;
    @NotNull(message = "lastname cannot be null")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Last Name must contain only alphabets")

    private String lastName;
}
