package com.siemens;

import com.github.javafaker.Faker;
import com.siemens.dao.RouterDao;
import com.siemens.dao.RouterDaoImpl;
import com.siemens.facades.Generator;
import com.siemens.models.Router;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Consumer;
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
        //Instance Method Reference
        Supplier<Long> routerIdSupplier=router::getRouterId;
        System.out.println(routerIdSupplier.get());
        //static method reference
        Supplier<String> nameSupplier= Generator::getName;
        System.out.println(nameSupplier.get());
       //Consumer
        Consumer<List<Router>> consumer=(routers)->{
            for(Router routerObj: routers)
                System.out.println(routerObj);
        };

        RouterDao routerDao=new RouterDaoImpl();
        for(int i=0;i<100;i++)
            routerDao.addRouter(RouterDemo.generateRouter());

        consumer.accept(routerDao.getAllRouters());




    }
}
