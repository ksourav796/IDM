package com.hyva.idm.sass.sassentities;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Data
public class PractitionerRegistration {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
  @GenericGenerator(name = "native", strategy = "native")
  private Long practitionerId;
  private String name;
  private String companyname;
  private String practitionernumber;
  private String phone;
  private String email;
  private String password;
  @OneToOne
  private SassSubscriptions subscriptionId;
  private String syncUrl;
  private String status;

  public PractitionerRegistration(Long practitionerId) {
    this.practitionerId=practitionerId;
  }

  public PractitionerRegistration() {

  }
}
