package com.siemens.registrationapi.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name="UserAccount")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserAccount implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="User_Id")
    private long userId;

    @Embedded
    private FullName fullName;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name="DOB")
    private LocalDate dob;
    @Column(name="Email",nullable = false,length = 150)
    private String email;

    @Column(name="Phone_No")
    private long phoneNo;
    @Column(name="User_Name",nullable = false,length = 50)
    private String userName;
    @Column(name="Password",nullable = false,length = 10)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name="Gender",nullable = false,length = 20)
    private Gender gender;


}
