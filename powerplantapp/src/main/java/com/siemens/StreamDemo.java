package com.siemens;

import com.siemens.dao.RouterDao;
import com.siemens.dao.RouterDaoImpl;
import com.siemens.models.Router;

import java.util.List;

public class StreamDemo {
    public static void main(String[] args){
        //Streaming
        //Terminal Operator
        //generateRouters().stream().forEach(System.out::println);
        //Intermediate with terminal
        //sort the routers by created on
        generateRouters().stream().sorted((r1,r2)->{
            if(r1.getRouterId()==r2.getRouterId())
                return 0;
            else if (r1.getRouterId()>r2.getRouterId()) {
                return 1;
            }else
                return -1;
        }).forEach(System.out::println);





    }

    public static List<Router> generateRouters(){
        RouterDao routerDao=new RouterDaoImpl();
        for(int i=0;i<100;i++){
            routerDao.addRouter(RouterDemo.generateRouter());
        }
        return routerDao.getAllRouters();
    }

}
