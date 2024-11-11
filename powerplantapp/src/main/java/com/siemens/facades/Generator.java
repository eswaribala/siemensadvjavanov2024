package com.siemens.facades;

import com.github.javafaker.Faker;
import com.siemens.models.Router;

import java.util.List;

@FunctionalInterface
public interface Generator {
    int getOTP(int min,int max);

    static String getName(){
        return new Faker().name().firstName();
    }

   /* default void showData(List<Router>routers){
        for(Router router:routers)
            System.out.println(router);
    }*/
}
