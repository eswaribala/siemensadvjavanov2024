package com.siemens.registrationapi.services;

import com.siemens.registrationapi.models.UserAccount;

import java.util.List;

public interface UserAccountService {
    UserAccount saveUserAccount(UserAccount userAccount);
    List<UserAccount> getAllUserAccounts();
    UserAccount getUserAccountById(long userId);
    UserAccount getUserAccountByPhoneNo(long phoneNo);
    UserAccount updateUserAccountEmail(long userId, String emailAddress);
    boolean deleteUserAccountById(long userId);
}
