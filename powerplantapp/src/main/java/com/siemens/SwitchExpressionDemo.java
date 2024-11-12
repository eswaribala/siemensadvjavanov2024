package com.siemens;

import com.github.javafaker.Faker;

public class SwitchExpressionDemo {
    public static void main(String[] args){

     System.out.println(computePowerConsumption(20));

    }

    private static int computePowerConsumption(int seconds){

        int powerConsumed=0;
        Faker faker=new Faker();
        powerConsumed=switch (seconds){
            case 10->{
                powerConsumed=faker.random().nextInt(1,100)*seconds;
                yield powerConsumed;
            }
            case 20->{
                powerConsumed=faker.random().nextInt(1,100)*seconds*5;
                yield powerConsumed;
            }
            case 30->{
                powerConsumed=faker.random().nextInt(1,100)*seconds*10;
                yield powerConsumed;
            }
            case 40->{
                powerConsumed=faker.random().nextInt(1,100)*seconds*20;
                yield powerConsumed;
            }
            default -> {
                yield powerConsumed;
            }
        };
        return powerConsumed;
    }

}
