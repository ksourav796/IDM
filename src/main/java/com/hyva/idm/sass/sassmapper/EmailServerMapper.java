package com.hyva.idm.sass.sassmapper;

import com.hyva.idm.sass.sassentities.EmailServer;
import com.hyva.idm.sass.sasspojo.EmailServerPojo;

import java.util.ArrayList;
import java.util.List;

public class EmailServerMapper {
    public static EmailServer mapEmailSeverPojoToEntity(EmailServerPojo emailServer){
        EmailServer server=new EmailServer();
        server.setForMail(emailServer.getForMail());
        server.setLogoUrl(emailServer.getLogoUrl());
        server.setPassword(emailServer.getPassword());
        server.setPort(emailServer.getPort());
        server.setSmtpHost(emailServer.getSmtpHost());
        server.setUserName(emailServer.getUserName());
        server.setStatus(emailServer.getStatus());
        if(emailServer.getId()!=null){
        server.setId(emailServer.getId());}
return server;
    }

    public static List<EmailServerPojo> mapMailEntityToPojo(List<EmailServer> mailList){
        List<EmailServerPojo> list=new ArrayList<>();
        for(EmailServer mail:mailList) {
            EmailServerPojo mailDTO = new EmailServerPojo();
            mailDTO.setId(mail.getId());
            mailDTO.setUserName(mail.getUserName());
            mailDTO.setPassword(mail.getPassword());
            mailDTO.setSmtpHost(mail.getSmtpHost());
            mailDTO.setPort(mail.getPort());
            list.add(mailDTO);
        }
        return list;
    }
}
