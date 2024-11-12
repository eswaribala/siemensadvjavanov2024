package com.siemens;

import com.siemens.models.Database;

public class ImmutableObject {
    public static void main(String[] args){
        Database database=new Database("localhost",3306,"root","Test@123");
        System.out.println(database.userName());
        

    }
}
