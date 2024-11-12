package com.siemens;

public class TypeInferenceDemo {

    public static void main(String[] args){
        var var="var";
        var value=76;

        System.out.println(var.getClass().getName());
      
       System.out.println(((Object)value).getClass().getSimpleName());
    }
}
