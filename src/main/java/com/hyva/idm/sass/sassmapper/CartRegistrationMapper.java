package com.hyva.idm.sass.sassmapper;

import com.hyva.idm.sass.sassentities.AddOnn;
import com.hyva.idm.sass.sassentities.Cartregistration;
import com.hyva.idm.sass.sasspojo.AddOnnPojo;
import com.hyva.idm.sass.sasspojo.CartRegistrationPojo;

public class CartRegistrationMapper {
    public static Cartregistration mapPojoToEntity(CartRegistrationPojo cartRegistrationPojo) {
        Cartregistration cartregistration = new Cartregistration();
        cartregistration.setCartId(cartRegistrationPojo.getCartId());
       cartregistration.setCartName(cartRegistrationPojo.getCartName());
       cartregistration.setActivationDate(cartRegistrationPojo.getActivationDate());
       cartregistration.setExpiry_Date(cartRegistrationPojo.getExpiry_Date());
       cartregistration.setCartToken(cartRegistrationPojo.getCartToken());
       cartregistration.setAuthToken(cartRegistrationPojo.getAuthToken());
       cartregistration.setRenew(cartRegistrationPojo.getRenew());
       cartregistration.setRegId(cartRegistrationPojo.getRegId());
       cartregistration.setCompanyId(cartRegistrationPojo.getCompanyId());
       cartregistration.setStatus(cartRegistrationPojo.getStatus());
       cartregistration.setUrl(cartRegistrationPojo.getUrl());
       cartregistration.setVersion(cartRegistrationPojo.getVersion());
       cartregistration.setApi(cartRegistrationPojo.getApi());
       return cartregistration;
    }
}
