package com.hyva.idm.sass.sassendpoints;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.hyva.idm.pojo.IDMResponse;
import com.hyva.idm.sass.sassconstant.HiAccountConstant;
import com.hyva.idm.sass.sassconstant.HiConnectConstants;
import com.hyva.idm.sass.sassentities.*;
import com.hyva.idm.sass.sasspojo.CompanyInfoDto;
import com.hyva.idm.sass.sasspojo.subscriptionDetailsLoginPojo;
import com.hyva.idm.sass.sassrespositories.SassCompanyPermissionRepository;
import com.hyva.idm.sass.sassrespositories.SassCompanyRepository;
import com.hyva.idm.sass.sassrespositories.SassOrdersRepository;
import com.hyva.idm.sass.sassrespositories.SassSubscriptionRepository;
import com.hyva.idm.sass.sassservice.HiAccountsService;
import com.hyva.idm.sass.sassservice.SassOrdersService;
import com.hyva.idm.sass.sasstesting.SaasUsers;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.hyva.idm.sass.sassutil.AccessTokenGenerator.randomAlphaNumeric;

/**
 * Created by azgar on 1/6/18.
 */
@RestController
@RequestMapping(HiAccountConstant.HI_ACCOUNT_SERVICES)
public class HiAccountsEndPoint {

    @Autowired
    HiAccountsService hiAccountsService;
    @Autowired
    SassOrdersRepository sassOrdersRepository;
    @Autowired
    SassCompanyPermissionRepository sassCompanyPermissionRepository;
    @Autowired
    SassSubscriptionRepository sassSubscriptionRepository;
    @Autowired
    SassCompanyRepository sassCompanyRepository;

    @RequestMapping(value = "/v3/getRegistration",
            method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public IDMResponse getRegistration(@RequestBody String licensekey) throws JSONException {
        SassOrders sassOrders=hiAccountsService.validateLicensekey(licensekey);
        sassOrders = hiAccountsService.generateParentToken(sassOrders);
        hiAccountsService.sassOrdersSave(sassOrders);
        SassCompany sassCompany = sassCompanyRepository.findByLicenceKey(licensekey);
        sassCompany.setLoginUniqueId(sassOrders.getLoginUniqueId());
        sassCompany.setLoginUniqueIdExpiry(sassOrders.getLoginUniqueIdExpiry());
        sassCompanyRepository.save(sassCompany);
        Gson gson = new Gson();
        String companyData = gson.toJson(sassCompany);
        JSONObject jsonObject = new JSONObject(companyData);
        jsonObject.remove("sassSubscriptionsId");
        jsonObject.remove("sassOrdersId");
        jsonObject.remove("sassCustomerId");
        String companyData1 = jsonObject.toString();
        return new IDMResponse(HttpStatus.OK.value(), "success",companyData1);
    }

    @RequestMapping(value = "/v3/Check",
            method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public IDMResponse getCheck(@RequestBody String licensekey){
        SassOrders sassOrders=hiAccountsService.getSassOrderDetails(licensekey);
        return new IDMResponse(HttpStatus.OK.value(), "success",sassOrders);
    }

    @RequestMapping(value="/v3/getSubscription",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public IDMResponse getSubscription(@RequestBody String sassToken){
        //Based on sassToken getting subscriptionId from sassOrders
        SassOrders sassOrders = hiAccountsService.getSassOrderDetails(sassToken);
        //Add company(sassOrder is null getting sassToken from sass_Company)
        if (sassOrders == null) {
            SassCompany sassCompany = hiAccountsService.sassCompanyTokenObj(sassToken);
            sassOrders = hiAccountsService.getSassOrderObj(sassCompany.getSassOrdersId().getSassOrdersId());
        }
        SassSubscriptions sassSubscriptions=hiAccountsService.getSubscriptionDetails(Long.parseLong(sassOrders.getSassSubscriptionsId().getSubscriptionId().toString()));
//        SassCustomer sassCustomer = hiAccountsService.getSassCustomerDetails(sassOrders.getCustomerName());
        subscriptionDetailsLoginPojo subDetailsLoginPojo = new subscriptionDetailsLoginPojo();
        subDetailsLoginPojo.setSassSubscriptionsObj(sassSubscriptions);
        subDetailsLoginPojo.setSassOrdersObj(sassOrders);
//        subDetailsLoginPojo.setSassCustomerObj(sassCustomer);
        return new IDMResponse(HttpStatus.OK.value(), "success",subDetailsLoginPojo);
    }

    @RequestMapping(value = "/v3/updateSassOrders",
            method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public IDMResponse updateSassOrders(@RequestBody String companyDeails) throws ParseException {
        Gson gson = new Gson();
        CompanyInfoDto companyInfoDto = gson.fromJson(companyDeails,CompanyInfoDto.class);
        SassCompany sassCompanyObj = sassCompanyRepository.findOne(Long.parseLong(companyInfoDto.getSassOrdersId()));
        sassCompanyObj.setCompnayId(Long.parseLong(companyInfoDto.getSassOrdersId()));

        if(!companyInfoDto.getAddress().equals("") && !companyInfoDto.getAddress().equals("null")) {
            sassCompanyObj.setCompanyAddress(companyInfoDto.getAddress());
        }
        if(companyInfoDto.getEmail() != null && !companyInfoDto.getEmail().equals("")) {
            sassCompanyObj.setCompanyEmail(companyInfoDto.getEmail());
        }
        sassCompanyObj.setCompanyName(companyInfoDto.getCompany_name());
        sassCompanyObj.setCompanyNo(companyInfoDto.getCompany_no());
        if(companyInfoDto.getPanNo() != null && !companyInfoDto.getPanNo().equals("")) {
            sassCompanyObj.setPan(companyInfoDto.getPanNo());
        }
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        sassOrdersObj.setIncorpDate(sdf.parse(companyInfoDto.getIncdate()));
        if(companyInfoDto.getPhone() != null && !companyInfoDto.getPhone().equals("")) {
            sassCompanyObj.setCompanyPhone(companyInfoDto.getPhone());
        }
        SassCountry countryObj = hiAccountsService.sassCountryObj(companyInfoDto.getCountryId());
        if(countryObj != null) {
            sassCompanyObj.setCountryId(countryObj);
        }
        SaasState stateObj = hiAccountsService.sassStateObj(companyInfoDto.getStateId());
        if(stateObj != null) {
            sassCompanyObj.setStateId(stateObj);
        }
        SassCurrency currencyObj = hiAccountsService.sassCurrencyObj(companyInfoDto.getCountryId());
        if(currencyObj != null) {
            sassCompanyObj.setCurrencyId(currencyObj);
        }sassCompanyObj.setGstRegisteredDate(companyInfoDto.getGSTRegisteredDate());
        sassCompanyObj.setCompanyGSTno(companyInfoDto.getRegisterNo());
        sassCompanyObj.setGstRegistered(companyInfoDto.getRegisterNo());
        if(!companyInfoDto.getFax().equals("") && companyInfoDto.getFax() == null) {
            sassCompanyObj.setFaxno(Long.parseLong(companyInfoDto.getFax()));
        }
        if(companyInfoDto.getWeb() != null && !companyInfoDto.getWeb().equals("")) {
            sassCompanyObj.setWebsite(companyInfoDto.getWeb());
        }
        if(companyInfoDto.getLang() != null && !companyInfoDto.getLang().equals("")) {
            sassCompanyObj.setLanguage(companyInfoDto.getLang());
        }
        sassCompanyRepository.save(sassCompanyObj);
        SassOrders sassOrders = new SassOrders();
//        SassOrders sassOrdersObj = sassOrdersRepository.findOne(sassCompanyObj.getSassOrdersId().getSassOrdersId());
//        sassOrdersObj.setSassOrdersId(Long.parseLong(companyInfoDto.getSassOrdersId()));

//        if(!companyInfoDto.getAddress().equals("") && !companyInfoDto.getAddress().equals("null")) {
//            sassOrdersObj.setCompanyAddress(companyInfoDto.getAddress());
//        }
//        if(companyInfoDto.getEmail() != null && !companyInfoDto.getEmail().equals("")) {
//            sassOrdersObj.setCompanyEmail(companyInfoDto.getEmail());
//        }
//        sassOrdersObj.setCompanyName(companyInfoDto.getCompany_name());
//        sassOrdersObj.setCompanyNo(companyInfoDto.getCompany_no());
//        if(companyInfoDto.getPanNo() != null && !companyInfoDto.getPanNo().equals("")) {
//            sassOrdersObj.setPan(companyInfoDto.getPanNo());
//        }
////        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
////        sassOrdersObj.setIncorpDate(sdf.parse(companyInfoDto.getIncdate()));
//        if(companyInfoDto.getPhone() != null && !companyInfoDto.getPhone().equals("")) {
//            sassOrdersObj.setCompanyPhone(companyInfoDto.getPhone());
//        }
//        if(countryObj != null) {
//            sassOrdersObj.setCountryId(countryObj);
//        }
//        if(stateObj != null) {
//            sassOrders.setStateId(stateObj);
//        }
//        if(currencyObj != null) {
//            sassOrders.setCurrencyId(currencyObj);
//        }
//        sassOrdersObj.setGstRegisteredDate(companyInfoDto.getGSTRegisteredDate());
//        sassOrdersObj.setCompanyGSTno(companyInfoDto.getRegisterNo());
//        sassOrdersObj.setGstRegistered(companyInfoDto.getRegisterNo());
//        if(!companyInfoDto.getFax().equals("") && companyInfoDto.getFax() == null) {
//            sassOrdersObj.setFaxno(Long.parseLong(companyInfoDto.getFax()));
//        }
//        if(companyInfoDto.getWeb() != null && !companyInfoDto.getWeb().equals("")) {
//            sassOrdersObj.setWebsite(companyInfoDto.getWeb());
//        }
//        if(companyInfoDto.getLang() != null && !companyInfoDto.getLang().equals("")) {
//            sassOrdersObj.setLanguage(companyInfoDto.getLang());
//        }
//        hiAccountsService.sassOrdersSave(sassOrdersObj);
       return new IDMResponse(HttpStatus.OK.value(), "success",sassCompanyObj);
    }

    @RequestMapping(value = "/v3/createCompany",
            method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public IDMResponse createCompany(@RequestBody String companyData){
        Gson gson = new Gson();
        SassCompany sassCompany = gson.fromJson(companyData,SassCompany.class);
        SassCompany responseType = hiAccountsService.sassCompanySave(sassCompany);
        return new IDMResponse(HttpStatus.OK.value(), "success",responseType);
    }

    @RequestMapping(value = "/v3/companyAdittion",
            method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public IDMResponse companyAdittion(@RequestBody String companyData){
        Gson gson = new Gson();
        SassCompany sassCompanyObj = null;
        SassCompany sassCompany = gson.fromJson(companyData,SassCompany.class);
        SassOrders sassOrders = hiAccountsService.getSassOrderDetails(sassCompany.getLoginUniqueId());
//        String sassTokenResponse = hiAccountsService.sassCompanyEmailChecking(sassCompany.getEmail(),sassOrders.getSassOrdersId());
//        String sassTokenResponse = hiAccountsService.sassTokenChecking(sassCompany.getLoginUniqueId());
        //Based on Login UniqueId fetching sassCompanyObj
        SassCompany sassCompy = sassCompanyRepository.findDistinctByLoginUniqueId(sassCompany.getLoginUniqueId());
        //Query to count parentCompanyRegNo
        int parentCmpyRegNo = sassCompanyRepository.countByParentCompanyRegNo(sassCompy.getHiConnectCompnyRegNo());
        int parent=parentCmpyRegNo+1;
        //No of Companies should not exced given in subscriptionTable
       if(sassCompy.getSassSubscriptionsId().getCompanies() > parent) {
            if (sassCompany.getLoginUniqueId().equals(sassOrders.getLoginUniqueId())) {
                String token = randomAlphaNumeric();
                sassCompany.setLoginUniqueId(token);
                sassCompany.setSassOrdersId(sassOrders);
                sassCompany.setSassSubscriptionsId(sassCompany.getSassOrdersId().getSassSubscriptionsId());
                sassCompany.setParentCompanyRegNo(sassCompy.getHiConnectCompnyRegNo());
                sassCompanyObj = hiAccountsService.sassCompanySave(sassCompany);
            }
            return new IDMResponse(HttpStatus.OK.value(), "success", gson.toJson(sassCompanyObj));
       }else{
//            sassCompanyObj = hiAccountsService.sassCompanyObj(sassCompany.getEmail(),sassOrders.getSassOrdersId());
          return new IDMResponse(HttpStatus.OK.value(), "No of companies is exceded", "");
       }
    }

    @RequestMapping(value="/v3/updateCompanyPermission", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public IDMResponse updateCompanyPermission(@RequestBody String sassToken){
        SassOrders ordersObj = sassOrdersRepository.getSassOrdersByLoginUniqueId(sassToken);
        if(ordersObj==null){
            SassCompany sassCompany = hiAccountsService.sassCompanyTokenObj(sassToken);
               ordersObj = hiAccountsService.getSassOrderObj(sassCompany.getSassOrdersId().getSassOrdersId());

        }

        List<SassSubscriptions> subscriptionObj = sassSubscriptionRepository.getBySubscriptionId(ordersObj.getSassSubscriptionsId().getSubscriptionId());
        return new IDMResponse(HttpStatus.OK.value(), "Already Exist",subscriptionObj);
    }

//@RequestMapping(value="/v3accountPassword",
//        method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
//public IDMResponse companypassword(@RequestBody String password){
//    SassOrders sassOrders=hiAccountsService.getSassOrderDetails(password);
//    return new IDMResponse(HttpStatus.OK.value(), "success",sassOrders);
//
//}







}
