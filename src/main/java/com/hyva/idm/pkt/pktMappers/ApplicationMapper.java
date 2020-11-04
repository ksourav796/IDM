package com.hyva.idm.pkt.pktMappers;

import com.hyva.idm.pkt.pktRelations.Application;
import com.hyva.idm.pkt.pktBeans.ApplicationBean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * krishna
 */
@Component
public class ApplicationMapper {
    public static Application mapApplicationPojoToEnity(ApplicationBean applicationPojo){
        Application application  = new Application();
        application.setId(applicationPojo.getId());
        application.setName(applicationPojo.getName());
        application.setStatus(applicationPojo.getStatus());
        application.setDeveloperId( applicationPojo.getDeveloperId());
        return  application;
    }

    public static List<ApplicationBean> mapEntityToPojo(List<Application> applicationList){
        List<ApplicationBean> list = new ArrayList<>();
        for(Application application:applicationList){
            ApplicationBean applicationPojo = new ApplicationBean();
            applicationPojo.setId( application.getId());
            applicationPojo.setName( application.getName());
            applicationPojo.setStatus(application.getStatus());
            applicationPojo.setDeveloperId( application.getDeveloperId());
            list.add( applicationPojo);
        }
        return list;
    }
}
