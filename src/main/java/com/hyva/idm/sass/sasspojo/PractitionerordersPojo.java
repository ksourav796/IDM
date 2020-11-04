package com.hyva.idm.sass.sasspojo;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Data
public class PractitionerordersPojo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long practitionerOrdersId;
    private String practitionerId;
    private String voucher;
    private String orderId;
    private String date;
    private String cdkey;
    private String svkey;
    private String registrationKey;
    private String activationKey;
    private String status;
}
