package com.hyva.idm.sass.sassmapper;

import com.hyva.idm.sass.sassentities.Action;
import com.hyva.idm.sass.sassentities.Application;
import com.hyva.idm.sass.sasspojo.ActionPojo;
import com.hyva.idm.sass.sasspojo.ApplicationPojo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by krishna.
 */
public class ApplicationMapper {

    public static Application mapApplicationPojoToEnity(ApplicationPojo applicationPojo){
        Application application  = new Application();
        application.setId(applicationPojo.getId());
        application.setName(applicationPojo.getName());
        application.setStatus(applicationPojo.getStatus());
        application.setDeveloperId( applicationPojo.getDeveloperId());
        return  application;
    }

    public static List<ApplicationPojo> mapEntityToPojo(List<Application> applicationList){
        List<ApplicationPojo> list = new ArrayList<>();
        for(Application application:applicationList){
            ApplicationPojo applicationPojo = new ApplicationPojo();
            applicationPojo.setId( application.getId());
            applicationPojo.setName( application.getName());
            applicationPojo.setStatus(application.getStatus());
            applicationPojo.setDeveloperId( application.getDeveloperId());
            list.add( applicationPojo);
        }
        return list;
    }

}
