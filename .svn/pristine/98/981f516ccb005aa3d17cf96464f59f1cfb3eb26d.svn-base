package com.hyva.idm.sass.sassentities;

import com.hyva.idm.entity.BaseEntity;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class SassPermissionGroup extends BaseEntity<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long pgId;
    private String featureName; //Sales
    @Column(name = "description", columnDefinition = "LONGTEXT")
    private String description;
    private String saasStatus;
    private String permissionGroupkey;

    }
