package com.siemens.registrationapi.repositories;

import com.siemens.registrationapi.models.BillingAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillingAddressRepository extends JpaRepository<BillingAddress,Long> {
}
