package com.hyva.idm.sass.sassentities;

import com.hyva.idm.entity.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
@ RequiredArgsConstructor

public class SassOrders extends BaseEntity<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long sassOrdersId;
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
    private String  companySubscriptionId;
    private String username;
    private String password;
    private String companyNo;
    private String language;
    private String pan;
    private Date incorpDate;
    private Long faxno;
    private String website;
//    private String state;
//    private String currency;
    private String gstRegistered;
    private Date gstRegisteredDate;
    @Column(unique = true, nullable = false)
    private String orderNumber = UUID.randomUUID().toString().toUpperCase().replace("-", "").substring(0,10);

    @Column(unique = true)
    private String licenceKey;
    private String  newsletter;
    private String postingStatus;
    @OneToOne
    private SassSubscriptions sassSubscriptionsId;
    @OneToOne
    private SassUser sassUserId;
    private String loginUniqueId;
    private Date loginUniqueIdExpiry;

    @OneToOne
    private SassCountry countryId;
    @OneToOne
    private SassCurrency currencyId;
    private Long sassCustomer;
    @OneToOne
    private SaasState stateId;
    private Long orderValue;
    @OneToOne
    private Application application;
    private String developerId;
    private String status;
    private Date createdDate;
    private Date expiryDate;
    @OneToOne
    private Renew renew;


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

    public Long getSassCustomer() {
        return sassCustomer;
    }

    public void setSassCustomer(Long sassCustomer) {
        this.sassCustomer = sassCustomer;
    }

    public String getDeveloperId() {
        return developerId;
    }

    public void setDeveloperId(String developerId) {
        this.developerId = developerId;
    }

    public Long getOrderValue() {
        return orderValue;
    }

    public void setOrderValue(Long orderValue) {
        this.orderValue = orderValue;
    }

    public Long getSassOrdersId() {
        return sassOrdersId;
    }

    public void setSassOrdersId(Long sassOrdersId) {
        this.sassOrdersId = sassOrdersId;
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

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
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

    public SassUser getSassUserId() {
        return sassUserId;
    }

    public void setSassUserId(SassUser sassUserId) {
        this.sassUserId = sassUserId;
    }

    public String getLoginUniqueId() {
        return loginUniqueId;
    }

    public void setLoginUniqueId(String loginUniqueId) {
        this.loginUniqueId = loginUniqueId;
    }

    public Date getLoginUniqueIdExpiry() {
        return loginUniqueIdExpiry;
    }

    public void setLoginUniqueIdExpiry(Date loginUniqueIdExpiry) {
        this.loginUniqueIdExpiry = loginUniqueIdExpiry;
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
}
