package com.hyva.idm.sass.sassmapper;

import com.hyva.idm.sass.sassentities.DestinationMap;
import com.hyva.idm.sass.sasspojo.DestinationMapPojo;

public class DestinationMapMapper {
    public static DestinationMap mapPojoToEntity(DestinationMapPojo details){
        DestinationMap map=new DestinationMap();
       if(details.getId()!=null){
           map.setId(details.getId());
       }
        map.setSourceName(details.getSourceName());
        map.setDestinationmap(details.getDestinationmap());
        map.setStatus(details.getStatus());
        map.setSourceType(details.getSourceType());
        return map;
    }
}
