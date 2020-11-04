package com.hyva.idm.sass.sasstesting;


public class SaasUsers {

  private long userId;
  private String username;
  private String password;
  private String email;
  private java.sql.Date createdDate;
  private java.sql.Date modifiedDate;
  private java.sql.Timestamp nextrenewalDate;
  private long registrationId;
  private String userAgent;
  private String userType;
  private String location;
  private String phone;
  private String name;
  private String status;


  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
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


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


  public java.sql.Date getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(java.sql.Date createdDate) {
    this.createdDate = createdDate;
  }


  public java.sql.Date getModifiedDate() {
    return modifiedDate;
  }

  public void setModifiedDate(java.sql.Date modifiedDate) {
    this.modifiedDate = modifiedDate;
  }


  public java.sql.Timestamp getNextrenewalDate() {
    return nextrenewalDate;
  }

  public void setNextrenewalDate(java.sql.Timestamp nextrenewalDate) {
    this.nextrenewalDate = nextrenewalDate;
  }


  public long getRegistrationId() {
    return registrationId;
  }

  public void setRegistrationId(long registrationId) {
    this.registrationId = registrationId;
  }


  public String getUserAgent() {
    return userAgent;
  }

  public void setUserAgent(String userAgent) {
    this.userAgent = userAgent;
  }


  public String getUserType() {
    return userType;
  }

  public void setUserType(String userType) {
    this.userType = userType;
  }


  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }


  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

}
