package com.hyva.idm.sass.sasstesting;


public class Practitioner {

  private long practitionerid;
  private long registrationid;
  private String name;
  private String companyname;
  private String phone;
  private String email;
  private String status;
  private long orderId;
  private long subscriptionId;
  private String syncUrl;


  public long getPractitionerid() {
    return practitionerid;
  }

  public void setPractitionerid(long practitionerid) {
    this.practitionerid = practitionerid;
  }


  public long getRegistrationid() {
    return registrationid;
  }

  public void setRegistrationid(long registrationid) {
    this.registrationid = registrationid;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getCompanyname() {
    return companyname;
  }

  public void setCompanyname(String companyname) {
    this.companyname = companyname;
  }


  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }


  public long getOrderId() {
    return orderId;
  }

  public void setOrderId(long orderId) {
    this.orderId = orderId;
  }


  public long getSubscriptionId() {
    return subscriptionId;
  }

  public void setSubscriptionId(long subscriptionId) {
    this.subscriptionId = subscriptionId;
  }


  public String getSyncUrl() {
    return syncUrl;
  }

  public void setSyncUrl(String syncUrl) {
    this.syncUrl = syncUrl;
  }

}
