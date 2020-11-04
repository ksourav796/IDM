package com.hyva.idm.sass.sassservice;


import com.hyva.idm.sass.sassentities.Emaillistener;
import com.hyva.idm.sass.sassmapper.EmailStoreMapper;
import com.hyva.idm.sass.sassrespositories.EmailStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component

public class EmailStore {
    @Autowired
    EmailStoreRepository emailStoreRepository;

    public void retrivemaildetails(String from, String subject, String sentDate, String messsage){

        Emaillistener emaillistener = EmailStoreMapper.mapPojoToEntity(from,subject,sentDate, messsage);
        emailStoreRepository.save(emaillistener);

    }
}
