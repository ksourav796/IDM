package com.hyva.idm.sass.sasstesting;


public class Register {

  private long id;
  private String email;
  private String fname;
  private String pan;
  private String address;
  private String phone;
  private String password;
  private String accountType;
  private java.sql.Date createDate;
  private String status;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


  public String getFname() {
    return fname;
  }

  public void setFname(String fname) {
    this.fname = fname;
  }


  public String getPan() {
    return pan;
  }

  public void setPan(String pan) {
    this.pan = pan;
  }


  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }


  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  public String getAccountType() {
    return accountType;
  }

  public void setAccountType(String accountType) {
    this.accountType = accountType;
  }


  public java.sql.Date getCreateDate() {
    return createDate;
  }

  public void setCreateDate(java.sql.Date createDate) {
    this.createDate = createDate;
  }


  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

}
