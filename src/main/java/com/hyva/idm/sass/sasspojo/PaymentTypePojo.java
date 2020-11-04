package com.hyva.idm.sass.sasspojo;

import com.hyva.idm.sass.sassentities.SassOrders;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
@Data
public class PaymentTypePojo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long paymenetId;
    private String voucherPayment;
    private String cardPayment;
    private double totalCashPayment;
    private double totalVoucherPayment;
    private double totalCardPayment;
    private double totalAmount;
    private String duplicatePrint;
    private Date transactionDate;
    private String customerId;
    private String customerName;
    private Long sassOrders;
    private String orderId;
    private double balanceAmount;
    private String paymentMode;
    private String status;
    private String companyName;
    private String licenseKey;
    private Date renewDate;
    }
