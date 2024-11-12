package com.siemens;

import com.siemens.models.Router;

import java.util.List;

public class ImmutableCollectionDemo {

    public static void main(String[] args){
        //immutable collection
      List<Router> routers = List.copyOf(StreamDemo.generateRouters());
     // routers.add(RouterDemo.generateRouter());
    }
}
