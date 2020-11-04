package com.hyva.idm.sass.sassmapper;

import com.hyva.idm.sass.sassentities.SassCompany;
import com.hyva.idm.sass.sassentities.SassOrders;

public class SassCompanyMapper {
    public static SassCompany mapPojoToEntity(SassOrders sassOrdersPojo){
        SassCompany sassCompany=new SassCompany();
        sassCompany.setCustomerName(sassOrdersPojo.getCustomerName());
        sassCompany.setCompanyName(sassOrdersPojo.getCompanyName());
        sassCompany.setCompanyAddress(sassOrdersPojo.getCompanyAddress());
        sassCompany.setDeliveryType(sassOrdersPojo.getDeliveryType());
        sassCompany.setCompanyEmail(sassOrdersPojo.getCompanyEmail());
        sassCompany.setNewsletter(sassOrdersPojo.getNewsletter());
        sassCompany.setCompanyPhone(sassOrdersPojo.getCompanyPhone());
        sassCompany.setUsername(sassOrdersPojo.getUsername());
        sassCompany.setPassword(sassOrdersPojo.getPassword());
        sassCompany.setPackagesSASSId(sassOrdersPojo.getPackagesSASSId());
        sassCompany.setCompanyNo(sassOrdersPojo.getCompanyNo());
//        sassOrders.setCountry(sassOrdersPojo.getCountry());
//        sassOrders.setCurrency(sassOrdersPojo.getCurrency());
        sassCompany.setFaxno(sassOrdersPojo.getFaxno());
        sassCompany.setLanguage(sassOrdersPojo.getLanguage());
        sassCompany.setGstRegistered(sassOrdersPojo.getGstRegistered());
        sassCompany.setGstRegisteredDate(sassOrdersPojo.getGstRegisteredDate());
        sassCompany.setIncorpDate(sassOrdersPojo.getIncorpDate());
        sassCompany.setPan(sassOrdersPojo.getPan());
//        sassOrders.setState(sassOrdersPojo.getState());
        sassCompany.setWebsite(sassOrdersPojo.getWebsite());
        return sassCompany;
    }
}
