package com.hyva.idm.sass.sassentities;


import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class CartCustomerLink {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long cartCustId;
    private String clientId;
    private String clientSecret;
    private String status;
    private String url;
    private Date activationDate;
    private Date expiryDate;
    private String userName;
    private String apikey;
    private String password;
    private String email;
    private String companyId;
    @OneToOne
    private SassCustomer customerId;
    @OneToOne
    private Cartregistration cartId;
}
