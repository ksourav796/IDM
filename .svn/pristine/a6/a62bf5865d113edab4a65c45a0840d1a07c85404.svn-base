package com.hyva.idm.sass.sassentities;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
public class OrderAppPermission {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long sassOrdersId;
    private Long customerId;
    @Column(name="appKey",columnDefinition = "LONGTEXT")
    private String appKey;
    private String sqlString;
    @Column(name="jsonData",columnDefinition = "LONGTEXT")
    private String jsonData;
    private String appName;
    private String developerCode;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getSqlString() {
        return sqlString;
    }

    public void setSqlString(String sqlString) {
        this.sqlString = sqlString;
    }

    public String getJsonData() {
        return jsonData;
    }

    public void setJsonData(String jsonData) {
        this.jsonData = jsonData;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getDeveloperCode() {
        return developerCode;
    }

    public void setDeveloperCode(String developerCode) {
        this.developerCode = developerCode;
    }

    public Long getSassOrdersId() {
        return sassOrdersId;
    }

    public void setSassOrdersId(Long sassOrdersId) {
        this.sassOrdersId = sassOrdersId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
}
