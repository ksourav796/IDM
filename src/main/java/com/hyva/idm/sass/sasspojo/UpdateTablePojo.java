package com.hyva.idm.sass.sasspojo;

import lombok.Data;

@Data
public class UpdateTablePojo {

    private String fromtable;
    private String fromcolumn;
    private String fromcommoncolumn;
    private String totable;
    private String tocolumn;
    private String tocommoncolumn;
    private String operation;


    public String getFromtable() {
        return fromtable;
    }

    public void setFromtable(String fromtable) {
        this.fromtable = fromtable;
    }

    public String getFromcolumn() {
        return fromcolumn;
    }

    public void setFromcolumn(String fromcolumn) {
        this.fromcolumn = fromcolumn;
    }

    public String getFromcommoncolumn() {
        return fromcommoncolumn;
    }

    public void setFromcommoncolumn(String fromcommoncolumn) {
        this.fromcommoncolumn = fromcommoncolumn;
    }

    public String getTotable() {
        return totable;
    }

    public void setTotable(String totable) {
        this.totable = totable;
    }

    public String getTocolumn() {
        return tocolumn;
    }

    public void setTocolumn(String tocolumn) {
        this.tocolumn = tocolumn;
    }

    public String getTocommoncolumn() {
        return tocommoncolumn;
    }

    public void setTocommoncolumn(String tocommoncolumn) {
        this.tocommoncolumn = tocommoncolumn;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }
}
