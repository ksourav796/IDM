package com.hyva.idm.sass.sassmapper;

import com.hyva.idm.sass.sassentities.PktUser;
import com.hyva.idm.sass.sasspojo.PktUserPojo;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PktUserMapper {
    public static PktUser mapPktuserPojoToEnity(PktUserPojo pktUserPojo){
        PktUser pktUser  = new PktUser();
        pktUser.setId(pktUserPojo.getId());
        pktUser.setUserName(pktUserPojo.getUserName());
        pktUser.setPassword(pktUserPojo.getPassword());
        pktUser.setEmail( pktUserPojo.getEmail());
        pktUser.setApplication( pktUserPojo.getApplication());
        pktUser.setRoles( pktUserPojo.getRoles());
        return  pktUser;
    }

    public static List<PktUserPojo> mapEntityToPojo(List<PktUser> pktUserList){
        List<PktUserPojo> list = new ArrayList<>();
        for(PktUser pktUser:pktUserList){
            PktUserPojo pktUserPojo = new PktUserPojo();
            pktUserPojo.setId( pktUser.getId());
            pktUserPojo.setUserName( pktUser.getUserName());
            pktUserPojo.setPassword(pktUser.getPassword());
            pktUserPojo.setEmail( pktUser.getEmail());
            pktUserPojo.setApplication( pktUser.getApplication());
            pktUserPojo.setRoles( pktUser.getRoles());
            list.add( pktUserPojo);
        }
        return list;
    }
}