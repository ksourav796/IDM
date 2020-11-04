package com.hyva.idm.sass.sasstesting;


public class Invoice {

  private long id;
  private String companyName;
  private String salesInvoiceId;
  private String transcationalDetails;
  private String practionerId;
  private String clientRegId;
  private String flagType;
  private String status;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getCompanyName() {
    return companyName;
  }

  public void setCompanyName(String companyName) {
    this.companyName = companyName;
  }


  public String getSalesInvoiceId() {
    return salesInvoiceId;
  }

  public void setSalesInvoiceId(String salesInvoiceId) {
    this.salesInvoiceId = salesInvoiceId;
  }


  public String getTranscationalDetails() {
    return transcationalDetails;
  }

  public void setTranscationalDetails(String transcationalDetails) {
    this.transcationalDetails = transcationalDetails;
  }


  public String getPractionerId() {
    return practionerId;
  }

  public void setPractionerId(String practionerId) {
    this.practionerId = practionerId;
  }


  public String getClientRegId() {
    return clientRegId;
  }

  public void setClientRegId(String clientRegId) {
    this.clientRegId = clientRegId;
  }


  public String getFlagType() {
    return flagType;
  }

  public void setFlagType(String flagType) {
    this.flagType = flagType;
  }


  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

}
