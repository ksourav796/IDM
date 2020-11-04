package com.hyva.idm.sass.sassentities;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Data
public class Practitionerorders {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
  @GenericGenerator(name = "native", strategy = "native")
  private Long practitionerOrdersId;
  private String voucher;
  private String date;
  private String cdkey;
  private String svkey;
  private String registrationKey;
  private String activationKey;
  private String status;
  @OneToOne
  private SassOrders orderId;
  @OneToOne
  private PractitionerRegistration practitionerId;
}
