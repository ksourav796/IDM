package com.hyva.idm.sass.sasspojo;

import lombok.Data;

import java.util.Date;
@Data
public class CompanyPermissionPojo {
    private String description;
    private Long pmId;
    private String status;
    private int validity;
    private Date fromDate;
    private Date toDate;


}
