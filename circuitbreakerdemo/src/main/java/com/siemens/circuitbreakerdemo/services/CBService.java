package com.siemens.circuitbreakerdemo.services;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
@Slf4j
public class CBService {
    @Autowired
    private RestClient restClient;

    @Value("${serviceUrl}")
    private String serviceUrl;
    @Value("${alternativeServiceUrl}")
    private String fallbackUrl;

    @Value("${serviceUrl1}")
    private String serviceUrl1;
    @Value("${alternativeServiceUrl1}")
    private String fallbackUrl1;

    @CircuitBreaker(name = "gatewayCircuitBreaker", fallbackMethod = "fallback")
    @Retry(name = "gatewayRetry")
    @RateLimiter(name="gatewayRateLimiter")
    public String getUserAccounts(){
        log.info("Entering into Accounts API call...");
       return restClient
               .get()
               .uri(serviceUrl)
               .retrieve()
               .body(String.class);

    }

    public String fallback(Exception e){
        log.info("Entering into Fallback Accounts API call...");
        return restClient
                .get()
                .uri(fallbackUrl)
                .retrieve()
                .body(String.class);
    }

    @CircuitBreaker(name = "gatewayCircuitBreaker", fallbackMethod = "fallback1")
    @Retry(name = "gatewayRetry")
    @RateLimiter(name="gatewayRateLimiter")
    public String getUsersV1(){
        log.info("Entering into Accounts API call...");
        return restClient
                .get()
                .uri(serviceUrl1)
                .retrieve()
                .body(String.class);

    }

    public String fallback1(Exception e){
        log.info("Entering into Fallback Accounts API call...");
        return restClient
                .get()
                .uri(fallbackUrl1)
                .retrieve()
                .body(String.class);
    }
}