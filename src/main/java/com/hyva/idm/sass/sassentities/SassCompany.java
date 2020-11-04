package com.hyva.idm.sass.sassentities;

import com.hyva.idm.entity.BaseEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
public class SassCompany extends BaseEntity<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long compnayId;
    private String companyName;
    private String companyAddress;
    private String companyEmail;
    private String username;
    private String password;
    private String loginUniqueId;
    private String status;
    private String companyType;
    private String companyLoginId;
    private String companyLoginPassword;
    private String companyNo;
    private String language;
    private String pan;
    private Date incorpDate;
    private Long faxno;
    private String website;
    private String customerName;
    private String customerEmail;
    private String customerAddress;
    private String customerNumber;
    private String companyPhone;
    private String companyRegistrationNo;
    private String companyGSTno;
    private String  deliveryType;//desktop r cloud
    private String  packagesSASSId;
    private String  companySubscriptionId;
    private String gstRegistered;
    private Date gstRegisteredDate;
    @Column(unique = true)
    private String licenceKey;
    private String  newsletter;
    private String postingStatus;
    @OneToOne
    private SassSubscriptions sassSubscriptionsId;
    @Column(unique = true, nullable = false)
    private String hiConnectCompnyRegNo = UUID.randomUUID().toString().toUpperCase().replace("-", "").substring(0,16);
    private String parentCompanyRegNo;
    private Date loginUniqueIdExpiry;
    @OneToOne
    private SassOrders sassOrdersId;
    @OneToOne
    private SassCustomer sassCustomerId;
    @OneToOne
    private SassCountry countryId;
    @OneToOne
    private SassCurrency currencyId;
    @OneToOne
    private SaasState stateId;
    @OneToOne
    private SassUser sassUserId;

    public SassCustomer getSassCustomerId() {
        return sassCustomerId;
    }

    public void setSassCustomerId(SassCustomer sassCustomerId) {
        this.sassCustomerId = sassCustomerId;
    }

    public SassUser getSassUserId() {
        return sassUserId;
    }

    public void setSassUserId(SassUser sassUserId) {
        this.sassUserId = sassUserId;
    }

    public Date getLoginUniqueIdExpiry() {
        return loginUniqueIdExpiry;
    }

    public void setLoginUniqueIdExpiry(Date loginUniqueIdExpiry) {
        this.loginUniqueIdExpiry = loginUniqueIdExpiry;
    }

    public String getParentCompanyRegNo() {
        return parentCompanyRegNo;
    }

    public void setParentCompanyRegNo(String parentCompanyRegNo) {
        this.parentCompanyRegNo = parentCompanyRegNo;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
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

    public String getPostingStatus() {
        return postingStatus;
    }

    public void setPostingStatus(String postingStatus) {
        this.postingStatus = postingStatus;
    }

    public SassSubscriptions getSassSubscriptionsId() {
        return sassSubscriptionsId;
    }

    public void setSassSubscriptionsId(SassSubscriptions sassSubscriptionsId) {
        this.sassSubscriptionsId = sassSubscriptionsId;
    }

    public String getHiConnectCompnyRegNo() {
        return hiConnectCompnyRegNo;
    }

    public void setHiConnectCompnyRegNo(String hiConnectCompnyRegNo) {
        this.hiConnectCompnyRegNo = hiConnectCompnyRegNo;
    }

    public SassCountry getCountryId() {
        return countryId;
    }

    public void setCountryId(SassCountry countryId) {
        this.countryId = countryId;
    }

    public SassCurrency getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(SassCurrency currencyId) {
        this.currencyId = currencyId;
    }

    public SaasState getStateId() {
        return stateId;
    }

    public void setStateId(SaasState stateId) {
        this.stateId = stateId;
    }

    public SassOrders getSassOrdersId() {
        return sassOrdersId;
    }

    public void setSassOrdersId(SassOrders sassOrdersId) {
        this.sassOrdersId = sassOrdersId;
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

    public String getCompanyEmail() {
        return companyEmail;
    }

    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail;
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

}
