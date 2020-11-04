package com.hyva.idm.sass.sasspojo;

import lombok.Data;
@Data
public class TransactionsDataPojo {
    private Long transactionId;
    private String fromRegno;
    private String toRegno;
    private String userId;
    private java.sql.Timestamp timestamp;
    private String objectdata;
    private String typeDoc;
    private String status;
    private Long notificationId;
    private String totaltax;
    private String totalcheckoutamt;
    private String toCompname;
    private String toEmail;
    private String contact;
    private String address;
    private String fromCompname;
    private String fromEmail;
    private String fromContact;
    private String fromAddress;
    private String typeFlag;
    private String viewStatus;
    private String siNo;
}
