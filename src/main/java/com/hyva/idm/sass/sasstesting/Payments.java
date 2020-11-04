package com.hyva.idm.sass.sasstesting;


public class Payments {

  private long paymentId;
  private String txId;
  private long orderId;
  private double amount;
  private long status;
  private String currency;
  private long planNo;


  public long getPaymentId() {
    return paymentId;
  }

  public void setPaymentId(long paymentId) {
    this.paymentId = paymentId;
  }


  public String getTxId() {
    return txId;
  }

  public void setTxId(String txId) {
    this.txId = txId;
  }


  public long getOrderId() {
    return orderId;
  }

  public void setOrderId(long orderId) {
    this.orderId = orderId;
  }


  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }


  public long getStatus() {
    return status;
  }

  public void setStatus(long status) {
    this.status = status;
  }


  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }


  public long getPlanNo() {
    return planNo;
  }

  public void setPlanNo(long planNo) {
    this.planNo = planNo;
  }

}
