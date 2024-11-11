package com.siemens.facades;

import com.github.javafaker.Faker;

@FunctionalInterface
public interface Generator {
    int getOTP(int min,int max);

    static String getName(){
        return new Faker().name().firstName();
    }
}
