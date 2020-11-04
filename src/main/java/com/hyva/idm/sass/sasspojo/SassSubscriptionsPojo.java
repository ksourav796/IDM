package com.hyva.idm.sass.sasspojo;

import lombok.Data;

import java.util.Date;
import java.util.List;
@Data
public class SassSubscriptionsPojo {

    private String subscriptionName;
    private String validity;
    private String status;
    private String validityType;
    private String subscriptionFor;
    private String originalCharge;
    private String version;
    private String permission;
    private String addonPermission;
    private Long subscriptionId;
    private String key;
    private String appUrl;
    public List permissionList;
    private Long companies;
    private Long activeUsers;
    private String hiConnect;
    private String hiSync;
    private String users;
    private String hiAccount;
    private Date incorpDate;
    private double actualPrice;
    private double offerPrice;
    private String application;
    private String applicationName;
    private String applicationId;
    private String email;
    private String username;
    private Long userAccountId;
    private String password;
    private String orderNumber;
    private String registrationNo;
    private String phone;
    private String companyName;
    private String developerId;
    private String customerName;
    private String type;
    private Date createdDate;
    private Date expiryDate;
    private Date renewDate;
    private String validityStatus;
    private String emailcontent1subject;
    private String emailcontent1body;
    private String emailcontent2subject;
    private String emailcontent2body;
    private String emailServer;
    private String url;
    private String redirecturl;
    private String verifyEmail;
    private String verifyEmail2;
    private String renewValidity;

    public String getRenewValidity() {
        return renewValidity;
    }

    public void setRenewValidity(String renewValidity) {
        this.renewValidity = renewValidity;
    }

    public Date getRenewDate() {
        return renewDate;
    }

    public void setRenewDate(Date renewDate) {
        this.renewDate = renewDate;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getDeveloperId() {
        return developerId;
    }

    public void setDeveloperId(String developerId) {
        this.developerId = developerId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRegistrationNo() {
        return registrationNo;
    }

    public void setRegistrationNo(String registrationNo) {
        this.registrationNo = registrationNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Long getUserAccountId() {
        return userAccountId;
    }

    public void setUserAccountId(Long userAccountId) {
        this.userAccountId = userAccountId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSubscriptionName() {
        return subscriptionName;
    }

    public void setSubscriptionName(String subscriptionName) {
        this.subscriptionName = subscriptionName;
    }

    public String getValidity() {
        return validity;
    }

    public void setValidity(String validity) {
        this.validity = validity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getValidityType() {
        return validityType;
    }

    public void setValidityType(String validityType) {
        this.validityType = validityType;
    }

    public String getSubscriptionFor() {
        return subscriptionFor;
    }

    public void setSubscriptionFor(String subscriptionFor) {
        this.subscriptionFor = subscriptionFor;
    }

    public String getOriginalCharge() {
        return originalCharge;
    }

    public void setOriginalCharge(String originalCharge) {
        this.originalCharge = originalCharge;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getAddonPermission() {
        return addonPermission;
    }

    public void setAddonPermission(String addonPermission) {
        this.addonPermission = addonPermission;
    }

    public Long getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(Long subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public List getPermissionList() {
        return permissionList;
    }

    public void setPermissionList(List permissionList) {
        this.permissionList = permissionList;
    }

    public Long getCompanies() {
        return companies;
    }

    public void setCompanies(Long companies) {
        this.companies = companies;
    }

    public Long getActiveUsers() {
        return activeUsers;
    }

    public void setActiveUsers(Long activeUsers) {
        this.activeUsers = activeUsers;
    }

    public String getHiConnect() {
        return hiConnect;
    }

    public void setHiConnect(String hiConnect) {
        this.hiConnect = hiConnect;
    }

    public String getHiSync() {
        return hiSync;
    }

    public void setHiSync(String hiSync) {
        this.hiSync = hiSync;
    }

    public String getUsers() {
        return users;
    }

    public void setUsers(String users) {
        this.users = users;
    }

    public String getHiAccount() {
        return hiAccount;
    }

    public void setHiAccount(String hiAccount) {
        this.hiAccount = hiAccount;
    }

    public Date getIncorpDate() {
        return incorpDate;
    }

    public void setIncorpDate(Date incorpDate) {
        this.incorpDate = incorpDate;
    }

    public double getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(double actualPrice) {
        this.actualPrice = actualPrice;
    }

    public double getOfferPrice() {
        return offerPrice;
    }

    public void setOfferPrice(double offerPrice) {
        this.offerPrice = offerPrice;
    }

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }


    public String getAppUrl() {
        return appUrl;
    }

    public void setAppUrl(String appUrl) {
        this.appUrl = appUrl;
    }
}
