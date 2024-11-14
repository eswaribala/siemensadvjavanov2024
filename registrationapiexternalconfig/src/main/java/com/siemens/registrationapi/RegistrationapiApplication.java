package com.siemens.registrationapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class RegistrationapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(RegistrationapiApplication.class, args);
    }

}
