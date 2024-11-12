package com.siemens;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Iterator;
import java.util.Set;

public class ZoneIdDemo {
    public static void main(String[] args){
        Set<String> zoneIdSet=ZoneId.getAvailableZoneIds();
       zoneIdSet.stream().forEach(zoneId->{
         ZonedDateTime currentTime=ZonedDateTime.now(ZoneId.of(zoneId));
         System.out.println(zoneId+"->"+currentTime.toString());
       });

    }
}
