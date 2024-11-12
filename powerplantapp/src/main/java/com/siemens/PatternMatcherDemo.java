package com.siemens;

import com.siemens.models.Device;
import com.siemens.models.Gateway;

import java.util.Scanner;
import java.util.regex.Pattern;

public class PatternMatcherDemo {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter Name");
        String name=scanner.nextLine();
        String namePattern="[a-zA-Z]*";
        Pattern pattern=Pattern.compile(namePattern);
        if(pattern.matcher(name).matches())
            System.out.println("Valid Name");
        else
            System.out.println("Invalid Name");

           //improvement in java 16

        Device gateway=new Gateway();
        if(gateway instanceof  Device device){
            System.out.println(device.getDeviceId());
        }

        Object object="Advanced Java Training";
        /*if(object instanceof String) {
            String str= (String) object;
            System.out.println(str);
        }*/
        if(object instanceof String str){
            System.out.println(str);
        }

    }
}
