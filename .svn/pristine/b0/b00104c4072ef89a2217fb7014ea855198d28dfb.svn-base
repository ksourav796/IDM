package com.hyva.idm.sass.sassentities;

import com.hyva.idm.entity.BaseEntity;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class SassPermissionMaster extends BaseEntity<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long pmId;
    @Column(name = "description", columnDefinition = "LONGTEXT")
    private String description; //Sales (Pages)
    private String saasStatus;
    private String permissionMasterkey;
    @OneToOne
    private SassPermissionGroup sassPermissionGroupId;//Sales
    @OneToOne
    private SassPermissionMaster sassParentPM;
    }
