package com.hyva.idm.sass.sassentities;
import com.hyva.idm.entity.BaseEntity;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Email;
import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
@Table(name="SassCustomer")
@SecondaryTable(name="SassPaymentMethod")
public class SassCustomer extends BaseEntity<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long customerId;
    private String customerName;
    private String customerNumber;
    private String customerCode;
    private String companyNumber;
    private String companyCode;
    private String address;
    private String attention;
    @Email
    @Column(unique = true)
    private String email;
    private String phoneNumber1;
    private String phoneNumber2;
    private String faxTelex;
    private String contactPerson;
    private String generalNote;
    private String website;
    private String gstCode;
    private boolean creditedLimitAlert;
    private String creditedLimit;
    private String creditedTerm;
    @OneToOne
    private SassCountry countryId;
    @OneToOne
    private SassOrders orderId;
    private String periodOfVerification;
    private String ArAccount;
    @Temporal(TemporalType.DATE)
    private Date createdDate;
    @Temporal(TemporalType.DATE)
    private Date verificationDate;
    private String currencyWord;
    private String currencySymbol;
    private String shipToAddress;
    @OneToOne
    private SassCurrency currencyId;
    private String locationId;
    private String useraccount_id;
    private String hiConnectStatus;
    private String panNo;
    @OneToOne
    private SaasState stateId;
    private String ifsc;
    private String bankName;
    private String accountNo;
//    private String iFSCCode;
    private String branchName;
    private String personIncharge;
    private double loyaltyPoints;
    private String status;
    private String loginName;
    private String loginPassword;
    private String licence;
    private String loginUniqueId;
    private Date loginUniqueIdExpiry;

@OneToOne
private SassPaymentMethod sassPaymentMethod;

    @OneToOne
    private SassPaymentMethod paymentmethodName;

@Embedded
    public SassPaymentMethod getSassPaymentMethod() {
        return sassPaymentMethod;
    }

    @Embedded
    public SassPaymentMethod getPaymentmethodName() {
        return paymentmethodName;
    }

    public void setPaymentmethodName(SassPaymentMethod paymentmethodName) {
        this.paymentmethodName = paymentmethodName;
    }



    public void setSassPaymentMethod(SassPaymentMethod sassPaymentMethod) {
        this.sassPaymentMethod = sassPaymentMethod;
    }

    public SassCustomer(Long customerId) {
        this.customerId=customerId;
    }



    public SassCustomer() {

    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getCompanyNumber() {
        return companyNumber;
    }

    public void setCompanyNumber(String companyNumber) {
        this.companyNumber = companyNumber;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAttention() {
        return attention;
    }

    public void setAttention(String attention) {
        this.attention = attention;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber1() {
        return phoneNumber1;
    }

    public void setPhoneNumber1(String phoneNumber1) {
        this.phoneNumber1 = phoneNumber1;
    }

    public String getPhoneNumber2() {
        return phoneNumber2;
    }

    public void setPhoneNumber2(String phoneNumber2) {
        this.phoneNumber2 = phoneNumber2;
    }

    public String getFaxTelex() {
        return faxTelex;
    }

    public void setFaxTelex(String faxTelex) {
        this.faxTelex = faxTelex;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getGeneralNote() {
        return generalNote;
    }

    public void setGeneralNote(String generalNote) {
        this.generalNote = generalNote;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getGstCode() {
        return gstCode;
    }

    public void setGstCode(String gstCode) {
        this.gstCode = gstCode;
    }

    public boolean isCreditedLimitAlert() {
        return creditedLimitAlert;
    }

    public void setCreditedLimitAlert(boolean creditedLimitAlert) {
        this.creditedLimitAlert = creditedLimitAlert;
    }

    public String getCreditedLimit() {
        return creditedLimit;
    }

    public void setCreditedLimit(String creditedLimit) {
        this.creditedLimit = creditedLimit;
    }

    public String getCreditedTerm() {
        return creditedTerm;
    }

    public void setCreditedTerm(String creditedTerm) {
        this.creditedTerm = creditedTerm;
    }

    public SassCountry getCountryId() {
        return countryId;
    }

    public void setCountryId(SassCountry countryId) {
        this.countryId = countryId;
    }

    public SassOrders getOrderId() {
        return orderId;
    }

    public void setOrderId(SassOrders orderId) {
        this.orderId = orderId;
    }

    public String getPeriodOfVerification() {
        return periodOfVerification;
    }

    public void setPeriodOfVerification(String periodOfVerification) {
        this.periodOfVerification = periodOfVerification;
    }

    public String getArAccount() {
        return ArAccount;
    }

    public void setArAccount(String arAccount) {
        ArAccount = arAccount;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getVerificationDate() {
        return verificationDate;
    }

    public void setVerificationDate(Date verificationDate) {
        this.verificationDate = verificationDate;
    }

    public String getCurrencyWord() {
        return currencyWord;
    }

    public void setCurrencyWord(String currencyWord) {
        this.currencyWord = currencyWord;
    }

    public String getCurrencySymbol() {
        return currencySymbol;
    }

    public void setCurrencySymbol(String currencySymbol) {
        this.currencySymbol = currencySymbol;
    }

    public String getShipToAddress() {
        return shipToAddress;
    }

    public void setShipToAddress(String shipToAddress) {
        this.shipToAddress = shipToAddress;
    }

    public SassCurrency getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(SassCurrency currencyId) {
        this.currencyId = currencyId;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public String getUseraccount_id() {
        return useraccount_id;
    }

    public void setUseraccount_id(String useraccount_id) {
        this.useraccount_id = useraccount_id;
    }

    public String getHiConnectStatus() {
        return hiConnectStatus;
    }

    public void setHiConnectStatus(String hiConnectStatus) {
        this.hiConnectStatus = hiConnectStatus;
    }

    public String getPanNo() {
        return panNo;
    }

    public void setPanNo(String panNo) {
        this.panNo = panNo;
    }

    public SaasState getStateId() {
        return stateId;
    }

    public void setStateId(SaasState stateId) {
        this.stateId = stateId;
    }

    public String getIfsc() {
        return ifsc;
    }

    public void setIfsc(String ifsc) {
        this.ifsc = ifsc;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getPersonIncharge() {
        return personIncharge;
    }

    public void setPersonIncharge(String personIncharge) {
        this.personIncharge = personIncharge;
    }

    public double getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void setLoyaltyPoints(double loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public String getLicence() {
        return licence;
    }

    public void setLicence(String licence) {
        this.licence = licence;
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
}
