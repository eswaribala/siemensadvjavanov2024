package com.siemens.dao;

import com.siemens.models.Router;

import java.util.*;

public class RouterDaoImpl implements RouterDao{
    private List<Router> routers;

    public RouterDaoImpl(){
        routers=new ArrayList<>();

    }
    @Override
    public boolean addRouter(Router router) {
        return routers.add(router);
    }

    @Override
    public List<Router> getAllRouters() {
        return routers;
    }
}
