package com.hyva.idm.sass.sasspojo;
import lombok.Data;

@Data

public class EmaillistenerPojo {
    private Long emaillistenerId;
    private String sentDate;
    private String frommail;
    private String message;
    private String subject;
    private String attachment;
    private String status;


}
