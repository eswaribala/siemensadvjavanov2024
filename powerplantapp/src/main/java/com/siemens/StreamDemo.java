package com.siemens;

import com.github.javafaker.Faker;
import com.siemens.dao.RouterDao;
import com.siemens.dao.RouterDaoImpl;
import com.siemens.dtos.RouterResponse;
import com.siemens.models.Router;
import com.siemens.models.Switch;
import com.siemens.models.SwitchType;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class StreamDemo {
    public static void main(String[] args){
        //Streaming
        //Terminal Operator
        //generateRouters().stream().forEach(System.out::println);
        //Intermediate with terminal
        //sort the routers by created on
        /*generateRouters().stream().sorted((r1,r2)->{
            if(r1.getRouterId()==r2.getRouterId())
                return 0;
            else if (r1.getRouterId()>r2.getRouterId()) {
                return 1;
            }else
                return -1;
        }).forEach(System.out::println);*/

        //sort the routers by created on and filter on date

        /*generateRouters().stream()
                .filter(r->r.getCreatedOn().getYear()>2000)
                .sorted((r1,r2)->{
            if(r1.getRouterId()==r2.getRouterId())
                return 0;
            else if (r1.getRouterId()>r2.getRouterId()) {
                return 1;
            }else
                return -1;
        }).forEach(System.out::println);*/


        //sort the routers by created on , filter on date and return List<RouterResponse>
     /*List<RouterResponse> routerResponses=generateRouters().stream()
                .filter(r->r.getCreatedOn().getYear()>2000)
                .sorted((r1,r2)->{
                    if(r1.getRouterId()==r2.getRouterId())
                        return 0;
                    else if (r1.getRouterId()>r2.getRouterId()) {
                        return 1;
                    }else
                        return -1;
                })
                .map(r->new RouterResponse(r.getRouterName(),r.getCreatedOn()))
                .collect(Collectors.toList());

          routerResponses.stream().forEach(System.out::println);*/

         //select only routers from switches send it to List

   /*List<Router> routersInstances=
           generateSwitches().stream()
                   .flatMap(s->s.getRouters().stream())
                   .collect(Collectors.toList());

    routersInstances.stream().forEach(System.out::println);*/

        //create hashmap from switch --> List of switches to Map
    /*Map<Long,List<Router>> mappedSwitches=generateSwitches().stream()
            .collect(Collectors.toMap(s->s.getSwitchId(),s->s.getRouters().stream().toList()));

    mappedSwitches.entrySet().stream().forEach(entry->{
        System.out.println(entry.getKey()+","+entry.getValue());
    });*/

        //group by switch type and count
       /* Map<SwitchType,Long> mappedValues=generateSwitches().stream().collect(
                Collectors.groupingBy(s->s.getSwitchType(),Collectors.counting())
        );
        mappedValues.entrySet().stream().forEach(entry->{
            System.out.println(entry.getKey()+","+entry.getValue());
        });*/

       /* //anymatch above 2000

       System.out.println( "Any Match"+generateRouters().stream().anyMatch(r->r.getCreatedOn().getYear()>2000));

       //allmatch above 2000

        System.out.println( "All Match"+generateRouters().stream().allMatch(r->r.getCreatedOn().getYear()>2000));

      //find any
     Optional<Router> optionalRouter= generateRouters().stream()
                .filter(r->r.getCreatedOn().getYear()>2000)
                .findAny();

     if(optionalRouter.isPresent())
         System.out.println(optionalRouter.get());

        Optional<Router> optionalRouterFindFirst= generateRouters().stream()
                .filter(r->r.getCreatedOn().getYear()>2000)
                .findFirst();

        if(optionalRouterFindFirst.isPresent())
            System.out.println(optionalRouterFindFirst.get());

        //optional present or else throw
      Router router=  generateRouters().stream()
                .filter(r->r.getCreatedOn().getYear()>2000)
                .findAny()
                .orElseThrow(()->new RuntimeException("Data Not found"));
      System.out.println(router);

      //maximum router id
      Optional<Long> maxData= generateRouters().stream().map(r->r.getRouterId()).max(Long::compareTo);
        if(maxData.isPresent())
            System.out.println(maxData.get());
      //minimum router created date
     Optional<LocalDate> optionalLocalDate=
             generateRouters().stream().map(r->r.getCreatedOn()).min(LocalDate::compareTo);
      if(optionalLocalDate.isPresent())
          System.out.println(optionalLocalDate.get());*/

      //print first 50 records
       // generateRouters().stream().limit(50).forEach(System.out::println);
        //manages the list order
        generateRouters().stream().skip(50).forEachOrdered(System.out::println);


    }

    public static List<Router> generateRouters(){
        RouterDao routerDao=new RouterDaoImpl();
        for(int i=0;i<100;i++){
            routerDao.addRouter(RouterDemo.generateRouter());
        }
        return routerDao.getAllRouters();
    }
    public static List<Router> generateCountedRouters(int count){
        RouterDao routerDao=new RouterDaoImpl();
        for(int i=0;i<count;i++){
            routerDao.addRouter(RouterDemo.generateRouter());
        }
        return routerDao.getAllRouters();
    }
    public static List<Switch> generateSwitches(){
        List<Switch> switches=new ArrayList<>();
        Faker faker=new Faker();
        for(int i=0;i<25;i++){
            SwitchType switchType=generateRandomSwitchTypes(SwitchType.class);
            switches.add(new Switch(faker.random().nextInt(100,10000),
                    switchType,
                    faker.random().nextInt(100,5000),
                    generateCountedRouters(new Random().nextInt(1,10))));
        }
       return switches;
    }

    public static <T extends Enum<?>> T generateRandomSwitchTypes(Class<T> enumClass){
       T[] enumValues= enumClass.getEnumConstants();
        return enumValues[new Random().nextInt(enumValues.length)];
    }


}
