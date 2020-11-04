package com.hyva.idm.sass.sassmapper;

import com.hyva.idm.sass.sassentities.EmailReader;
import com.hyva.idm.sass.sasspojo.EmailReaderPojo;

public  class EmailReaderMapper {

public static EmailReader mapPojoToEntity(EmailReaderPojo pojo){
    EmailReader emailReader=new EmailReader();
    emailReader.setEmaillistenerId(pojo.getEmaillistenerId());
    emailReader.setUrl(pojo.getUrl());
    emailReader.setUsername(pojo.getUsername());
    emailReader.setEmailId(pojo.getEmailId());
    emailReader.setPassword(pojo.getPassword());
    emailReader.setSmtp(pojo.getSmtp());
    emailReader.setPop3(pojo.getPop3());
    emailReader.setImap(pojo.getImap());
    emailReader.setHost(pojo.getHost());
    emailReader.setFolderRead(pojo.getFolderRead());
    emailReader.setFromEmail(pojo.getFromEmail());
    emailReader.setSubject(pojo.getSubject());
    emailReader.setVisibility(pojo.getVisibility());
    emailReader.setName(pojo.getName());
    emailReader.setPort(pojo.getPort());
    return emailReader;
}
}
