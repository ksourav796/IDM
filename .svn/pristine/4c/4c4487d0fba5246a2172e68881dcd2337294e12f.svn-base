package com.hyva.idm.sass.sassentities;

import com.hyva.idm.entity.BaseEntity;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class SassPayment extends BaseEntity<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long paymentSASSId;
    @ManyToOne
    private SassOrders ordersSASS;
    private String modeOfPayment;
    private String amount;
    private String vouchername;
    private String transactionNo;
    private String transactionDate;
    private String bankname;
    private String chequenumber;
    private String chequeDate;
    private String PaymentStatus;//cheque or cash or voucher deposit status pending

}
