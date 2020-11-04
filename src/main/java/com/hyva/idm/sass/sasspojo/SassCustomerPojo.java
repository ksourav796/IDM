package com.hyva.idm.sass.sasspojo;

import com.hyva.idm.sass.sassentities.SassPaymentMethod;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class SassCustomerPojo {

    private Long customerId;
    private String customerName;
    private String customerNumber;
    private String customerCode;
    private String email;
//    private String customerNumber;
    private String gstCode;
    private String bankName;
    private String accountNo;
//    private String iFSCCode;
    private String branchName;
    private String personIncharge;
    private String panNO;
    private String website;
    private String billingAddress;
    private double loyaltyPoints;
    private double totalLoyaltyPoints;
    private String phoneNumber;
    private String address;
    private String contactPerson;
    private String companyNumber;
    private String faxTelex;
    private String creditedLimit;
    private String creditedTerm;
    private Long terms;
    private String status;
    private String countryId;
    private String currencyId;
    private String stateId;
    private String ifsc;

    private SassPaymentMethod sassPaymentMethod;
    private SassPaymentMethod paymentmethodName;

}
