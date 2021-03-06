package com.hyva.idm.sass.sassmapper;

import com.hyva.idm.sass.sassentities.PosPaymentTypes;
import com.hyva.idm.sass.sassentities.SassCompany;
import com.hyva.idm.sass.sassentities.SassOrders;
import com.hyva.idm.sass.sassentities.SassSubscriptions;
import com.hyva.idm.sass.sasspojo.SassCompanyPojo;
import com.hyva.idm.sass.sasspojo.SassOrdersPojo;
import com.hyva.idm.sass.sasspojo.SassPaymentMethodPojo;
import com.hyva.idm.sass.sasspojo.SassSubscriptionsPojo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class SassOrdersMapper {
    public static SassOrders mapPojoToEntity(SassOrdersPojo sassOrdersPojo){
        SassOrders sassOrders=new SassOrders();
        sassOrders.setUsername(sassOrdersPojo.getUsername());
        sassOrders.setPassword(sassOrdersPojo.getPassword());
        sassOrders.setCompanyEmail(sassOrdersPojo.getCompanyEmail());
        sassOrders.setCustomerName(sassOrdersPojo.getCustomerName());
        sassOrders.setCompanyName(sassOrdersPojo.getCompanyName());
        sassOrders.setCompanyAddress(sassOrdersPojo.getCompanyAddress());
        sassOrders.setDeliveryType(sassOrdersPojo.getDeliveryType());
        sassOrders.setNewsletter(sassOrdersPojo.getNewsletter());
        sassOrders.setCompanyPhone(sassOrdersPojo.getCompanyPhone());
        sassOrders.setPackagesSASSId(sassOrdersPojo.getPackagesSASSId());
        sassOrders.setCompanyNo(sassOrdersPojo.getCompanyNo());
//        sassOrders.setCountry(sassOrdersPojo.getCountry());
//        sassOrders.setCurrency(sassOrdersPojo.getCurrency());
        sassOrders.setFaxno(sassOrdersPojo.getFaxno());
        sassOrders.setLanguage(sassOrdersPojo.getLanguage());
        sassOrders.setGstRegistered(sassOrdersPojo.getGstRegistered());
        sassOrders.setGstRegisteredDate(sassOrdersPojo.getGstRegisteredDate());
        sassOrders.setIncorpDate(sassOrdersPojo.getIncorpDate());
        sassOrders.setPostingStatus("Pending");
        sassOrders.setPan(sassOrdersPojo.getPan());
        sassOrders.setOrderValue((new Date().getTime()));
        sassOrders.setWebsite(sassOrdersPojo.getWebsite());
        return sassOrders;
    }

    public static List<SassOrdersPojo> mapEntityToPojo(List<SassOrders> sassOrders){
        List<SassOrdersPojo> list=new ArrayList<>();
        for(SassOrders sassOrders1:sassOrders) {
            SassOrdersPojo sassOrdersPojo = new SassOrdersPojo();
            sassOrdersPojo.setCompanyName(sassOrders1.getCompanyName());
            sassOrdersPojo.setCompanyEmail(sassOrders1.getCompanyEmail());
            sassOrdersPojo.setSassOrdersId(sassOrders1.getSassOrdersId());
            sassOrdersPojo.setCustomerName(sassOrders1.getCustomerName());
            sassOrdersPojo.setCompanyPhone(sassOrders1.getCompanyPhone());
            sassOrdersPojo.setIncorpDate(sassOrders1.getCreationDate());
            sassOrdersPojo.setOrderValue(sassOrders1.getOrderValue());
            if(sassOrders1.getSassSubscriptionsId()!=null) {
                sassOrdersPojo.setSubscriptionId(String.valueOf(sassOrders1.getSassSubscriptionsId().getSubscriptionId()));
                sassOrdersPojo.setSubscriptionName(sassOrders1.getSassSubscriptionsId().getSubscriptionName());
            }
            if(sassOrders1.getSassSubscriptionsId()!=null)
            sassOrdersPojo.setValidity(sassOrders1.getSassSubscriptionsId().getValidity());
            sassOrdersPojo.setPostingStatus(sassOrders1.getPostingStatus());
            sassOrdersPojo.setLicenceKey(sassOrders1.getLicenceKey());
            sassOrdersPojo.setRenew(sassOrders1.getRenew());
            sassOrdersPojo.setCreatedDate(sassOrders1.getCreatedDate());
            sassOrdersPojo.setExpiryDate(sassOrders1.getExpiryDate());
            if(sassOrders1.getExpiryDate().before(new Date())){
                sassOrdersPojo.setValidityStatus("Expired");
            }else {
                sassOrdersPojo.setValidityStatus("Active");
            }

            sassOrdersPojo.setDeliveryType(sassOrders1.getDeliveryType());
            list.add(sassOrdersPojo);
        }
        return list;
    }

    public static List<SassCompanyPojo> mapCompanyDetailsEntityToPojo(List<SassCompany> sassCompanyList){
        List<SassCompanyPojo> list=new ArrayList<>();
        for(SassCompany sassCompany:sassCompanyList) {
            SassCompanyPojo sassCompanyPojo = new SassCompanyPojo();
            sassCompanyPojo.setCompanyNo(sassCompany.getCompanyNo());
            sassCompanyPojo.setCompanyGSTno(sassCompany.getCompanyGSTno());
            sassCompanyPojo.setCompanyAddress(sassCompany.getCompanyAddress());
            sassCompanyPojo.setUserName(sassCompany.getUsername());
            sassCompanyPojo.setPassword(sassCompany.getPassword());
            sassCompanyPojo.setLicenceKey(sassCompany.getLicenceKey());
            list.add(sassCompanyPojo);
        }
        return list;
    }
    public static List<SassSubscriptionsPojo> mapSubcriptionDetailsEntityToPojo(List<SassSubscriptions> sassSubscriptionsList){
        List<SassSubscriptionsPojo> list=new ArrayList<>();
        for(SassSubscriptions sassSubscriptions:sassSubscriptionsList) {
            SassSubscriptionsPojo sassSubscriptionsPojo = new SassSubscriptionsPojo();
            sassSubscriptionsPojo.setSubscriptionName(sassSubscriptions.getSubscriptionName());
            sassSubscriptionsPojo.setValidity(sassSubscriptions.getValidity());
            sassSubscriptionsPojo.setCompanies(sassSubscriptions.getCompanies());
            sassSubscriptionsPojo.setUsers(sassSubscriptions.getUsers());
//            sassSubscriptionsPojo.setCreatedDate(sassSubscriptions.getCreatedDate());
//            sassSubscriptionsPojo.setExpiryDate(sassSubscriptions.getExpiryDate());
            list.add(sassSubscriptionsPojo);
        }
        return list;
    }
    public static List<SassPaymentMethodPojo> mapPaymentDetailsEntityToPojo(List<PosPaymentTypes> posPaymentTypesList,SassOrders sassOrders){
        List<SassPaymentMethodPojo> list=new ArrayList<>();
        SassPaymentMethodPojo stateDTO = new SassPaymentMethodPojo();
        if(posPaymentTypesList.size()>0) {
            for (PosPaymentTypes state : posPaymentTypesList) {
                stateDTO.setActualPrice(state.getSassOrders().getSassSubscriptionsId().getActualPrice());
                stateDTO.setPaymentmethodType(state.getPaymentMode());
                stateDTO.setTotalAmount(state.getTotalAmount());
                stateDTO.setBalanceAmount(state.getBalanceAmount());
                stateDTO.setStatus(state.getStatus());
                stateDTO.setTransactionDate(state.getTransactionDate());
                list.add(stateDTO);
            }
            return list;
        }
        else{
            stateDTO.setTransactionDate(new Date());
            stateDTO.setActualPrice(sassOrders.getSassSubscriptionsId().getActualPrice());
            list.add(stateDTO);
            return list;
        }
    }




}
