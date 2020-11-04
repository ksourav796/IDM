package com.hyva.idm.sass.sassmapper;

import com.hyva.idm.sass.sassentities.PractitionerRegistration;
import com.hyva.idm.sass.sasspojo.PractitionerRegistrPojo;

public class PractitionerRegMapper {
    public static PractitionerRegistration mapPojoToEntity(PractitionerRegistrPojo PractitionerRegistrPojo) {
        PractitionerRegistration register = new PractitionerRegistration();
        register.setPractitionerId(PractitionerRegistrPojo.getPractitionerId());
        register.setName(PractitionerRegistrPojo.getName());
        register.setCompanyname(PractitionerRegistrPojo.getCompanyname());
        register.setPractitionernumber(PractitionerRegistrPojo.getPractitionernumber());
        register.setPhone(PractitionerRegistrPojo.getPhone());
        register.setEmail(PractitionerRegistrPojo.getEmail());
        register.setPassword(PractitionerRegistrPojo.getPassword());

        register.setSyncUrl(PractitionerRegistrPojo.getSyncUrl());
        register.setStatus(PractitionerRegistrPojo.getStatus());

        return register;
    }
}
