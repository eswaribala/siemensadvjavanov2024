package com.siemens;

import com.siemens.models.Database;
import com.siemens.models.FileLogger;

import java.io.IOException;
import java.time.LocalDateTime;

public class ImmutableObject {
    public static void main(String[] args){
        Database database=new Database("localhost",3306,"root","Test@123");
        System.out.println(database.userName());

        FileLogger fileLogger=new FileLogger("Info logged at"+ LocalDateTime.now());
        try {
            fileLogger.writeToFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
