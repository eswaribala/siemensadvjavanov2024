package com.siemens.facades;

@FunctionalInterface
public interface OTPGenerator {
    int getOTP(int min,int max);

}
