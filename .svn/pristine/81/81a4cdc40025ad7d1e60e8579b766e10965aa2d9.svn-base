package com.hyva.idm.sass.sassentities;

import com.hyva.idm.entity.BaseEntity;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class SassSubscriptions extends BaseEntity<String> {


  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long subscriptionId;
  private String subscriptionName;
  private String validity;
  private String status;
  private String validityType;
  private String subscriptionFor;
  private String users;
  private Long companies;
  private Long activeUsers;
  private String hiAccount;
  private String hiSync;
  private double actualPrice;
  private double offerPrice;
  @ManyToOne
  private SassPackages packageId;

  private String originalCharge;
  private String version;
  private String appUrl;

  @Column(name = "permission", columnDefinition = "mediumblob")
  private String permission;
  private String addonPermission;
  private String application;
  private String developerId;
  private String type;
  private String emailcontent1subject;
  @Column(name="emailcontent1body",columnDefinition = "LONGTEXT")
  private String emailcontent1body;
  private String emailcontent2subject;
  @Column(name="emailcontent2body",columnDefinition = "LONGTEXT")
  private String emailcontent2body;
  private String emailServer;
  private String url;
  private String redirecturl;
  private String verifyEmail;
  private String verifyEmail2;
  private String description;


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getDeveloperId() {
    return developerId;
  }

  public void setDeveloperId(String developerId) {
    this.developerId = developerId;
  }

  public String getApplication() {
    return application;
  }

  public void setApplication(String application) {
    this.application = application;
  }

  public String getHiAccount() {
    return hiAccount;
  }

  public void setHiAccount(String hiAccount) {
    this.hiAccount = hiAccount;
  }

  public String getUsers() {
    return users;
  }

  public void setUsers(String users) {
    this.users = users;
  }

  public SassSubscriptions(Long subscriptionId) {
    this.subscriptionId=subscriptionId;
  }

  public SassSubscriptions() {
  }
  public Long getSubscriptionId() {
    return subscriptionId;
  }

  public void setSubscriptionId(Long subscriptionId) {
    this.subscriptionId = subscriptionId;
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

  public SassPackages getPackageId() {
    return packageId;
  }

  public void setPackageId(SassPackages packageId) {
    this.packageId = packageId;
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


  public String getHiSync() {
    return hiSync;
  }

  public void setHiSync(String hiSync) {
    this.hiSync = hiSync;
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


  public String getAppUrl() {
    return appUrl;
  }

  public void setAppUrl(String appUrl) {
    this.appUrl = appUrl;
  }
}
