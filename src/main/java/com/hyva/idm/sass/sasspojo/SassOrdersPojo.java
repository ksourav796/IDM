package com.hyva.idm.sass.sasspojo;

import com.hyva.idm.sass.sassentities.Renew;
import lombok.Data;

import javax.persistence.Column;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Data
public class SassOrdersPojo {
    private Long SassOrdersId;
    private String companyName;
    private String companyAddress;
    private String companyEmail;
    private String companyLoginId;
    private String companyLoginPassword;
    private String customerName;
    private String customerEmail;
    private String companyPhone;
    private String companyRegistrationNo;
    private String companyGSTno;
    private String  deliveryType;//desktop r cloud
    private String  packagesSASSId;
    private String  developerId;
    private String  companySubscriptionId;
    private String username;
    private String password;
    private String companyNo;
    private String language;
    private String pan;
    private Date incorpDate;
    private Long faxno;
    private String website;
    private String state;
    private String version;
//    private String currency;
    private String gstRegistered;
    private Date gstRegisteredDate;
    private String countryId;
    private String customerId;
    private String currencyId;
    private String stateId;
    @Column(unique = true)
    private String licenceKey;
    private String  newsletter;
    private String subscriptionId;
    private String userId;
    private String orderNumber;
    private String subscriptionName;
    private String postingStatus;
    private Long orderValue;
    private Date createdDate;
    private Date expiryDate;
    private Date renewDate;
    private Renew renew;
    private String validity;
    private String validityStatus;
    private SassSubscriptionsPojo sassSubscriptionsPojo;
    private List<SassSubscriptionsPojo> sassSubscriptionsPojoList = new ArrayList<>();

    public void setDeveloperId(String developerId) {
        this.developerId = developerId;
    }

    public String getDeveloperId() {
        return developerId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getPostingStatus() {
        return postingStatus;
    }

    public Long getOrderValue() {
        return orderValue;
    }

    public void setOrderValue(Long orderValue) {
        this.orderValue = orderValue;
    }

    public void setPostingStatus(String postingStatus) {
        this.postingStatus = postingStatus;
    }

    public Long getSassOrdersId() {
        return SassOrdersId;
    }

    public void setSassOrdersId(Long sassOrdersId) {
        SassOrdersId = sassOrdersId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getCompanyEmail() {
        return companyEmail;
    }

    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail;
    }

    public String getCompanyLoginId() {
        return companyLoginId;
    }

    public void setCompanyLoginId(String companyLoginId) {
        this.companyLoginId = companyLoginId;
    }

    public String getCompanyLoginPassword() {
        return companyLoginPassword;
    }

    public void setCompanyLoginPassword(String companyLoginPassword) {
        this.companyLoginPassword = companyLoginPassword;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCompanyPhone() {
        return companyPhone;
    }

    public void setCompanyPhone(String companyPhone) {
        this.companyPhone = companyPhone;
    }

    public String getCompanyRegistrationNo() {
        return companyRegistrationNo;
    }

    public void setCompanyRegistrationNo(String companyRegistrationNo) {
        this.companyRegistrationNo = companyRegistrationNo;
    }

    public String getCompanyGSTno() {
        return companyGSTno;
    }

    public void setCompanyGSTno(String companyGSTno) {
        this.companyGSTno = companyGSTno;
    }

    public String getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }

    public String getPackagesSASSId() {
        return packagesSASSId;
    }

    public void setPackagesSASSId(String packagesSASSId) {
        this.packagesSASSId = packagesSASSId;
    }

    public String getCompanySubscriptionId() {
        return companySubscriptionId;
    }

    public void setCompanySubscriptionId(String companySubscriptionId) {
        this.companySubscriptionId = companySubscriptionId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCompanyNo() {
        return companyNo;
    }

    public void setCompanyNo(String companyNo) {
        this.companyNo = companyNo;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public Date getIncorpDate() {
        return incorpDate;
    }

    public void setIncorpDate(Date incorpDate) {
        this.incorpDate = incorpDate;
    }

    public Long getFaxno() {
        return faxno;
    }

    public void setFaxno(Long faxno) {
        this.faxno = faxno;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getGstRegistered() {
        return gstRegistered;
    }

    public void setGstRegistered(String gstRegistered) {
        this.gstRegistered = gstRegistered;
    }

    public Date getGstRegisteredDate() {
        return gstRegisteredDate;
    }

    public void setGstRegisteredDate(Date gstRegisteredDate) {
        this.gstRegisteredDate = gstRegisteredDate;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public String getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(String currencyId) {
        this.currencyId = currencyId;
    }

    public String getStateId() {
        return stateId;
    }

    public void setStateId(String stateId) {
        this.stateId = stateId;
    }

    public String getLicenceKey() {
        return licenceKey;
    }

    public void setLicenceKey(String licenceKey) {
        this.licenceKey = licenceKey;
    }

    public String getNewsletter() {
        return newsletter;
    }

    public void setNewsletter(String newsletter) {
        this.newsletter = newsletter;
    }

    public String getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(String subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public SassSubscriptionsPojo getSassSubscriptionsPojo() {
        return sassSubscriptionsPojo;
    }

    public void setSassSubscriptionsPojo(SassSubscriptionsPojo sassSubscriptionsPojo) {
        this.sassSubscriptionsPojo = sassSubscriptionsPojo;
    }

    public List<SassSubscriptionsPojo> getSassSubscriptionsPojoList() {
        return sassSubscriptionsPojoList;
    }

    public void setSassSubscriptionsPojoList(List<SassSubscriptionsPojo> sassSubscriptionsPojoList) {
        this.sassSubscriptionsPojoList = sassSubscriptionsPojoList;
    }

    public String getSubscriptionName() {
        return subscriptionName;
    }

    public void setSubscriptionName(String subscriptionName) {
        this.subscriptionName = subscriptionName;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
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

    public Date getRenewDate() {
        return renewDate;
    }

    public void setRenewDate(Date renewDate) {
        this.renewDate = renewDate;
    }

    public Renew getRenew() {
        return renew;
    }

    public void setRenew(Renew renew) {
        this.renew = renew;
    }

    public String getValidity() {
        return validity;
    }

    public void setValidity(String validity) {
        this.validity = validity;
    }
}
