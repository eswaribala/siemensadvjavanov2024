package com.siemens.registrationapi.services;


import com.siemens.registrationapi.exceptions.UserAccountNotFoundException;
import com.siemens.registrationapi.exceptions.UserAccountNullException;
import com.siemens.registrationapi.models.UserAccount;
import com.siemens.registrationapi.repositories.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    @Autowired
    private UserAccountRepository userAccountRepository;

    @Override
    public UserAccount saveUserAccount(UserAccount userAccount) {
        if(userAccount!=null)
            return this.userAccountRepository.save(userAccount);
        else
          throw new UserAccountNullException("User Account Instance Not Available");
    }


    @Override
    public List<UserAccount> getAllUserAccounts() {
        return this.userAccountRepository.findAll();
    }

    @Override
    @Cacheable(cacheNames = "useraccounts",key = "#userId")
    public UserAccount getUserAccountById(long userId) {
        return userAccountRepository.findById(userId)
                .orElseThrow(()->new UserAccountNotFoundException("User Account Not Found"));
    }

    @Override
    public List<UserAccount> getUserAccountByPhoneNo(long phoneNo) {
        return userAccountRepository.findUserAccountByPhoneNo(phoneNo);
    }

    @Override
    @CachePut(cacheNames = "useraccounts")
    public UserAccount updateUserAccountEmail(long userId, String emailAddress) {

        UserAccount userAccount=getUserAccountById(userId);
        userAccount.setEmail(emailAddress);
        return userAccountRepository.save(userAccount);
    }

    @Override
    @CacheEvict(cacheNames = "useraccounts",allEntries = true)
    public boolean deleteUserAccountById(long userId) {
        boolean status=false;
        UserAccount userAccount=getUserAccountById(userId);
        userAccountRepository.deleteById(userId);
        status=true;
        return status;
    }
}
