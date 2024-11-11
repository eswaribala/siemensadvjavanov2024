package com.siemens;

import com.github.javafaker.Faker;
import com.siemens.facades.Generator;
import com.siemens.facades.Generator;

public class OTPGeneratorDemo {
    public static void main(String[] args){
        Faker faker=new Faker();
        Generator otpGenerator=(min, max)->{
            return faker.random().nextInt(min,max);
        };
        System.out.println(otpGenerator.getOTP(1000,9999));

    }
}
