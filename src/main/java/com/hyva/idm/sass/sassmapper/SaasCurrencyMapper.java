package com.hyva.idm.sass.sassmapper;

import com.hyva.idm.sass.sassentities.SassCurrency;
import com.hyva.idm.sass.sasspojo.SassCurrencyPojo;

public class SaasCurrencyMapper {


    public static SassCurrency mapPojoToEntity(SassCurrencyPojo sassCurrencyPojo) {
        SassCurrency sassCurrency = new SassCurrency();
        sassCurrency.setCurrencyId(sassCurrencyPojo.getCurrencyId());
        sassCurrency.setCurrencySymbol(sassCurrencyPojo.getCurrencySymbol());
        sassCurrency.setCurrencyName(sassCurrencyPojo.getCurrencyName());
        sassCurrency.setCurrencyCode(sassCurrencyPojo.getCurrencyCode());
        sassCurrency.setCurrencyDescription(sassCurrencyPojo.getCurrencyDescription());
        sassCurrency.setStatus(sassCurrencyPojo.getStatus());
        return sassCurrency;
    }
}
