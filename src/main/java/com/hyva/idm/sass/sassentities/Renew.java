package com.hyva.idm.sass.sassentities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Renew  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private Date expiryDate;
    private Date renewalDate;
    private Date createdDate;
    private String subscriptionName;
    private String validity;
    private String status;
    private String customerName;
    private Long orderId;

}
