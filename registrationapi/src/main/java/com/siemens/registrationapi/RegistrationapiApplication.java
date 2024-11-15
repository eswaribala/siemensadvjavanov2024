package com.siemens.registrationapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class RegistrationapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(RegistrationapiApplication.class, args);
    }

}
