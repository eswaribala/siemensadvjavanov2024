package com.siemens.registrationapi.repositories;

import com.siemens.registrationapi.models.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserAccountRepository extends JpaRepository<UserAccount,Long> {


    @Query("from UserAccount userAccount where userAccount.phoneNo = :phoneNo")
    List<UserAccount> findUserAccountByPhoneNo(@Param("phoneNo") long phoneNo);
}
