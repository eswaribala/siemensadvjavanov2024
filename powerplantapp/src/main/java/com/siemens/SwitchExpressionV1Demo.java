package com.siemens;

import com.github.javafaker.Faker;
import com.siemens.models.Class1Gateway;
import com.siemens.models.Device;
import com.siemens.models.Gateway;

public class SwitchExpressionV1Demo {
    public static void main(String[] args){
     Faker faker=new Faker();
     System.out.println(findTheInstance(new Device(faker.random().nextInt(1,1000),faker.internet().macAddress())));
     Gateway gateway=Gateway.builder()
                     .deviceId(faker.random().nextInt(1,1000))
                             .deviceName(faker.internet().macAddress())
                                     .dnsName(faker.internet().domainName()).build();
        Class1Gateway class1Gateway=Class1Gateway.builder()
                .deviceId(faker.random().nextInt(1,1000))
                .deviceName(faker.internet().macAddress())
                .speed(faker.random().nextLong(1000))
                .build();

        System.out.println(findTheInstance(gateway));
        System.out.println(findTheInstance(class1Gateway));
    }

    private static Object findTheInstance(Device device){

        Object value=null;
        Faker faker=new Faker();
        value=switch (device){

            case Gateway gateway -> "Gateway"+ device.getDeviceName()+"triggered";
            case Class1Gateway class1Gateway -> "Class1Gateway"+device.getDeviceName();
            default -> {
                yield "Device"+device.getDeviceName();
            }
        };
        return value;
    }

}
