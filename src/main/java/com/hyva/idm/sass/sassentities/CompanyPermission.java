package com.hyva.idm.sass.sassentities;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class CompanyPermission {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long cpId;
    @Column(name = "description", columnDefinition = "LONGTEXT")
    private String description;
    private String permissionMasterkey;
    @OneToOne
    private PermissionMaster permissionMasterId;
    private String status;
    private int validity;
    private int validityRemaining;
    private Date fromDate;
    private Date toDate;

  }
