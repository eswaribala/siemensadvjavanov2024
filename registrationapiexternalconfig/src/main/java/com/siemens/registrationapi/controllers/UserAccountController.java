package com.siemens.registrationapi.controllers;

import com.siemens.registrationapi.dtos.GenericResponse;
import com.siemens.registrationapi.dtos.UserAccountRequest;
import com.siemens.registrationapi.models.FullName;
import com.siemens.registrationapi.models.UserAccount;
import com.siemens.registrationapi.services.UserAccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("useraccounts")
public class UserAccountController {

    @Autowired
    private UserAccountService userAccountService;

   @PostMapping("/v1.0")
   public ResponseEntity<GenericResponse> saveUserAccount(@Valid @RequestBody UserAccountRequest userAccountRequest){

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

   @GetMapping("/v1.0")
   public ResponseEntity<GenericResponse> findAllUserAccounts(){
       return ResponseEntity.status(HttpStatus.OK).body(new GenericResponse<List<UserAccount>>(userAccountService.getAllUserAccounts()));
   }

    @GetMapping("/v1.0/{userId}")
    public ResponseEntity<GenericResponse> findUserAccountById(@PathVariable("userId") long userId){
        return ResponseEntity.status(HttpStatus.OK).body(new GenericResponse<UserAccount>(userAccountService.getUserAccountById(userId)));
    }
    @GetMapping("/v1.0/filterByPhoneNo")
    public ResponseEntity<GenericResponse> findUserAccountByPhoneNo(@RequestParam("phoneNo") long phoneNo){
        return ResponseEntity.status(HttpStatus.OK).body(new GenericResponse<List<UserAccount>>(userAccountService.getUserAccountByPhoneNo(phoneNo)));
    }

    @PutMapping("/v1.0")
    public ResponseEntity<GenericResponse> updateUserAccountEmail(@RequestParam("userId") long userId, @RequestParam("email") String email){
        return ResponseEntity.status(HttpStatus.CREATED).body(new GenericResponse<UserAccount>(userAccountService.updateUserAccountEmail(userId,email)));
    }
    @DeleteMapping("/v1.0")
    public ResponseEntity<GenericResponse> deleteUserAccount(@RequestParam("userId") long userId){
       if(userAccountService.deleteUserAccountById(userId))
           return ResponseEntity.status(HttpStatus.OK).body(new GenericResponse<String>("User Account Deleted"));
       else
           return ResponseEntity.status(HttpStatus.OK).body(new GenericResponse<String>("User Account Not Exist to Delete"));

    }
}
