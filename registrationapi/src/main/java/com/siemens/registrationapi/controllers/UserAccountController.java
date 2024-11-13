package com.siemens.registrationapi.controllers;

import com.siemens.registrationapi.dtos.GenericResponse;
import com.siemens.registrationapi.dtos.UserAccountRequest;
import com.siemens.registrationapi.models.FullName;
import com.siemens.registrationapi.models.UserAccount;
import com.siemens.registrationapi.services.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("useraccounts")
public class UserAccountController {

    @Autowired
    private UserAccountService userAccountService;

    @PostMapping("/v1.0")
   public ResponseEntity<GenericResponse> saveUserAccount(@RequestBody UserAccountRequest userAccountRequest){

       UserAccount userAccount=UserAccount.builder()
               .dob(userAccountRequest.getDob())
               .userName(userAccountRequest.getUserName())
               .password(userAccountRequest.getPassword())
               .phoneNo(userAccountRequest.getPhoneNo())
               .gender(userAccountRequest.getGender())
               .email(userAccountRequest.getEmail())
               .fullName(FullName.builder()
                       .firstName(userAccountRequest.getFullName().getFirstName())
                       .lastName(userAccountRequest.getFullName().getLastName())
                       .build())
               .build();

      UserAccount userAccountResponse= userAccountService.saveUserAccount(userAccount);

      return ResponseEntity.status(HttpStatus.CREATED).body(new GenericResponse<UserAccount>(userAccountResponse));

   }

}
