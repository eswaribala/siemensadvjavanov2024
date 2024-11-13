package com.siemens.registrationapi.dtos;

import com.siemens.registrationapi.models.FullName;
import com.siemens.registrationapi.models.Gender;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAccountRequest {

    private long userId;


    private FullName fullName;


    private LocalDate dob;
    @NotNull(message = "email cannot be null")
    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "Email must contain @ ")

    private String email;


    private long phoneNo;

    private String userName;
    @NotNull(message = "password cannot be null")
    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$", message = "Password must contain one lower, one upper one digit and minimum 8 chars  ")

    private String password;


    private Gender gender;
}
