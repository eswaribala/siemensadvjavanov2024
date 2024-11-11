package com.siemens;

import com.github.javafaker.Faker;
import com.siemens.facades.OTPGenerator;

public class OTPGeneratorDemo {
    public static void main(String[] args){
        Faker faker=new Faker();
        OTPGenerator otpGenerator=(min,max)->{
            return faker.random().nextInt(min,max);
        };
        System.out.println(otpGenerator.getOTP(1000,9999));

    }
}
