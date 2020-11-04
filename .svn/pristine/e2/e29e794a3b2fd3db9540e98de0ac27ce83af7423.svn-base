package com.hyva.idm.sass.sasspojo;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Data
public class PractitionerRegistrPojo {
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
    private String subscriptionId;
    private String syncUrl;
    private String status;
}
