package com.hyva.idm.sass.sasstesting;


public class TransactionsData {

  private long transactionId;
  private String fromRegno;
  private String toRegno;
  private String userId;
  private java.sql.Timestamp timestamp;
  private String objectdata;
  private String typeDoc;
  private String status;
  private long notificationId;
  private String totaltax;
  private String totalcheckoutamt;


  public long getTransactionId() {
    return transactionId;
  }

  public void setTransactionId(long transactionId) {
    this.transactionId = transactionId;
  }


  public String getFromRegno() {
    return fromRegno;
  }

  public void setFromRegno(String fromRegno) {
    this.fromRegno = fromRegno;
  }


  public String getToRegno() {
    return toRegno;
  }

  public void setToRegno(String toRegno) {
    this.toRegno = toRegno;
  }


  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }


  public java.sql.Timestamp getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(java.sql.Timestamp timestamp) {
    this.timestamp = timestamp;
  }


  public String getObjectdata() {
    return objectdata;
  }

  public void setObjectdata(String objectdata) {
    this.objectdata = objectdata;
  }


  public String getTypeDoc() {
    return typeDoc;
  }

  public void setTypeDoc(String typeDoc) {
    this.typeDoc = typeDoc;
  }


  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }


  public long getNotificationId() {
    return notificationId;
  }

  public void setNotificationId(long notificationId) {
    this.notificationId = notificationId;
  }


  public String getTotaltax() {
    return totaltax;
  }

  public void setTotaltax(String totaltax) {
    this.totaltax = totaltax;
  }


  public String getTotalcheckoutamt() {
    return totalcheckoutamt;
  }

  public void setTotalcheckoutamt(String totalcheckoutamt) {
    this.totalcheckoutamt = totalcheckoutamt;
  }

}
