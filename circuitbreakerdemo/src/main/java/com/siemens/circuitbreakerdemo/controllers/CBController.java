package com.siemens.circuitbreakerdemo.controllers;

import com.siemens.circuitbreakerdemo.services.CBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cbcalls")
public class CBController {

    @Autowired
    private CBService cbService;

    @GetMapping("/v1.0")
    public String getUserAccounts(){
        return cbService.getUserAccounts();

    }

}
