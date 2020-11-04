package com.hyva.idm.sass.sasspojo;

import lombok.Data;

@Data
public class PktFieldsPojo {
    private Long id;
    private String tableName;
    private String fieldName;
    private String groupOf;
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getGroupOf() {
        return groupOf;
    }

    public void setGroupOf(String groupOf) {
        this.groupOf = groupOf;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
