package com.hyva.idm.sass.sassmapper;

import com.hyva.idm.sass.sassentities.Practitionerorders;
import com.hyva.idm.sass.sasspojo.PractitionerordersPojo;

public class PractordersMapper {
    public static Practitionerorders mapPojoToEntity(PractitionerordersPojo details) {
        Practitionerorders orders = new Practitionerorders();
        orders.setPractitionerOrdersId(details.getPractitionerOrdersId());
        orders.setVoucher(details.getVoucher());
        orders.setDate(details.getDate());
        orders.setCdkey(details.getCdkey());
        orders.setSvkey(details.getSvkey());
        orders.setRegistrationKey(details.getRegistrationKey());
        orders.setActivationKey(details.getActivationKey());
        orders.setStatus(details.getStatus());

        return orders;
    }
}
