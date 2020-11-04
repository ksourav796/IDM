package com.hyva.idm.sass.sassmapper;

import com.hyva.idm.sass.sassentities.SassPayment;
import com.hyva.idm.sass.sasspojo.SassPaymentPojo;

public class SassPaymentMapper {

    public static SassPayment mapPojoToEntity(SassPaymentPojo sassPaymentPojo){

        SassPayment  sassPayment=new SassPayment();
        sassPayment.setAmount(sassPaymentPojo.getAmount());

        return sassPayment;
    }

    public static SassPaymentPojo mapEntityToPojo(SassPayment sassPayment){
        SassPaymentPojo sassPaymentPojo=new SassPaymentPojo();
        sassPaymentPojo.setAmount(sassPayment.getAmount());

        return sassPaymentPojo;

    }
}
