package com.hyva.idm.sass.sassentities;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Cartregistration {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
  @GenericGenerator(name = "native", strategy = "native")
  private Long cartId;
  private String cartName;
  private String activationDate;
  private String expiry_Date;
  private String cartToken;
  private String authToken;
  private String renew;
  private String regId;
  private String companyId;
  private String status;
  private String url;
  private String version;
  private String api;
  private String email;


  public Cartregistration(Long cartId) {
    this.cartId=cartId;
  }

  public Cartregistration() {
  }


}
