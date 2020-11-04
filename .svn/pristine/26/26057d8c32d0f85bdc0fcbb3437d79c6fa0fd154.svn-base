package com.hyva.idm.sass.sassservice;

import com.hyva.idm.exceptions.BadRequestException;
import com.hyva.idm.pojo.IDMResponse;
import com.hyva.idm.sass.sassentities.*;
import com.hyva.idm.sass.sassrespositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

import static com.hyva.idm.sass.sassutil.AccessTokenGenerator.randomAlphaNumeric;

@Component
public class HiAccountsService {
    @Autowired
    SassCustomerRepository sassCustomerRepository;
    @Autowired
    SassOrdersRepository sassOrdersRepository;
    @Autowired
    SassSubscriptionRepository sassSubscriptionRepository;
    @Autowired
    SassUserRepository sassUserRepository;
    @Autowired
    SassCompanyRepository sassCompanyRepository;
    @Autowired
    SassCountryRepository sassCountryRepository;
    @Autowired
    SaasStateRepository saasStateRepository;
    @Autowired
    SassCurrencyRepository sassCurrencyRepository;
    @Autowired
    SassAddOnRepository sassAddOnRepository;


    public SassOrders generateParentToken(SassOrders sassOrders){
        String token=randomAlphaNumeric();
        sassOrders.setLoginUniqueId(token);
        sassOrders.setLoginUniqueIdExpiry(new Date());
        return sassOrders;
    }
    public  SassOrders validateLicensekey(String licensekey) {
        SassOrders sassOrders;
        sassOrders = sassOrdersRepository.getSassOrdersByLicenceKey(licensekey);
        if (sassOrders == null) {
            throw new BadRequestException("user not found", HttpStatus.BAD_REQUEST.value());
        }
        return sassOrders;
    }

    public SassSubscriptions getSubscriptionDetails(Long subscriptionId){
        SassSubscriptions sassSubscriptions;
         sassSubscriptions = sassSubscriptionRepository.findBySubscriptionId(subscriptionId);
         return sassSubscriptions;
    }

    public SassOrders getSassOrderDetails(String loginUniqueId){
        SassOrders  sassOrders = sassOrdersRepository.getSassOrdersByLoginUniqueId(loginUniqueId);
        return sassOrders;
    }

    public SassOrders getSassOrderObj(Long sassOrdersId){
        SassOrders sassOrders;
        sassOrders = sassOrdersRepository.findOne(sassOrdersId);
        return sassOrders;
    }

    public SassCustomer getSassCustomerDetails(String customerName){
        SassCustomer sassCustomer;
        sassCustomer = sassCustomerRepository.findDistinctByCustomerName(customerName);
        return sassCustomer;
    }

    public String sassCompanyEmailChecking(String  sassToken,Long sassOrderId){
        SassCompany sassTokenExist =  sassCompanyRepository.findDistinctByCompanyEmailAndSassOrdersId(sassToken,sassOrderId);
        if(sassTokenExist != null){
            return  "Already Exist";
        }else {
            return "success";
        }
    }

    public SassCompany sassCompanyObj(String sassToken,Long sassOrderId){
        SassCompany sassTokenExist =  sassCompanyRepository.findDistinctByCompanyEmailAndSassOrdersId(sassToken,sassOrderId);
       return sassTokenExist;
    }

    public SassCompany sassCompanySave(SassCompany sassCompany){
        SassCompany sassCompanyObj = sassCompanyRepository.save(sassCompany);
        return  sassCompanyObj;
    }

    public SassCompany sassCompanyTokenObj(String sassToken){
        SassCompany sassTokenExist =  sassCompanyRepository.findDistinctByLoginUniqueId(sassToken);
        return sassTokenExist;
    }

    public void sassOrdersSave(SassOrders sassOrders){
        sassOrdersRepository.save(sassOrders);
    }

    public SassCountry sassCountryObj(Long countryId){
        SassCountry sassCountry1 = sassCountryRepository.findOne(countryId);
        return sassCountry1;
    }

    public SaasState sassStateObj(Long stateId){
        SaasState saasState = saasStateRepository.findOne(stateId);
        return saasState;
    }

    public SassCurrency sassCurrencyObj(Long currencyId){
        SassCurrency sassCurrency = sassCurrencyRepository.findOne(currencyId);
        return sassCurrency;
    }

}
