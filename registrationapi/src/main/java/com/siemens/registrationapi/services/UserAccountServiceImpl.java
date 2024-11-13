package com.siemens.registrationapi.services;


import com.siemens.registrationapi.models.UserAccount;
import com.siemens.registrationapi.repositories.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    @Autowired
    private UserAccountRepository userAccountRepository;

    @Override
    public UserAccount saveUserAccount(UserAccount userAccount) {
        return null;
    }

    @Override
    public List<UserAccount> getAllUserAccounts() {
        return null;
    }

    @Override
    public UserAccount getUserAccountById(long userId) {
        return null;
    }

    @Override
    public UserAccount getUserAccountByPhoneNo(long phoneNo) {
        return null;
    }

    @Override
    public UserAccount updateUserAccountEmail(long userId, String emailAddress) {
        return null;
    }

    @Override
    public boolean deleteUserAccountById(long userId) {
        return false;
    }
}
