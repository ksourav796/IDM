package com.hyva.idm.sass.sasspojo;


import lombok.Data;

import java.util.Date;
@Data
public class RTRSyncSettingsPojo {

    private Long rtrSyncID;
    private String companyKeyWord;
    private String rtrSyncStatus;
    private String rtrSyncType;
    private String rtrSyncOption;
    private Integer rtrSyncSchedulePeriod;
    private Date createdAt;
    private Date updatedAt;
}
