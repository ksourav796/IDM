package com.hyva.idm.sass.sasstesting;


public class BuyLicence {

  private long id;
  private String dealerId;
  private String subscriptionId;
  private String packageName;
  private String onecost;
  private String buyLicence;
  private String total;
  private String mode;
  private java.sql.Timestamp purchaseDate;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getDealerId() {
    return dealerId;
  }

  public void setDealerId(String dealerId) {
    this.dealerId = dealerId;
  }


  public String getSubscriptionId() {
    return subscriptionId;
  }

  public void setSubscriptionId(String subscriptionId) {
    this.subscriptionId = subscriptionId;
  }


  public String getPackageName() {
    return packageName;
  }

  public void setPackageName(String packageName) {
    this.packageName = packageName;
  }


  public String getOnecost() {
    return onecost;
  }

  public void setOnecost(String onecost) {
    this.onecost = onecost;
  }


  public String getBuyLicence() {
    return buyLicence;
  }

  public void setBuyLicence(String buyLicence) {
    this.buyLicence = buyLicence;
  }


  public String getTotal() {
    return total;
  }

  public void setTotal(String total) {
    this.total = total;
  }


  public String getMode() {
    return mode;
  }

  public void setMode(String mode) {
    this.mode = mode;
  }


  public java.sql.Timestamp getPurchaseDate() {
    return purchaseDate;
  }

  public void setPurchaseDate(java.sql.Timestamp purchaseDate) {
    this.purchaseDate = purchaseDate;
  }

}
