package com.siemens.dao;

import com.siemens.models.Router;

import java.util.List;

public interface RouterDao {
    boolean addRouter(Router router);
    List<Router> getAllRouters();
}
