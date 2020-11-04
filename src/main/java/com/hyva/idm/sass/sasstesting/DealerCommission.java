package com.hyva.idm.sass.sasstesting;


public class DealerCommission {

  private long id;
  private String category;
  private String percentage;
  private java.sql.Date startdate;
  private java.sql.Date enddate;
  private String status;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }


  public String getPercentage() {
    return percentage;
  }

  public void setPercentage(String percentage) {
    this.percentage = percentage;
  }


  public java.sql.Date getStartdate() {
    return startdate;
  }

  public void setStartdate(java.sql.Date startdate) {
    this.startdate = startdate;
  }


  public java.sql.Date getEnddate() {
    return enddate;
  }

  public void setEnddate(java.sql.Date enddate) {
    this.enddate = enddate;
  }


  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

}
