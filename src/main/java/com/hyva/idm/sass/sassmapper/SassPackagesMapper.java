package com.hyva.idm.sass.sassmapper;
import com.hyva.idm.sass.sassentities.SassPackages;
import com.hyva.idm.sass.sasspojo.SassPackagesPojo;

public class SassPackagesMapper {


    public static SassPackages mapPojoToEntity(SassPackagesPojo sassPackagesPojo){

        SassPackages sassPackages=new SassPackages();
        sassPackages.setPackagesSASSId(sassPackagesPojo.getPackagesSASSId());
        sassPackages.setPackageName(sassPackagesPojo.getPackageName());
        sassPackages.setRedirectUrl(sassPackagesPojo.getRedirectUrl());
        sassPackages.setSyncUrl(sassPackagesPojo.getSyncUrl());
        sassPackages.setLicncUrl(sassPackagesPojo.getLicncUrl());
        sassPackages.setStatus(sassPackagesPojo.getStatus());
        sassPackages.setCompanyCreateurl(sassPackagesPojo.getCompanyCreateurl());

        return sassPackages;
    }

    public static SassPackagesPojo mapEntityToPojo(SassPackages sassPackages){
        SassPackagesPojo sassPackagesPojo=new SassPackagesPojo();
        sassPackagesPojo.setPackageName(sassPackages.getPackageName());
        return sassPackagesPojo;

    }
}
