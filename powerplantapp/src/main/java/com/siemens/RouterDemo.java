package com.siemens;

import com.github.javafaker.Faker;
import com.siemens.dao.RouterDao;
import com.siemens.dao.RouterDaoImpl;
import com.siemens.models.Router;

import java.time.Instant;
import java.time.ZoneId;
import java.util.Comparator;
import java.util.List;

public class RouterDemo {


    public static void main(String[] args){
        RouterDao routerDao=new RouterDaoImpl();
        for(int i=0;i<100;i++){
            routerDao.addRouter(generateRouter());
        }
        Comparator<Router> comparator=(r1,r2)->{
            return r1.getCreatedOn().compareTo(r2.getCreatedOn());
        };

        List<Router> routers=routerDao.getAllRouters();
        routers.sort(comparator);

        //show the routers
        for(Router router: routers)
            System.out.println(router);


    }


    public static Router generateRouter(){
        Faker faker=new Faker();
        return new Router(faker.random().nextInt(100,10000),
                faker.internet().macAddress(),
                Instant.ofEpochMilli(faker.date().birthday().getTime()).atZone(ZoneId.systemDefault()).toLocalDate());


    }
}
