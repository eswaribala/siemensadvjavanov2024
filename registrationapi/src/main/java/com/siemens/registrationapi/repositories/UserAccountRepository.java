package com.siemens.registrationapi.repositories;

import com.siemens.registrationapi.models.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAccountRepository extends JpaRepository<UserAccount,Long> {
}
