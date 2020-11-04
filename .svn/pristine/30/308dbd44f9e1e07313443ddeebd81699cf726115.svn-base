/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hyva.idm.sass.sassentities;


import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
public class SassPaymentMethod implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long paymentmethodId;
    private String paymentmethodName;
    private String paymentmethodDescription;
    private String paymentmethodType;
    private String accountType;
    private String status;
    private String defaultType;
    private String locationId;
    private String useraccount_id;
    private String validateVoucher;
}
