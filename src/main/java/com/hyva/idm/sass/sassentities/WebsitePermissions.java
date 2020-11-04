package com.hyva.idm.sass.sassentities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity

public class WebsitePermissions implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long websiteId;
    private String applicationId;
    private String tableName;
    @Column(name="colFields" ,columnDefinition = "LONGTEXT")
    private String colFields;

    public Long getWebsiteId() {
        return websiteId;
    }

    public void setWebsiteId(Long websiteId) {
        this.websiteId = websiteId;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getColFields() {
        return colFields;
    }

    public void setColFields(String colFields) {
        this.colFields = colFields;
    }
}
