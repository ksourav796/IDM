package com.hyva.idm.sass.sassmapper;

import com.hyva.idm.sass.sassentities.Emaillistener;

import java.util.Date;

public class EmailStoreMapper {
    public static Emaillistener mapPojoToEntity(String from, String subject, String sentDate, String message){
        Emaillistener emaillistener=new Emaillistener();
        emaillistener.setSubject(subject);
        emaillistener.setSentDate(sentDate);
        emaillistener.setFrommail(from);
        emaillistener.setMessage(message);
        return emaillistener;
    }
}
