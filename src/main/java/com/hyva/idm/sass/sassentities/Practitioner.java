package com.hyva.idm.sass.sassentities;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Data
public class Practitioner {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
  @GenericGenerator(name = "native", strategy = "native")
  private Long practitionerId;
  @OneToOne
  private PractitionerRegistration PractitionerRegistrationId;
  private String name;
  private String companyname;
  private String phone;
  private String email;
  private String status;
  private Long orderId;
  private Long subscriptionId;
  private String syncUrl;
}
