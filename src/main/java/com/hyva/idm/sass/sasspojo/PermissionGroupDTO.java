package com.hyva.idm.sass.sasspojo;

import lombok.Data;

import javax.persistence.Id;
@Data
public class PermissionGroupDTO {
    @Id
    private Long pgId;
    private String featureName; //Sales
    private String description;
    private String pgkey;
    private String  saasStatus;


}
