package com.hyva.idm.sass.sassmapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.hyva.idm.sass.sassentities.Property;
import com.hyva.idm.sass.sassentities.SassOrders;
import com.hyva.idm.sass.sassentities.SassSubscriptions;
import com.hyva.idm.sass.sasspojo.SassSubscriptionsPojo;

import java.lang.reflect.Type;
import java.util.*;
import java.util.stream.Collectors;

public class SassSubscriptionMapper {

    public static SassSubscriptions mapPojoToEntity(SassSubscriptionsPojo sassSubscriptionsPojo){

        SassSubscriptions sassSubscriptions=new SassSubscriptions();
        sassSubscriptions.setSubscriptionName(sassSubscriptionsPojo.getSubscriptionName());
        sassSubscriptions.setValidity(sassSubscriptionsPojo.getValidity());
        sassSubscriptions.setStatus(sassSubscriptionsPojo.getStatus());
        sassSubscriptions.setValidityType(sassSubscriptionsPojo.getValidityType());
        sassSubscriptions.setSubscriptionFor(sassSubscriptionsPojo.getSubscriptionFor());
        sassSubscriptions.setOriginalCharge(sassSubscriptionsPojo.getOriginalCharge());
        sassSubscriptions.setVersion(sassSubscriptionsPojo.getVersion());
        sassSubscriptions.setPermission(sassSubscriptionsPojo.getPermission());
        sassSubscriptions.setAddonPermission(sassSubscriptionsPojo.getAddonPermission());
        sassSubscriptions.setCompanies(sassSubscriptionsPojo.getCompanies());
        sassSubscriptions.setAppUrl(sassSubscriptionsPojo.getAppUrl());
        sassSubscriptions.setUsers(sassSubscriptionsPojo.getUsers());
        sassSubscriptions.setHiAccount(sassSubscriptionsPojo.getHiAccount());
        sassSubscriptions.setHiSync(sassSubscriptionsPojo.getHiSync());
        Property property = new Property();
        sassSubscriptions.setDescription(property.getDescription());
        sassSubscriptions.setApplication(sassSubscriptionsPojo.getApplication());
//        sassSubscriptions.setSubscriptionFor(sassSubscriptionsPojo.getHiConnect());
        sassSubscriptions.setSubscriptionId(sassSubscriptionsPojo.getSubscriptionId());
        sassSubscriptions.setType(sassSubscriptionsPojo.getType());
        sassSubscriptions.setActualPrice(sassSubscriptionsPojo.getActualPrice());
        sassSubscriptions.setOfferPrice(sassSubscriptionsPojo.getOfferPrice());
        sassSubscriptions.setDeveloperId( sassSubscriptionsPojo.getDeveloperId());
        sassSubscriptions.setEmailcontent1body(sassSubscriptionsPojo.getEmailcontent1body());
        sassSubscriptions.setEmailcontent2body(sassSubscriptionsPojo.getEmailcontent2body());
        sassSubscriptions.setEmailcontent1subject(sassSubscriptionsPojo.getEmailcontent1subject());
        sassSubscriptions.setEmailcontent2subject(sassSubscriptionsPojo.getEmailcontent2subject());
        sassSubscriptions.setUrl(sassSubscriptionsPojo.getUrl());
        sassSubscriptions.setEmailServer(sassSubscriptionsPojo.getEmailServer());
        return sassSubscriptions;
    }

    public static SassSubscriptionsPojo mapEntityToPojo(SassOrders sassOrders){
        SassSubscriptionsPojo sassSubscriptionsPojo=new SassSubscriptionsPojo();
            return sassSubscriptionsPojo;
    }

     public static List<SassSubscriptionsPojo> mapSubscriptionEntityToPojo(List<SassSubscriptions> sassSubscriptionsList){
       List<SassSubscriptionsPojo> sassSubscriptionsPojoList = new ArrayList<>();
       for(SassSubscriptions sassSubscriptions:sassSubscriptionsList){
           SassSubscriptionsPojo sassSubscriptionsPojo = new SassSubscriptionsPojo();
           sassSubscriptionsPojo.setSubscriptionId( sassSubscriptions.getSubscriptionId());
           sassSubscriptionsPojo.setSubscriptionName( sassSubscriptions.getSubscriptionName() );
           sassSubscriptionsPojo.setValidity( sassSubscriptions.getValidity() );
//           sassSubscriptionsPojo.setExpiryDate( sassSubscriptions.getExpiryDate() );
           sassSubscriptionsPojo.setStatus( sassSubscriptions.getStatus() );
           sassSubscriptionsPojo.setValidityType( sassSubscriptions.getValidityType() );
           sassSubscriptionsPojo.setSubscriptionFor( sassSubscriptions.getSubscriptionFor() );
           sassSubscriptionsPojo.setOriginalCharge( sassSubscriptions.getOriginalCharge() );
           sassSubscriptionsPojo.setVersion( sassSubscriptions.getVersion() );
           sassSubscriptionsPojo.setAddonPermission( sassSubscriptions.getAddonPermission() );
           sassSubscriptionsPojo.setCompanies( sassSubscriptions.getCompanies() );
           sassSubscriptionsPojo.setAppUrl( sassSubscriptions.getAppUrl() );
           sassSubscriptionsPojo.setUsers(sassSubscriptions.getUsers());
           sassSubscriptionsPojo.setHiSync( sassSubscriptions.getHiSync() );
           sassSubscriptionsPojo.setHiAccount( sassSubscriptions.getHiAccount() );
           sassSubscriptionsPojo.setHiConnect( sassSubscriptions.getSubscriptionName() );
           sassSubscriptionsPojo.setApplication( sassSubscriptions.getApplication() );
           sassSubscriptionsPojo.setActualPrice( sassSubscriptions.getActualPrice() );
           sassSubscriptionsPojo.setOfferPrice( sassSubscriptions.getOfferPrice() );
           sassSubscriptionsPojo.setDeveloperId( sassSubscriptions.getDeveloperId() );
           sassSubscriptionsPojo.setType( sassSubscriptions.getType() );
           sassSubscriptionsPojo.setEmailcontent1subject(sassSubscriptions.getEmailcontent1subject());
           sassSubscriptionsPojo.setEmailServer(sassSubscriptions.getEmailServer());
           sassSubscriptionsPojo.setEmailcontent1body(sassSubscriptions.getEmailcontent1body());
           sassSubscriptionsPojo.setEmailcontent2body(sassSubscriptions.getEmailcontent2body());
           sassSubscriptionsPojo.setEmailcontent2subject(sassSubscriptions.getEmailcontent2subject());
           sassSubscriptionsPojo.setUrl(sassSubscriptions.getUrl());
           sassSubscriptionsPojo.setVerifyEmail(sassSubscriptions.getVerifyEmail());
           sassSubscriptionsPojo.setRedirecturl(sassSubscriptions.getRedirecturl());
           sassSubscriptionsPojo.setVerifyEmail2(sassSubscriptions.getVerifyEmail2());
           sassSubscriptionsPojoList.add( sassSubscriptionsPojo);
       }
       return sassSubscriptionsPojoList;
     }

     public static List<SassSubscriptionsPojo> maprenewSubscriptionEntityToPojo(List<SassSubscriptions> sassSubscriptionsList){
       List<SassSubscriptionsPojo> sassSubscriptionsPojoList = new ArrayList<>();
       for(SassSubscriptions sassSubscriptions:sassSubscriptionsList){
           SassSubscriptionsPojo sassSubscriptionsPojo = new SassSubscriptionsPojo();
           sassSubscriptionsPojo.setSubscriptionId( sassSubscriptions.getSubscriptionId() );
           sassSubscriptionsPojo.setSubscriptionName( sassSubscriptions.getSubscriptionName() );
           sassSubscriptionsPojo.setValidity( sassSubscriptions.getValidity() );
           sassSubscriptionsPojo.setStatus( sassSubscriptions.getStatus() );
           sassSubscriptionsPojo.setValidityType( sassSubscriptions.getValidityType() );
           sassSubscriptionsPojo.setSubscriptionFor( sassSubscriptions.getSubscriptionFor() );
           sassSubscriptionsPojo.setOriginalCharge( sassSubscriptions.getOriginalCharge() );
           sassSubscriptionsPojo.setVersion( sassSubscriptions.getVersion() );
           sassSubscriptionsPojo.setAddonPermission( sassSubscriptions.getAddonPermission() );
           sassSubscriptionsPojo.setCompanies( sassSubscriptions.getCompanies() );
           sassSubscriptionsPojo.setAppUrl( sassSubscriptions.getAppUrl() );
           sassSubscriptionsPojo.setUsers(sassSubscriptions.getUsers());
           sassSubscriptionsPojo.setHiSync( sassSubscriptions.getHiSync() );
           sassSubscriptionsPojo.setHiAccount( sassSubscriptions.getHiAccount() );
           sassSubscriptionsPojo.setHiConnect( sassSubscriptions.getSubscriptionName() );
           sassSubscriptionsPojo.setApplication( sassSubscriptions.getApplication() );
           sassSubscriptionsPojo.setActualPrice( sassSubscriptions.getActualPrice() );
           sassSubscriptionsPojo.setOfferPrice( sassSubscriptions.getOfferPrice() );
           sassSubscriptionsPojo.setDeveloperId( sassSubscriptions.getDeveloperId() );
           sassSubscriptionsPojo.setType( sassSubscriptions.getType() );
//          sassSubscriptionsPojo.setRenewDate( new Date());
           Calendar c = Calendar.getInstance();
           c.setTime(new Date());
           int validity =Integer.parseInt(sassSubscriptions.getValidity());
           c.add(Calendar.DAY_OF_MONTH,+validity);
           Date newDate =c.getTime();
//           sassSubscriptionsPojo.setExpiryDate(newDate);
           sassSubscriptionsPojoList.add( sassSubscriptionsPojo);
       }
       return sassSubscriptionsPojoList;
     }
}
