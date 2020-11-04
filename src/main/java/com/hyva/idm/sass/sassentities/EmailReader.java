package com.hyva.idm.sass.sassentities;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data

public class EmailReader {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")


    private Long emaillistenerId;
    private String url;
    private String username;
    private String emailId;
    private String password;
    private String smtp;
    private String pop3;
    private String imap;
    private String host;
    private String folderRead;
    private String fromEmail;
    private String subject;
    private String visibility;
    private String name;
    private String port;


}
