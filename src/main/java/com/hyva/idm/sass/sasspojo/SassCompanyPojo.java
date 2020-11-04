package com.hyva.idm.sass.sasspojo;

import lombok.Data;

@Data
public class SassCompanyPojo {

    private Long compnayId;
    private String companyName;
    private String email;
    private String userName;
    private String password;
    private String loginUniqueId;
    private String status;
    private String companyType;
    private String createdDate;
    private String userId;
    private String companyNo;
    private String companyGSTno;
    private String companyAddress;
    private int noOfUsers;
    private String licenceKey;
    private int remainingusers;

    public int getRemainingusers() {
        return remainingusers;
    }

    public void setRemainingusers(int remainingusers) {
        this.remainingusers = remainingusers;
    }

    public String getLicenceKey() {
        return licenceKey;
    }

    public void setLicenceKey(String licenceKey) {
        this.licenceKey = licenceKey;
    }

    public int getNoOfUsers() {
        return noOfUsers;
    }

    public void setNoOfUsers(int noOfUsers) {
        this.noOfUsers = noOfUsers;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getCompanyGSTno() {
        return companyGSTno;
    }

    public void setCompanyGSTno(String companyGSTno) {
        this.companyGSTno = companyGSTno;
    }

    public String getCompanyNo() {
        return companyNo;
    }

    public void setCompanyNo(String companyNo) {
        this.companyNo = companyNo;
    }

    public Long getCompnayId() {
        return compnayId;
    }

    public void setCompnayId(Long compnayId) {
        this.compnayId = compnayId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLoginUniqueId() {
        return loginUniqueId;
    }

    public void setLoginUniqueId(String loginUniqueId) {
        this.loginUniqueId = loginUniqueId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
