package com.hyva.idm.sass.sassmapper;

import com.hyva.idm.sass.sassentities.PosPaymentTypes;
import com.hyva.idm.sass.sassentities.SassOrders;
import com.hyva.idm.sass.sasspojo.PaymentTypePojo;

public class SaasPaymentTypeMapper {
    public static PosPaymentTypes mapPojoToEntity(PaymentTypePojo PaymentTypePojo) {
        PosPaymentTypes PosPaymentTypes = new PosPaymentTypes();
        PosPaymentTypes.setPaymenetId(PaymentTypePojo.getPaymenetId());
        PosPaymentTypes.setTotalAmount(PaymentTypePojo.getTotalAmount());
        PosPaymentTypes.setTransactionDate(PaymentTypePojo.getTransactionDate());
        PosPaymentTypes.setBalanceAmount(PaymentTypePojo.getBalanceAmount());
        PosPaymentTypes.setPaymentMode(PaymentTypePojo.getPaymentMode());
        PosPaymentTypes.setStatus(PaymentTypePojo.getStatus());
        return PosPaymentTypes;
    }
}
