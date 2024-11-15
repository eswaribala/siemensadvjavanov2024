package com.siemens.registrationapi.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name="BiilingAddress")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BillingAddress implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Address_Id")
    private long addressId;
    @Column(name="Door_No", nullable = false,length = 5)
    private String doorNo;
    @Column(name="Street_Name", nullable = false,length = 150)
    private String streetName;
    @Column(name="City", nullable = false,length = 150)
    private String city;
    @Column(name="State", nullable = false,length = 150)
    private String state;
    @Column(name="Country", nullable = false,length = 150)
    private String country;
    @Column(name="Pincode")
    private long pinCode;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(foreignKey = @ForeignKey(name = "User_Id"),
            name = "User_Id_FK")
    private UserAccount userAccount;
}
