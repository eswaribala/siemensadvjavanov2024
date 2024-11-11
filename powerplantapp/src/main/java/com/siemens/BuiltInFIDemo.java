package com.siemens;

import com.github.javafaker.Faker;
import com.siemens.facades.Generator;
import com.siemens.models.Router;

import java.time.LocalDate;
import java.util.function.Function;
import java.util.function.Supplier;

public class BuiltInFIDemo {
    public static void main(String[] args){
        //find out router created date before current date
        Function<Router,Boolean> function=(router)->{
            System.out.println(router.getCreatedOn()+","+LocalDate.now());
            return router.getCreatedOn().isBefore(LocalDate.now());
        };

        System.out.println(function.apply(RouterDemo.generateRouter()));


        //supplier
        //constructor reference
        Supplier<Router> routerSupplier=Router::new;
        Router router=routerSupplier.get();
        router.setRouterId(new Faker().random().nextInt(10000));
        System.out.println(router);

        //static method reference
        Supplier<String> nameSupplier= Generator::getName;
        System.out.println(nameSupplier.get());




    }
}
