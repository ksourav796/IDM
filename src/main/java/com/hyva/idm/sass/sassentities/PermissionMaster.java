package com.hyva.idm.sass.sassentities;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Data
public class PermissionMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long pmId;
    private String description; //Sales (Pages)
    private String saasStatus;
    private String permissionMasterkey;
    private Long permId;
    private Long perm3;
    private Long perm4;
    @OneToOne
    private PermissionGroup permissionGroupId;//Sales
    @OneToOne
    private PermissionMaster parentPM;
    private String levelType;




    public PermissionMaster(Long pmId){
        this.pmId=pmId;
    }
    public PermissionMaster(){

    }

    public Long getPmId() {
        return pmId;
    }

    public void setPmId(Long pmId) {
        this.pmId = pmId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSaasStatus() {
        return saasStatus;
    }

    public void setSaasStatus(String saasStatus) {
        this.saasStatus = saasStatus;
    }

    public String getPermissionMasterkey() {
        return permissionMasterkey;
    }

    public void setPermissionMasterkey(String permissionMasterkey) {
        this.permissionMasterkey = permissionMasterkey;
    }

    public Long getPermId() {
        return permId;
    }

    public void setPermId(Long permId) {
        this.permId = permId;
    }

    public Long getPerm3() {
        return perm3;
    }

    public void setPerm3(Long perm3) {
        this.perm3 = perm3;
    }

    public Long getPerm4() {
        return perm4;
    }

    public void setPerm4(Long perm4) {
        this.perm4 = perm4;
    }

    public PermissionGroup getPermissionGroupId() {
        return permissionGroupId;
    }

    public void setPermissionGroupId(PermissionGroup permissionGroupId) {
        this.permissionGroupId = permissionGroupId;
    }

    public PermissionMaster getParentPM() {
        return parentPM;
    }

    public void setParentPM(PermissionMaster parentPM) {
        this.parentPM = parentPM;
    }

    public String getLevelType() {
        return levelType;
    }

    public void setLevelType(String levelType) {
        this.levelType = levelType;
    }
}
