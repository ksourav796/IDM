package com.hyva.idm.sass.sassentities;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import java.util.Date;

@Entity
@Data
public class RTRSyncSettings  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long rtrSyncID;
    private String companyKeyWord;
    private String rtrSyncStatus;
    private String rtrSyncType;
    private String rtrSyncOption;
    private Integer rtrSyncSchedulePeriod;
    private Date createdAt;
    private Date updatedAt;
}
