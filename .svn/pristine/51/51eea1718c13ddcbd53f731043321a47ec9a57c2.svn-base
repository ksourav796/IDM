package com.hyva.idm.sass.sassendpoints;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.hyva.idm.icitem.IcItem;
import com.hyva.idm.icitem.IcItemRepository;
import com.hyva.idm.pkt.pktRelations.PktBuilder;
import com.hyva.idm.pkt.pktRelations.PktPermissions;
import com.hyva.idm.pkt.pktService.PktService;
import com.hyva.idm.sass.sassconstant.HiConnectConstants;
import com.hyva.idm.pojo.IDMResponse;
import com.hyva.idm.sass.sassentities.*;
import com.hyva.idm.sass.sasspojo.*;
import com.hyva.idm.sass.sasspojo.PktPermissionPojo;
import com.hyva.idm.sass.sassrespositories.*;
import com.hyva.idm.sass.sassservice.*;
import com.hyva.idm.sass.sassutil.ObjectMapperUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import com.hyva.idm.defaultPermissions.defaultPermissions;


/**
 * Created by azgar on 1/6/18.
 */
@RestController
@RequestMapping(HiConnectConstants.HI_CONNECT_SERVICES)
public class HiConnectEndPoint {
    @Autowired
    SassOrdersService sassOrdersService;
    @Autowired
    SassCustomerNotificationsService sassCustomerNotificationsService;
    @Autowired
    SaasTranscationsDataService saasTranscationsDataService;
    @Autowired
    SassControlPanelService sassControlPanelService;
    @Autowired
    CartRegistrationRepository cartRegistrationRepository;
    @Autowired
    IcItemRepository icItemRepository;
    @Autowired
    SassUserRepository SassUserRepository;
    @Autowired
    SassCustomerNotificationsRepository sassCustomerNotificationsRepository;
    @Autowired
    SassCompanyRepository sassCompanyRepository;
    @Autowired
    HiAccountsService HiAccountsService;
    @Autowired
    SassSubscriptionRepository SassSubscriptionRepository;
    @Autowired
    SassOrdersRepository sassOrdersRepository;
    @Autowired
    CartCustomerRepository cartCustomerRepository;
    @Autowired
    PktService pktService;

    @RequestMapping(value = HiConnectConstants.HI_CONNECT_VERSION + HiConnectConstants.HI_CONNECT_COMPANY_SEARCH, method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public IDMResponse searchCompanyNames(@RequestBody String jsonString) throws JSONException {
        JSONObject jsonObject = new JSONObject(jsonString);
        if (jsonObject.length() > 0) {
            String CompanyName = jsonObject.getString("company_name");
            List<SassCompany> customersList = sassCompanyRepository.findByCompanyNameStartingWith(CompanyName);
            Gson gson = new Gson();
            String jsonCartList = gson.toJson(customersList);
            return new IDMResponse(HttpStatus.OK.value(), "success", jsonCartList);
        } else {
            return new IDMResponse(HttpStatus.OK.value(), "empty value ");
        }
    }
    @RequestMapping(value = "/getRestaurantNamesList",method = RequestMethod.POST)
    public ResponseEntity getRestaurantNamesList(){
        return ResponseEntity.status(200).body(sassCustomerNotificationsService.getList());
    }

    @RequestMapping(value = "getHiconnectNumber", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public IDMResponse searchCompanyhiconnectno(@RequestBody String jsonString) throws JSONException {
        JSONObject jsonObject = new JSONObject(jsonString);
        String username = jsonObject.getString("username");
        String password = jsonObject.getString("password");
        String email = jsonObject.getString("email");

        SassCompany sascomp = sassCompanyRepository.findDistinctByCompanyEmailAndUsernameAndPassword(email, username, password);

        if (sascomp != null) {
            return new IDMResponse(HttpStatus.OK.value(), "success", sascomp);
        } else {
            return new IDMResponse(HttpStatus.NOT_FOUND.value(), "notfound", null);
        }

    }

    @RequestMapping(value = HiConnectConstants.HI_CONNECT_VERSION + HiConnectConstants.HI_CONNECT_NOTIFICATION_COMPANY_FOR_SUPPLIER, method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public IDMResponse setHiConnectNotificationsCompanyForSupplier(@RequestBody String jsonString) throws JSONException {
        JSONObject jsonObject = new JSONObject(jsonString);
        return new IDMResponse(HttpStatus.OK.value(), "success");
    }


    @RequestMapping(value = HiConnectConstants.HI_CONNECT_VERSION + HiConnectConstants.HI_CONNECT_SET_NOTIFICATION_COMPANY, method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public IDMResponse setHiConnectNotificationsCompany(@RequestBody String jsonString) throws JSONException {
        JSONObject jsonObject = new JSONObject(jsonString);
        String notificationData = jsonObject.getString("jsonData");
        Gson gson = new Gson();
        CustomerNotificationsPojo customerNotificationsObj = gson.fromJson(notificationData, CustomerNotificationsPojo.class);
        List<SassCompany> toreglist = sassOrdersService.getSaasCustomerRegNo(customerNotificationsObj.getToRegno());
        List<SassCompany> fromreglist = sassOrdersService.getSaasCustomerRegNo(customerNotificationsObj.getFromRegno());
        sassCustomerNotificationsService.getCustomerNotificationSave(customerNotificationsObj, toreglist, fromreglist);
        return new IDMResponse(HttpStatus.OK.value(), "success");
    }

    @RequestMapping(value = HiConnectConstants.HI_CONNECT_VERSION + HiConnectConstants.HI_C0NNECT_ACCEPT_REJECT_NOTIFICATION_FOR_SUPP, method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public IDMResponse confirmAcceptanceOrRejectNotificationsForSupp(@RequestBody String jsonString) throws JSONException {
        JSONObject jsonObject = new JSONObject(jsonString);
        Gson gson = new Gson();
        CustomerNotificationsPojo customerNotificationsObj = gson.fromJson(jsonObject.toString(), CustomerNotificationsPojo.class);
        List<SassCompany> toreglist = sassOrdersService.getSaasCustomerRegNo(customerNotificationsObj.getToRegno());
        List<SassCompany> fromreglist = sassOrdersService.getSaasCustomerRegNo(customerNotificationsObj.getFromRegno());
        sassCustomerNotificationsService.getCustomerNotificationSave(customerNotificationsObj, toreglist, fromreglist);
        return new IDMResponse(HttpStatus.OK.value(), "success");
    }


    @RequestMapping(value = HiConnectConstants.HI_CONNECT_VERSION + HiConnectConstants.HI_C0NNECT_ACCEPT_REJECT_NOTIFICATION, method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public IDMResponse confirmAcceptanceOrRejectNotifications(@RequestBody String jsonString) throws JSONException {
        JSONObject jsonObject = new JSONObject(jsonString);
        String jObj = jsonObject.getString("jsonData");
        JSONObject jsonObject1 = new JSONObject(jObj);
        Gson gson = new Gson();
        CustomerNotificationsPojo customerNotificationsObj = gson.fromJson(jsonObject1.toString(), CustomerNotificationsPojo.class);
        List<SassCompany> toreglist = sassOrdersService.getSaasCustomerRegNo(jsonObject1.get("toRegno").toString());
        List<SassCompany> fromreglist = sassOrdersService.getSaasCustomerRegNo(jsonObject1.get("fromRegno").toString());
        sassCustomerNotificationsService.getCustomerNotificationSave(customerNotificationsObj, toreglist, fromreglist);
        return new IDMResponse(HttpStatus.OK.value(), "success");
    }


    @RequestMapping(value = HiConnectConstants.HI_CONNECT_VERSION + HiConnectConstants.HI_CONNECT_NOTIFICATIONS, method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Object getHiConnectNotifications(@RequestBody String jsonString) throws JSONException {
        JSONObject jsonObject = new JSONObject(jsonString);
        String regNo = jsonObject.getString("regno");
        String typeFlag = jsonObject.getString("type_flag");
        String status = "";
        List<CustomerNotifications> notificationData = null;
        List<SassCompany> saasCustomerList = null;
        List<CustomerNotifications> regNoList = new ArrayList<>();
        List<CustomerNotifications> gettingstatus = sassCustomerNotificationsService.getStatus(regNo);
        for (int i = 0; i < gettingstatus.size(); i++) {
            if (gettingstatus.get(i) != null) {
                status = gettingstatus.get(i).getStatus();
            } else {
                status = "pending";
            }
            if (!status.equalsIgnoreCase("close")) {
                notificationData = sassCustomerNotificationsService.getCustomerRegNo(regNo, status);
            } else {
                notificationData = sassCustomerNotificationsService.getCustomerRegNo("0", "");
            }
            regNoList.addAll(notificationData);

        }
//        if(status=="Accepted"){
//            regNoList=sassCustomerNotificationsService.getCustomerRegNo(regNo,status);
//        }

        if (regNoList.size() > 0) {
            saasCustomerList = sassOrdersService.getSaasCustomerRegNo(regNoList.get(0).getFromRegno());
        } else {
            saasCustomerList = sassOrdersService.getSaasCustomerRegNo("0");
        }
        CustomerListBasedOnToRegNoPojo custNtftnList = new CustomerListBasedOnToRegNoPojo();
        custNtftnList.setSassCustomerList(saasCustomerList);
        custNtftnList.setCustomerNotificationsList(regNoList);
        List<TransactionsData> transactionsDataList = sassOrdersService.getTransactionList();
        custNtftnList.setTransactionsDataList(transactionsDataList);
        Gson gson = new Gson();
        String custNotftnList = gson.toJson(custNtftnList);
        return new IDMResponse(HttpStatus.OK.value(), "success", custNotftnList);
    }

    @RequestMapping(value = HiConnectConstants.ZOMATO_VERSION + HiConnectConstants.HI_CONNECT_BROADCAST_ZSO_DATA, method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Object getHiConnectNotification(@RequestBody String jsonString) throws JSONException {
        JSONObject jsonObject = new JSONObject(jsonString);
        String regNo = jsonObject.getString("regno");
        String typeFlag = jsonObject.getString("type_flag");
        String status = "";
        List<CustomerNotifications> notificationData = null;
        List<SassCompany> saasCustomerList=null;
        List<CustomerNotifications> gettingstatus = sassCustomerNotificationsService.getStatus(regNo);
        List<CustomerNotifications> regNoList = new ArrayList<>();
        for(int i=0;i<gettingstatus.size();i++){
            if (gettingstatus.get(i) != null) {
                status = gettingstatus.get(i).getStatus();
            } else {
                status = "pending";
            }
            if (!status.equalsIgnoreCase("close")) {
                notificationData = sassCustomerNotificationsService.getCustomerReg(regNo, status);
            } else {
                notificationData = sassCustomerNotificationsService.getCustomerReg("0", "");
            }
            //regNoList.addAll(notificationData);
        }
////        if(status=="Close"){
//            regNoList=sassCustomerNotificationsService.getCustomerReg(regNo,status);
//        }
        if (notificationData.size() > 0) {
            saasCustomerList = sassOrdersService.getSaasCustomerReg(notificationData.get(0).getFromRegno());
        } else {
            saasCustomerList = sassOrdersService.getSaasCustomerReg("0");
        }
        CustomerListBasedOnToRegNoPojo custNtftnList = new CustomerListBasedOnToRegNoPojo();
        custNtftnList.setSassCustomerList(saasCustomerList);
        custNtftnList.setCustomerNotificationsList(notificationData);
        List<TransactionsData> transactionsDataList = sassOrdersService.getTransactionList();
        custNtftnList.setTransactionsDataList(transactionsDataList);
        Gson gson = new Gson();
        String custNotftnList = gson.toJson(custNtftnList);
        return new IDMResponse(HttpStatus.OK.value(), "success", custNotftnList);
    }
    @RequestMapping(value = HiConnectConstants.HI_CONNECT_VERSION + HiConnectConstants.HI_CONNECT_NOTIFICATION_TRANSACTION_DATA, method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public IDMResponse getNotificationTransactionData(@RequestBody String jsonString) throws JSONException {
        JSONObject jsonObject = new JSONObject(jsonString);
        return new IDMResponse(HttpStatus.OK.value(), "success");
    }


    //PurchaseOrder
    @RequestMapping(value = HiConnectConstants.HI_CONNECT_VERSION + HiConnectConstants.HI_CONNECT_BROADCAST_PO_DATA, method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public IDMResponse BroadCastPostPurchaseOrderData(@RequestBody String jsonString) throws JSONException {
        SassCompany customerObj = null;
        JSONObject jsonObject = new JSONObject(jsonString);
        Gson gson = new Gson();
        String status = "pending";
        CustomerNotificationsPojo customerNotificationsPojo = new CustomerNotificationsPojo();
        String jsonObj = jsonObject.getString("jsonData");
        JSONObject jsonData = new JSONObject(jsonObj);
        customerNotificationsPojo.setSubscriptionType(jsonData.get("subscriptionType").toString());
        customerNotificationsPojo.setObjectdata(jsonString);
        customerNotificationsPojo.setTotalcheckoutamt(jsonData.get("totalCheckOutamt").toString());
        customerNotificationsPojo.setTotaltax(jsonData.get("totalTaxAmt").toString());
        customerNotificationsPojo.setFromRegno(jsonData.get("from_reg").toString());
        customerNotificationsPojo.setToRegno(jsonData.get("to_reg").toString());
        customerNotificationsPojo.setTypeDoc(jsonData.get("typeDoc").toString());
        customerNotificationsPojo.setTypeFlag(jsonData.get("typeFlag").toString());
        customerNotificationsPojo.setStatus(status);
        customerNotificationsPojo.setPiNo(jsonData.get("piNo").toString());
        customerNotificationsPojo.setViewStatus("Pending");
        customerObj = sassOrdersService.getSaasCustomerRegNoObj(customerNotificationsPojo.getFromRegno());
//        customerNotificationsPojo.setFromCompname(jsonData.get("supplierName").toString());
        customerNotificationsPojo.setFromCompname(customerObj.getCustomerName());
        customerObj = sassOrdersService.getSaasCustomerRegNoObj(customerNotificationsPojo.getToRegno());
        customerNotificationsPojo.setToCompname(customerObj.getCustomerName());
        if (customerNotificationsPojo.getTypeDoc() != null) {
            DestinationMap map = sassControlPanelService.getMapObject(customerNotificationsPojo.getTypeDoc());
//            customerNotificationsPojo.setDestinationmap(map.getDestinationmap());
        }
        if (customerNotificationsPojo.getSubscriptionType().equals("DesktopWithRTR")) {
            customerNotificationsPojo.setSubscriptionType("RTR");
        }
        if (customerNotificationsPojo.getSubscriptionType().equals("Hiconnect")) {
            customerNotificationsPojo.setSubscriptionType("Hiconnect");
        }
        sassCustomerNotificationsService.getPurchaseOrderSave(customerNotificationsPojo);
        return new IDMResponse(HttpStatus.OK.value(), "success");
    }

    @RequestMapping(value = HiConnectConstants.HI_CONNECT_VERSION + HiConnectConstants.HI_CONNECT_BROADCAST_RI_DATA, method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public IDMResponse BroadCastPostReceiveItemData(@RequestBody String jsonString) throws JSONException {
        SassCompany customerObj = null;
        Gson gson = new Gson();
        String status = "Accepted";
        JSONObject jsonObject = new JSONObject(jsonString);
        String jsonObj = jsonObject.getString("jsonData");
        JSONObject jsonData = new JSONObject(jsonObj);
        CustomerNotificationsPojo customerNotificationsPojo = new CustomerNotificationsPojo();
        customerNotificationsPojo.setObjectdata(jsonString);
        customerNotificationsPojo.setTotalcheckoutamt(jsonData.get("totalCheckOutamt").toString());
        customerNotificationsPojo.setTotaltax(jsonData.get("totalTaxAmt").toString());
        customerNotificationsPojo.setTypeDoc(jsonData.get("typeDoc").toString());
        customerNotificationsPojo.setTypeFlag(jsonData.get("type_flag").toString());
        customerNotificationsPojo.setStatus(status);
        customerNotificationsPojo.setPiNo(jsonData.get("piNo").toString());
        customerNotificationsPojo.setFromRegno(jsonData.get("from_reg").toString());
        customerNotificationsPojo.setToRegno(jsonData.get("to_reg").toString());
        customerNotificationsPojo.setState(jsonData.get("supplierState").toString());
        customerNotificationsPojo.setSubscriptionType(jsonData.get("subscriptionType").toString());
        customerNotificationsPojo.setCustNotiId(Long.valueOf(jsonData.get("custNotiId").toString()));
        customerObj = sassOrdersService.getSaasCustomerRegNoObj(customerNotificationsPojo.getFromRegno());
        customerNotificationsPojo.setFromCompname(customerObj.getCustomerName());
        customerObj = sassOrdersService.getSaasCustomerRegNoObj(customerNotificationsPojo.getToRegno());
        customerNotificationsPojo.setToCompname(customerObj.getCustomerName());
        if (customerNotificationsPojo.getTypeDoc() != null) {
            DestinationMap map = sassControlPanelService.getMapObject(customerNotificationsPojo.getTypeDoc());
//            customerNotificationsPojo.setDestinationmap(map.getDestinationmap());
        }
        if (customerNotificationsPojo.getSubscriptionType().equals("DesktopWithRTR")) {
            customerNotificationsPojo.setSubscriptionType("RTR");
        }
        if (customerNotificationsPojo.getSubscriptionType().equals("Hiconnect")) {
            customerNotificationsPojo.setSubscriptionType("Hiconnect");
        }
        sassCustomerNotificationsService.getPurchaseReceiveItemSave(customerNotificationsPojo);
        return new IDMResponse(HttpStatus.OK.value(), "success");

    }

    @RequestMapping(value = HiConnectConstants.HI_CONNECT_VERSION + HiConnectConstants.HI_CONNECT_BROADCAST_PCN_DATA, method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public IDMResponse BroadCastPostPurchaseCreditData(@RequestBody String jsonString) throws JSONException {
        SassCompany customerObj = null;
        String Status = "Accepted";
        JSONObject jsonData1 = new JSONObject(jsonString);
        Gson gson = new Gson();
        CustomerNotificationsPojo customerNotificationsPojo = new CustomerNotificationsPojo();
        String jsonObj = jsonData1.getString("jsonData");
        JSONObject jsonData = new JSONObject(jsonObj);
        customerNotificationsPojo.setObjectdata(jsonString);
        customerNotificationsPojo.setTotalcheckoutamt(jsonData.get("totalCheckOutamt").toString());
        customerNotificationsPojo.setTotaltax(jsonData.get("totalTaxAmt").toString());
        customerNotificationsPojo.setSubscriptionType(jsonData.get("subscriptionType").toString());
        customerNotificationsPojo.setTypeDoc(jsonData.get("type_doc").toString());
        customerNotificationsPojo.setTypeFlag(jsonData.get("type_flag").toString());
        customerNotificationsPojo.setPiNo(jsonData.get("piNo").toString());
        customerNotificationsPojo.setStatus(Status);
        customerNotificationsPojo.setFromRegno(jsonData.get("from_reg").toString());
        customerNotificationsPojo.setToRegno(jsonData.get("to_reg").toString());
//        customerNotificationsPojo.setState(jsonData.get("customerAddress").toString());
        customerNotificationsPojo.setCustNotiId(Long.valueOf(jsonData.get("custNotiId").toString()));
        customerObj = sassOrdersService.getSaasCustomerRegNoObj(customerNotificationsPojo.getFromRegno());
        customerNotificationsPojo.setFromCompname(customerObj.getCustomerName());
        customerObj = sassOrdersService.getSaasCustomerRegNoObj(customerNotificationsPojo.getToRegno());
        customerNotificationsPojo.setToCompname(customerObj.getCustomerName());
        if (customerNotificationsPojo.getTypeDoc() != null) {
            DestinationMap map = sassControlPanelService.getMapObject(customerNotificationsPojo.getTypeDoc());
//            customerNotificationsPojo.setDestinationmap(map.getDestinationmap());
        }
        if (customerNotificationsPojo.getSubscriptionType().equals("DesktopWithRTR")) {
            customerNotificationsPojo.setSubscriptionType("RTR");
        }
        if (customerNotificationsPojo.getSubscriptionType().equals("Hiconnect")) {
            customerNotificationsPojo.setSubscriptionType("Hiconnect");
        }
        sassCustomerNotificationsService.getPurchaseCreditNoteSave(customerNotificationsPojo);
        return new IDMResponse(HttpStatus.OK.value(), "success");

    }


    //DebitNote As Accepted
    @RequestMapping(value = HiConnectConstants.HI_CONNECT_VERSION + HiConnectConstants.HI_CONNECT_BROADCAST_PDNA_DATA, method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public IDMResponse BroadCastPostPurchaseDnDataAcc(@RequestBody String jsonString) throws JSONException {
        SassCompany customerObj = null;
        String Status = "Accepted";
        JSONObject jsonData1 = new JSONObject(jsonString);
        Gson gson = new Gson();
        CustomerNotificationsPojo customerNotificationsPojo = new CustomerNotificationsPojo();
        String jsonObj = jsonData1.getString("jsonData");
        JSONObject jsonData = new JSONObject(jsonObj);
        customerNotificationsPojo.setObjectdata(jsonString);
        customerNotificationsPojo.setTotalcheckoutamt(jsonData.get("totalCheckOutamt").toString());
        customerNotificationsPojo.setTotaltax(jsonData.get("totalTaxAmt").toString());
        customerNotificationsPojo.setSubscriptionType(jsonData.get("subscriptionType").toString());
        customerNotificationsPojo.setTypeDoc(jsonData.get("type_doc").toString());
        customerNotificationsPojo.setTypeFlag(jsonData.get("type_flag").toString());
        customerNotificationsPojo.setPiNo(jsonData.get("piNo").toString());
        customerNotificationsPojo.setStatus(Status);
        customerNotificationsPojo.setFromRegno(jsonData.get("from_reg").toString());
        customerNotificationsPojo.setToRegno(jsonData.get("to_reg").toString());
//        customerNotificationsPojo.setState(jsonData.get("customerAddress").toString());
        customerNotificationsPojo.setCustNotiId(Long.valueOf(jsonData.get("custNotiId").toString()));
        customerObj = sassOrdersService.getSaasCustomerRegNoObj(customerNotificationsPojo.getFromRegno());
        customerNotificationsPojo.setFromCompname(customerObj.getCustomerName());
        customerObj = sassOrdersService.getSaasCustomerRegNoObj(customerNotificationsPojo.getToRegno());
        customerNotificationsPojo.setToCompname(customerObj.getCustomerName());
        if (customerNotificationsPojo.getTypeDoc() != null) {
            DestinationMap map = sassControlPanelService.getMapObject(customerNotificationsPojo.getTypeDoc());
//            customerNotificationsPojo.setDestinationmap(map.getDestinationmap());
        }
        if (customerNotificationsPojo.getSubscriptionType().equals("DesktopWithRTR")) {
            customerNotificationsPojo.setSubscriptionType("RTR");
        }
        if (customerNotificationsPojo.getSubscriptionType().equals("Hiconnect")) {
            customerNotificationsPojo.setSubscriptionType("Hiconnect");
        }
        sassCustomerNotificationsService.getDebitNoteSave(customerNotificationsPojo);
        return new IDMResponse(HttpStatus.OK.value(), "success");

    }

    //CrediteNote As Pending
    @RequestMapping(value = HiConnectConstants.HI_CONNECT_VERSION + HiConnectConstants.HI_CONNECT_BROADCAST_PCDN_DATA, method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public IDMResponse BroadCastPostPurchaseCNData(@RequestBody String jsonString) throws JSONException {
        SassCompany customerObj = null;
        String Status = "pending";
        JSONObject jsonData1 = new JSONObject(jsonString);
        Gson gson = new Gson();
        CustomerNotificationsPojo customerNotificationsPojo = new CustomerNotificationsPojo();
        String jsonObj = jsonData1.getString("jsonData");
        JSONObject jsonData = new JSONObject(jsonObj);
        customerNotificationsPojo.setObjectdata(jsonString);
        customerNotificationsPojo.setTotalcheckoutamt(jsonData.get("incrementAmt").toString());
        customerNotificationsPojo.setTotaltax(jsonData.get("taxAmt").toString());
        customerNotificationsPojo.setSubscriptionType(jsonData.get("subscriptionType").toString());
        customerNotificationsPojo.setTypeDoc(jsonData.get("type_doc").toString());
        customerNotificationsPojo.setTypeFlag(jsonData.get("type_flag").toString());
        customerNotificationsPojo.setPiNo(jsonData.get("invoiceNo").toString());
        customerNotificationsPojo.setStatus(Status);
        customerNotificationsPojo.setFromRegno(jsonData.get("from_reg").toString());
        customerNotificationsPojo.setToRegno(jsonData.get("to_reg").toString());
        customerObj = sassOrdersService.getSaasCustomerRegNoObj(customerNotificationsPojo.getFromRegno());
        customerNotificationsPojo.setFromCompname(customerObj.getCustomerName());
        customerObj = sassOrdersService.getSaasCustomerRegNoObj(customerNotificationsPojo.getToRegno());
        customerNotificationsPojo.setToCompname(customerObj.getCustomerName());
        if (customerNotificationsPojo.getTypeDoc() != null) {
            DestinationMap map = sassControlPanelService.getMapObject(customerNotificationsPojo.getTypeDoc());
//            customerNotificationsPojo.setDestinationmap(map.getDestinationmap());
        }
        if (customerNotificationsPojo.getSubscriptionType().equals("DesktopWithRTR")) {
            customerNotificationsPojo.setSubscriptionType("RTR");
        }
        if (customerNotificationsPojo.getSubscriptionType().equals("Hiconnect")) {
            customerNotificationsPojo.setSubscriptionType("Hiconnect");
        }
        sassCustomerNotificationsService.getPurchaseCreditNoteSave(customerNotificationsPojo);
        return new IDMResponse(HttpStatus.OK.value(), "success");

    }

    //CrediteNote As Pending
    @RequestMapping(value = HiConnectConstants.HI_CONNECT_VERSION + HiConnectConstants.HI_CONNECT_BROADCAST_SCNP_DATA, method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public IDMResponse BroadCastPostSalesCreditNoteDataPending(@RequestBody String jsonString) throws JSONException {
        SassCompany customerObj = null;
        String Status = "pending";
        JSONObject jsonData1 = new JSONObject(jsonString);
        Gson gson = new Gson();
        CustomerNotificationsPojo customerNotificationsPojo = new CustomerNotificationsPojo();
        String jsonObj = jsonData1.getString("jsonData");
        JSONObject jsonData = new JSONObject(jsonObj);
        customerNotificationsPojo.setObjectdata(jsonString);
        customerNotificationsPojo.setTotalcheckoutamt(jsonData.get("amtIncTax").toString());
        customerNotificationsPojo.setTotaltax(jsonData.get("taxAmt").toString());
        customerNotificationsPojo.setSubscriptionType(jsonData.get("subscriptionType").toString());
        customerNotificationsPojo.setTypeDoc(jsonData.get("type_doc").toString());
        customerNotificationsPojo.setTypeFlag(jsonData.get("type_flag").toString());
        customerNotificationsPojo.setSiNo(jsonData.get("invoiceNo").toString());
        customerNotificationsPojo.setPiNo(jsonData.getString("referenceNo"));
        customerNotificationsPojo.setStatus(Status);
        customerNotificationsPojo.setFromRegno(jsonData.get("from_reg").toString());
        customerNotificationsPojo.setToRegno(jsonData.get("to_reg").toString());
        customerObj = sassOrdersService.getSaasCustomerRegNoObj(customerNotificationsPojo.getFromRegno());
        customerNotificationsPojo.setFromCompname(customerObj.getCustomerName());
        customerObj = sassOrdersService.getSaasCustomerRegNoObj(customerNotificationsPojo.getToRegno());
        customerNotificationsPojo.setToCompname(customerObj.getCustomerName());
        if (customerNotificationsPojo.getTypeDoc() != null) {
            DestinationMap map = sassControlPanelService.getMapObject(customerNotificationsPojo.getTypeDoc());
//            customerNotificationsPojo.setDestinationmap(map.getDestinationmap());
        }
        if (customerNotificationsPojo.getSubscriptionType().equals("DesktopWithRTR")) {
            customerNotificationsPojo.setSubscriptionType("RTR");
        }
        if (customerNotificationsPojo.getSubscriptionType().equals("Hiconnect")) {
            customerNotificationsPojo.setSubscriptionType("Hiconnect");
        }
        sassCustomerNotificationsService.getCreditNoteSave(customerNotificationsPojo);
        return new IDMResponse(HttpStatus.OK.value(), "success");

    }

//    @RequestMapping(value = HiConnectConstants.HI_CONNECT_VERSION + HiConnectConstants.HI_CONNECT_BROADCAST_PDNP_DATA, method = RequestMethod.POST,
//            produces = MediaType.APPLICATION_JSON_VALUE)
//    public IDMResponse BroadCastPostPurchaseDnDataPending(@RequestBody String jsonString) throws JSONException {
//        SassCompany customerObj = null;
//        String Status = "pending";
//        JSONObject jsonData1 = new JSONObject(jsonString);
//        Gson gson = new Gson();
//        CustomerNotificationsPojo customerNotificationsPojo = new CustomerNotificationsPojo();
//        String jsonObj = jsonData1.getString("jsonData");
//        JSONObject jsonData = new JSONObject(jsonObj);
//        customerNotificationsPojo.setObjectdata(jsonString);
//        customerNotificationsPojo.setTotalcheckoutamt(jsonData.get("incrementAmt").toString());
//        customerNotificationsPojo.setTotaltax(jsonData.get("amtIncTax").toString());
//        customerNotificationsPojo.setSubscriptionType(jsonData.get("subscriptionType").toString());
//        customerNotificationsPojo.setTypeDoc(jsonData.get("type_doc").toString());
//        customerNotificationsPojo.setTypeFlag(jsonData.get("type_flag").toString());
//        customerNotificationsPojo.setPiNo(jsonData.get("invoiceNo").toString());
//        customerNotificationsPojo.setStatus(Status);
//        customerNotificationsPojo.setFromRegno(jsonData.get("from_reg").toString());
//        customerNotificationsPojo.setToRegno(jsonData.get("to_reg").toString());
//        customerObj = sassOrdersService.getSaasCustomerRegNoObj(customerNotificationsPojo.getFromRegno());
//        customerNotificationsPojo.setFromCompname(customerObj.getCustomerName());
//        customerObj = sassOrdersService.getSaasCustomerRegNoObj(customerNotificationsPojo.getToRegno());
//        customerNotificationsPojo.setToCompname(customerObj.getCustomerName());
//        if(customerNotificationsPojo.getTypeDoc() != null) {
//            DestinationMap map = sassControlPanelService.getMapObject(customerNotificationsPojo.getTypeDoc());
////            customerNotificationsPojo.setDestinationmap(map.getDestinationmap());
//        }
//        if (customerNotificationsPojo.getSubscriptionType().equals("DesktopWithRTR")) {
//            customerNotificationsPojo.setSubscriptionType("RTR");
//        }
//        if (customerNotificationsPojo.getSubscriptionType().equals("Hiconnect")) {
//            customerNotificationsPojo.setSubscriptionType("Hiconnect");
//        }
//        sassCustomerNotificationsService.getPurchaseCreditNoteSave(customerNotificationsPojo);
//        return new IDMResponse(HttpStatus.OK.value(), "success");
//
//    }

    //CrediteNote As Pending
    @RequestMapping(value = HiConnectConstants.HI_CONNECT_VERSION + HiConnectConstants.HI_CONNECT_BROADCAST_PDNP_DATA, method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public IDMResponse BroadCastPostPurchaseDnDataPending(@RequestBody String jsonString) throws JSONException {
        SassCompany customerObj = null;
        String Status = "pending";
        JSONObject jsonData1 = new JSONObject(jsonString);
        Gson gson = new Gson();
        CustomerNotificationsPojo customerNotificationsPojo = new CustomerNotificationsPojo();
        String jsonObj = jsonData1.getString("jsonData");
        JSONObject jsonData = new JSONObject(jsonObj);
        customerNotificationsPojo.setObjectdata(jsonString);
        customerNotificationsPojo.setTotalcheckoutamt(jsonData.get("incrementAmt").toString());
        customerNotificationsPojo.setTotaltax(jsonData.get("amtIncTax").toString());
        customerNotificationsPojo.setSubscriptionType(jsonData.get("subscriptionType").toString());
        customerNotificationsPojo.setTypeDoc(jsonData.get("type_doc").toString());
        customerNotificationsPojo.setTypeFlag(jsonData.get("type_flag").toString());
        customerNotificationsPojo.setPiNo(jsonData.get("invoiceNo").toString());
        customerNotificationsPojo.setStatus(Status);
        customerNotificationsPojo.setFromRegno(jsonData.get("from_reg").toString());
        customerNotificationsPojo.setToRegno(jsonData.get("to_reg").toString());
        customerObj = sassOrdersService.getSaasCustomerRegNoObj(customerNotificationsPojo.getFromRegno());
        customerNotificationsPojo.setFromCompname(customerObj.getCustomerName());
        customerObj = sassOrdersService.getSaasCustomerRegNoObj(customerNotificationsPojo.getToRegno());
        customerNotificationsPojo.setToCompname(customerObj.getCustomerName());
        if (customerNotificationsPojo.getTypeDoc() != null) {
            DestinationMap map = sassControlPanelService.getMapObject(customerNotificationsPojo.getTypeDoc());
//            customerNotificationsPojo.setDestinationmap(map.getDestinationmap());
        }
        if (customerNotificationsPojo.getSubscriptionType().equals("DesktopWithRTR")) {
            customerNotificationsPojo.setSubscriptionType("RTR");
        }
        if (customerNotificationsPojo.getSubscriptionType().equals("Hiconnect")) {
            customerNotificationsPojo.setSubscriptionType("Hiconnect");
        }
        sassCustomerNotificationsService.getPurchaseCreditNoteSave(customerNotificationsPojo);
        return new IDMResponse(HttpStatus.OK.value(), "success");

    }

    //SupplierPayment
//    @RequestMapping(value = HiConnectConstants.HI_CONNECT_VERSION + HiConnectConstants.HI_CONNECT_BROADCAST_SP_DATA, method = RequestMethod.POST,
//            produces = MediaType.APPLICATION_JSON_VALUE)
//    public IDMResponse BroadCastPostSupplierPaymentData(@RequestBody String jsonString) throws JSONException {
//        JSONObject jsonObject = new JSONObject(jsonString);
//        Gson gson = new Gson();
//        String status = "pending";
//        CustomerNotifications customerNotifications = new CustomerNotifications();
//        customerNotifications.setObjectdata(jsonString);
//        customerNotifications.setStatus(status);
//        customerNotifications.setTypeFlag(jsonObject.get("type_flag").toString());
//        customerNotifications.setTypeDoc(jsonObject.get("type_doc").toString());
//        customerNotifications.setFromCompname(jsonObject.get("supplierName").toString());
//        saasTranscationsDataService.getSupplierPaymentSave(customerNotifications);
//        DestinationMap map = sassControlPanelService.getMapObject(customerNotifications.getTypeDoc());
//        customerNotifications.setDestinationmap(map.getDestinationmap());
//        return new IDMResponse(HttpStatus.OK.value(), "success");
//    }
    //tSupplierPayment
    @RequestMapping(value = HiConnectConstants.HI_CONNECT_VERSION + HiConnectConstants.HI_CONNECT_BROADCAST_SP_DATA, method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public IDMResponse BroadCastPostSupplierPaymentData(@RequestBody String jsonString) throws JSONException {
        SassCompany customerObj = null;
        JSONObject jsonObject = new JSONObject(jsonString);
        Gson gson = new Gson();
        String status = "pending";
        CustomerNotificationsPojo customerNotificationsPojo = new CustomerNotificationsPojo();
        String jsonObj = jsonObject.getString("jsonData");
        JSONObject jsonData = new JSONObject(jsonObj);
        customerNotificationsPojo.setObjectdata(jsonString);
        customerNotificationsPojo.setSubscriptionType(jsonData.get("subscriptionType").toString());
        customerNotificationsPojo.setTotalcheckoutamt(jsonData.get("totalCheckOutamt").toString());
        customerNotificationsPojo.setTotaltax(jsonData.get("totalTaxAmt").toString());
        customerNotificationsPojo.setFromRegno(jsonData.get("from_reg").toString());
        customerNotificationsPojo.setToRegno(jsonData.get("to_reg").toString());
        customerNotificationsPojo.setTypeDoc(jsonData.get("typeDoc").toString());
        customerNotificationsPojo.setTypeFlag(jsonData.get("type_flag").toString());
        customerNotificationsPojo.setFromCompname(jsonData.get("supplierName").toString());
        customerNotificationsPojo.setStatus(status);
        customerNotificationsPojo.setSiNo(jsonData.get("referenceNo").toString());
        customerNotificationsPojo.setPiNo(jsonData.get("piNo").toString());
        customerNotificationsPojo.setViewStatus("pending");
        customerObj = sassOrdersService.getSaasCustomerRegNoObj(customerNotificationsPojo.getFromRegno());
        customerNotificationsPojo.setFromCompname(customerObj.getCustomerName());
        customerObj = sassOrdersService.getSaasCustomerRegNoObj(customerNotificationsPojo.getToRegno());
        customerNotificationsPojo.setToCompname(customerObj.getCustomerName());
        if (customerNotificationsPojo.getTypeDoc() != null) {
            DestinationMap map = sassControlPanelService.getMapObject(customerNotificationsPojo.getTypeDoc());
//            customerNotificationsPojo.setDestinationmap(map.getDestinationmap());
        }
        if (customerNotificationsPojo.getSubscriptionType().equals("DesktopWithRTR")) {
            customerNotificationsPojo.setSubscriptionType("RTR");
        }
        if (customerNotificationsPojo.getSubscriptionType().equals("Hiconnect")) {
            customerNotificationsPojo.setSubscriptionType("Hiconnect");
        }
//
        sassCustomerNotificationsService.getSupplierPaymentSave(customerNotificationsPojo);
        return new IDMResponse(HttpStatus.OK.value(), "success");
    }

    //SalesReturn
    @RequestMapping(value = HiConnectConstants.HI_CONNECT_VERSION + HiConnectConstants.HI_CONNECT_FORM_DATA_SR, method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public IDMResponse BroadCastPostSalesReturnData(@RequestBody String jsonString) throws JSONException {
        SassCompany customerObj = null;
        JSONObject jsonObject = new JSONObject(jsonString);
        Gson gson = new Gson();
        String status = "pending";
        CustomerNotificationsPojo customerNotificationsPojo = new CustomerNotificationsPojo();
        String jsonObj = jsonObject.getString("jsonData");
        JSONObject jsonData = new JSONObject(jsonObj);
        customerNotificationsPojo.setObjectdata(jsonString);
        customerNotificationsPojo.setTotalcheckoutamt(jsonData.get("totalCheckOutamt").toString());
        customerNotificationsPojo.setTotaltax(jsonData.get("totalTaxAmt").toString());
        customerNotificationsPojo.setFromRegno(jsonData.get("from_reg").toString());
        customerNotificationsPojo.setToRegno(jsonData.get("to_reg").toString());
        customerNotificationsPojo.setTypeDoc(jsonData.get("typeDoc").toString());
        customerNotificationsPojo.setTypeFlag(jsonData.get("type_flag").toString());
        customerNotificationsPojo.setStatus(status);
        customerNotificationsPojo.setState(jsonData.get("customerState").toString());
        customerNotificationsPojo.setSiNo(jsonData.get("siNo").toString());
        customerNotificationsPojo.setViewStatus("pending");
        customerNotificationsPojo.setSubscriptionType(jsonData.get("subscriptionType").toString());
        customerObj = sassOrdersService.getSaasCustomerRegNoObj(customerNotificationsPojo.getFromRegno());
        customerNotificationsPojo.setFromCompname(customerObj.getCustomerName());
        customerObj = sassOrdersService.getSaasCustomerRegNoObj(customerNotificationsPojo.getToRegno());
        customerNotificationsPojo.setToCompname(customerObj.getCustomerName());
        if (customerNotificationsPojo.getTypeDoc() != null) {
            DestinationMap map = sassControlPanelService.getMapObject(customerNotificationsPojo.getTypeDoc());
//            customerNotificationsPojo.setDestinationmap(map.getDestinationmap());
        }

        if (customerNotificationsPojo.getSubscriptionType().equals("DesktopWithRTR")) {
            customerNotificationsPojo.setSubscriptionType("RTR");
        }
        if (customerNotificationsPojo.getSubscriptionType().equals("Hiconnect")) {
            customerNotificationsPojo.setSubscriptionType("Hiconnect");
        }
        sassCustomerNotificationsService.getSupplierPaymentSave(customerNotificationsPojo);
        return new IDMResponse(HttpStatus.OK.value(), "success");
    }

    //SalesInvoice
    @RequestMapping(value = HiConnectConstants.HI_CONNECT_VERSION + HiConnectConstants.HI_CONNECT_FORM_DATA_SI, method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public IDMResponse BroadCastPostSalesInvoiceData(@RequestBody String jsonString) throws JSONException {
        SassCompany customerObj = null;
        DestinationMap mapObj = null;
        JSONObject jsonData1 = new JSONObject(jsonString);
        Gson gson = new Gson();
        String status = "pending";
        CustomerNotificationsPojo customerNotificationsPojo = new CustomerNotificationsPojo();
        String jsonObj = jsonData1.getString("jsonData");
        JSONObject jsonData = new JSONObject(jsonObj);
        customerNotificationsPojo.setSubscriptionType(jsonData.get("subscriptionType").toString());
        customerNotificationsPojo.setObjectdata(jsonString);
        customerNotificationsPojo.setTotalcheckoutamt(jsonData.get("totalCheckOutamt").toString());
        customerNotificationsPojo.setTotaltax(jsonData.get("totalTaxAmt").toString());
        customerNotificationsPojo.setFromRegno(jsonData.get("from_reg").toString());
        customerNotificationsPojo.setToRegno(jsonData.get("to_reg").toString());
        customerNotificationsPojo.setTypeDoc(jsonData.get("typeDoc").toString());
        customerNotificationsPojo.setTypeFlag(jsonData.get("type_flag").toString());
        customerNotificationsPojo.setStatus(status);
        customerNotificationsPojo.setSiNo(jsonData.get("siNo").toString());
        customerNotificationsPojo.setViewStatus("pending");
        customerObj = sassOrdersService.getSaasCustomerRegNoObj(customerNotificationsPojo.getFromRegno());
        customerNotificationsPojo.setFromCompname(customerObj.getCustomerName());
        customerObj = sassOrdersService.getSaasCustomerRegNoObj(customerNotificationsPojo.getToRegno());
        customerNotificationsPojo.setToCompname(customerObj.getCustomerName());
        if (customerNotificationsPojo.getTypeDoc() != null) {
            DestinationMap map = sassControlPanelService.getMapObject(customerNotificationsPojo.getTypeDoc());
//            customerNotificationsPojo.setDestinationmap(map.getDestinationmap());
        }
        if (customerNotificationsPojo.getSubscriptionType().equals("DesktopWithRTR")) {
            customerNotificationsPojo.setSubscriptionType("RTR");
        }
        if (customerNotificationsPojo.getSubscriptionType().equals("Hiconnect")) {
            customerNotificationsPojo.setSubscriptionType("Hiconnect");
        }

        sassCustomerNotificationsService.getSalesInvoiceSave(customerNotificationsPojo);
        return new IDMResponse(HttpStatus.OK.value(), "success");
    }

    @RequestMapping(value = HiConnectConstants.HI_CONNECT_VERSION + HiConnectConstants.HI_CONNECT_CARTREG_LIST, method = RequestMethod.POST)
    public IDMResponse searchAddedCartNames() throws JSONException {
        List<CartRegistrationPojo> cartregistrations = sassControlPanelService.cartRegistrationPojoList();
        Gson gson = new Gson();
        String jsonCartList = gson.toJson(cartregistrations);
        return new IDMResponse(HttpStatus.OK.value(), "success", jsonCartList);
    }

    @RequestMapping(value = HiConnectConstants.HI_CONNECT_VERSION + HiConnectConstants.HI_CONNECT_CART_LIST, method = RequestMethod.POST)
    public IDMResponse searchAddedCartCustomer(){
        List<CartCustomerLinkPojo> cartCustomerLinkPojo = sassControlPanelService.cartCustomerLinkPojo();
        Gson gson = new Gson();
        String jsonCartList = gson.toJson(cartCustomerLinkPojo);
    return new IDMResponse(HttpStatus.OK.value(),"success",jsonCartList);
    }

    @RequestMapping(value = HiConnectConstants.HI_CONNECT_VERSION + HiConnectConstants.HI_CONNECT_BROADCAST_DO_DATA, method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public IDMResponse BroadCastPostSalesDeliveryOrderData(@RequestBody String jsonString) throws JSONException {
        SassCompany customerObj = null;
        JSONObject jsonObject = new JSONObject(jsonString);
        Gson gson = new Gson();
        String status = "pending";

        CustomerNotificationsPojo customerNotificationsPojo = new CustomerNotificationsPojo();
        String jsonObj = jsonObject.getString("jsonData");
        JSONObject jsonData = new JSONObject(jsonObj);
        customerNotificationsPojo.setObjectdata(jsonString);
        customerNotificationsPojo.setTotalcheckoutamt(jsonData.get("totalCheckOutamt").toString());
        customerNotificationsPojo.setTotaltax(jsonData.get("totalTaxAmt").toString());
        customerNotificationsPojo.setFromRegno(jsonData.get("from_reg").toString());
        customerNotificationsPojo.setToRegno(jsonData.get("to_reg").toString());
        customerNotificationsPojo.setTypeDoc(jsonData.get("typeDoc").toString());
        customerNotificationsPojo.setTypeFlag(jsonData.get("type_flag").toString());
        customerNotificationsPojo.setStatus(status);
        customerNotificationsPojo.setSiNo(jsonData.get("siNo").toString());
        customerNotificationsPojo.setViewStatus("pending");
        customerNotificationsPojo.setSubscriptionType(jsonData.get("subscriptionType").toString());
        customerObj = sassOrdersService.getSaasCustomerRegNoObj(customerNotificationsPojo.getFromRegno());
        customerNotificationsPojo.setFromCompname(customerObj.getCustomerName());
        customerObj = sassOrdersService.getSaasCustomerRegNoObj(customerNotificationsPojo.getToRegno());
        customerNotificationsPojo.setToCompname(customerObj.getCustomerName());
        if (customerNotificationsPojo.getTypeDoc() != null) {
            DestinationMap map = sassControlPanelService.getMapObject(customerNotificationsPojo.getTypeDoc());
//            customerNotificationsPojo.setDestinationmap(map.getDestinationmap());
        }
        if (customerNotificationsPojo.getSubscriptionType().equals("DesktopWithRTR")) {
            customerNotificationsPojo.setSubscriptionType("RTR");
        }
        if (customerNotificationsPojo.getSubscriptionType().equals("Hiconnect")) {
            customerNotificationsPojo.setSubscriptionType("Hiconnect");
        }
//        TransactionsDataPojo transactionsDataPojo = new TransactionsDataPojo();
//        transactionsDataPojo.setObjectdata(jsonObject.get("selectedItemsList").toString());
//        transactionsDataPojo.setStatus(jsonObject.get("status").toString());
//        transactionsDataPojo.setStatus(status);
//        transactionsDataPojo.setTotalcheckoutamt(jsonObject.get("totalCheckOutamt").toString());
//        transactionsDataPojo.setTotaltax(jsonObject.get("totalTaxAmt").toString());
//        transactionsDataPojo.setTypeDoc(jsonObject.get("type_doc").toString());
//        transactionsDataPojo.setTypeFlag(jsonObject.get("type_flag").toString());
//        transactionsDataPojo.setFromCompname(jsonObject.get("cutomerName").toString());
        sassCustomerNotificationsService.getSalesDOSave(customerNotificationsPojo);
        return new IDMResponse(HttpStatus.OK.value(), "success");
    }

    @RequestMapping(value = HiConnectConstants.HI_CONNECT_VERSION + HiConnectConstants.HI_CONNECT_BROADCAST_RRI_DATA, method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public IDMResponse BroadCastPostRRIData(@RequestBody String jsonString) throws JSONException {
        SassCompany customerObj = null;
        JSONObject jsonObject = new JSONObject(jsonString);
        Gson gson = new Gson();
        String status = "pending";
        CustomerNotificationsPojo customerNotificationsPojo = new CustomerNotificationsPojo();
        String jsonObj = jsonObject.getString("jsonData");
        JSONObject jsonData = new JSONObject(jsonObj);
        customerNotificationsPojo.setObjectdata(jsonString);
        customerNotificationsPojo.setTotalcheckoutamt(jsonData.get("totalCheckOutamt").toString());
        customerNotificationsPojo.setTotaltax(jsonData.get("totalTaxAmt").toString());
        customerNotificationsPojo.setFromRegno(jsonData.get("from_reg").toString());
        customerNotificationsPojo.setToRegno(jsonData.get("to_reg").toString());
        customerNotificationsPojo.setTypeDoc(jsonData.get("typeDoc").toString());
        customerNotificationsPojo.setTypeFlag(jsonData.get("type_flag").toString());
        customerNotificationsPojo.setStatus(status);
        customerNotificationsPojo.setPiNo(jsonData.get("piNo").toString());
        customerNotificationsPojo.setViewStatus("pending");
        customerNotificationsPojo.setSubscriptionType(jsonData.get("subscriptionType").toString());
        customerObj = sassOrdersService.getSaasCustomerRegNoObj(customerNotificationsPojo.getFromRegno());
        customerNotificationsPojo.setFromCompname(customerObj.getCustomerName());
        if (customerNotificationsPojo.getTypeDoc() != null) {
            DestinationMap map = sassControlPanelService.getMapObject(customerNotificationsPojo.getTypeDoc());
//            customerNotificationsPojo.setDestinationmap(map.getDestinationmap());
        }
        if (customerNotificationsPojo.getSubscriptionType().equals("DesktopWithRTR")) {
            customerNotificationsPojo.setSubscriptionType("RTR");
        }
        sassCustomerNotificationsService.getPurchaseRRI(customerNotificationsPojo);
        return new IDMResponse(HttpStatus.OK.value(), "success");
    }

    //SalesDebitNote
    @RequestMapping(value = HiConnectConstants.HI_CONNECT_VERSION + HiConnectConstants.HI_CONNECT_BROADCAST_SDN_DATA, method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public IDMResponse BroadCastPostSalesDnData(@RequestBody String jsonString) throws JSONException {
        SassCompany customerObj = null;
        JSONObject jsonObject = new JSONObject(jsonString);
        Gson gson = new Gson();
        String status = "pending";
        String jsonObj = jsonObject.getString("jsonData");
        JSONObject jsonData = new JSONObject(jsonObj);
        CustomerNotificationsPojo customerNotificationsPojo = new CustomerNotificationsPojo();
        customerNotificationsPojo.setObjectdata(jsonString);
        customerNotificationsPojo.setTotalcheckoutamt(jsonData.get("amtIncTax").toString());
        customerNotificationsPojo.setSubscriptionType(jsonData.get("subscriptionType").toString());
        customerNotificationsPojo.setTotaltax(jsonData.get("taxAmt").toString());
        customerNotificationsPojo.setFromRegno(jsonData.get("from_reg").toString());
        customerNotificationsPojo.setToRegno(jsonData.get("to_reg").toString());
        customerNotificationsPojo.setTypeDoc(jsonData.get("type_doc").toString());
        customerNotificationsPojo.setTypeFlag(jsonData.get("type_flag").toString());
        customerNotificationsPojo.setStatus(status);
        customerNotificationsPojo.setViewStatus("pending");
        customerNotificationsPojo.setSiNo(jsonData.get("invoiceNo").toString());
        customerObj = sassOrdersService.getSaasCustomerRegNoObj(customerNotificationsPojo.getFromRegno());
        customerNotificationsPojo.setFromCompname(customerObj.getCustomerName());
        customerObj = sassOrdersService.getSaasCustomerRegNoObj(customerNotificationsPojo.getToRegno());
        customerNotificationsPojo.setToCompname(customerObj.getCustomerName());
        if (customerNotificationsPojo.getTypeDoc() != null) {
            DestinationMap map = sassControlPanelService.getMapObject(customerNotificationsPojo.getTypeDoc());
//            customerNotificationsPojo.setDestinationmap(map.getDestinationmap());
        }
        if (customerNotificationsPojo.getSubscriptionType().equals("DesktopWithRTR")) {
            customerNotificationsPojo.setSubscriptionType("RTR");
        }
        if (customerNotificationsPojo.getSubscriptionType().equals("Hiconnect")) {
            customerNotificationsPojo.setSubscriptionType("Hiconnect");
        }
        sassCustomerNotificationsService.getSalesDNSave(customerNotificationsPojo);
        return new IDMResponse(HttpStatus.OK.value(), "success");
    }

//    @RequestMapping(value = HiConnectConstants.HI_CONNECT_VERSION  + HiConnectConstants.HI_CONNECT_FORM_DATA,method = RequestMethod.POST,
//            produces = MediaType.APPLICATION_JSON_VALUE)
//    public IDMResponse BroadCastPostSalesReturnData(@RequestBody String jsonString) throws JSONException {
//        JSONObject jsonObject = new JSONObject(jsonString);
//        Gson gson = new Gson();
//        String status = "pending";
//        TransactionsDataPojo transactionsDataPojo = new TransactionsDataPojo();
//        transactionsDataPojo.setObjectdata(jsonObject.get("selectedItemsList").toString());
//        transactionsDataPojo.setStatus(jsonObject.get("status").toString());
//        transactionsDataPojo.setStatus(status);
//        transactionsDataPojo.setTotalcheckoutamt(jsonObject.get("totalCheckOutamt").toString());
//        transactionsDataPojo.setTotaltax(jsonObject.get("totalTaxAmt").toString());
//        transactionsDataPojo.setTypeDoc(jsonObject.get("type_doc").toString());
//        transactionsDataPojo.setTypeFlag(jsonObject.get("type_flag").toString());
//        saasTranscationsDataService.getSalesInvoiceSave(transactionsDataPojo);
//        return new IDMResponse(HttpStatus.OK.value(), "success");
//    }


    // SalesQuotation
    @RequestMapping(value = HiConnectConstants.HI_CONNECT_VERSION + HiConnectConstants.HI_CONNECT_BROADCAST_SQ_DATA, method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public IDMResponse BroadCastPostSalesQuotationData(@RequestBody String jsonString) throws JSONException {
        SassCompany customerObj = null;
        JSONObject jsonObject = new JSONObject(jsonString);
        Gson gson = new Gson();
        String status = "pending";
        CustomerNotificationsPojo customerNotificationsPojo = new CustomerNotificationsPojo();
        String jsonObj = jsonObject.getString("jsonData");
        JSONObject jsonData = new JSONObject(jsonObj);
        customerNotificationsPojo.setSubscriptionType(jsonData.get("subscriptionType").toString());
        customerNotificationsPojo.setObjectdata(jsonString);
//        customerNotificationsPojo.setCustNotiId(jsonData.getLong("custNotiId"));
        customerNotificationsPojo.setTotalcheckoutamt(jsonData.get("totalCheckOutamt").toString());
        customerNotificationsPojo.setTotaltax(jsonData.get("totalTaxAmt").toString());
        customerNotificationsPojo.setFromRegno(jsonData.get("from_reg").toString());
        customerNotificationsPojo.setToRegno(jsonData.get("to_reg").toString());
        customerNotificationsPojo.setTypeDoc(jsonData.get("typeDoc").toString());
        customerNotificationsPojo.setTypeFlag(jsonData.get("type_flag").toString());
        customerNotificationsPojo.setStatus(status);
        customerNotificationsPojo.setState(jsonData.get("customerState").toString());
        customerNotificationsPojo.setSiNo(jsonData.get("siNo").toString());
        customerNotificationsPojo.setViewStatus("pending");
        customerObj = sassOrdersService.getSaasCustomerRegNoObj(customerNotificationsPojo.getFromRegno());
        customerNotificationsPojo.setFromCompname(customerObj.getCustomerName());
        customerObj = sassOrdersService.getSaasCustomerRegNoObj(customerNotificationsPojo.getToRegno());
        customerNotificationsPojo.setToCompname(customerObj.getCustomerName());
        if (customerNotificationsPojo.getTypeDoc() != null) {
            DestinationMap map = sassControlPanelService.getMapObject(customerNotificationsPojo.getTypeDoc());
//            customerNotificationsPojo.setDestinationmap(map.getDestinationmap());
        }
        if (customerNotificationsPojo.getSubscriptionType().equals("DesktopWithRTR")) {
            customerNotificationsPojo.setSubscriptionType("RTR");
        }
        if (customerNotificationsPojo.getSubscriptionType().equals("Hiconnect")) {
            customerNotificationsPojo.setSubscriptionType("Hiconnect");
        }
        sassCustomerNotificationsService.getSalesQuotationSave(customerNotificationsPojo);
        return new IDMResponse(HttpStatus.OK.value(), "success");
    }


    //purchase Quotation --> after accepting notification data appending and saving the data
    //PurchaseQuotation
    @RequestMapping(value = HiConnectConstants.HI_CONNECT_VERSION + HiConnectConstants.HI_CONNECT_BROADCAST_PQ_DATA, method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public IDMResponse BroadCastPostPurchaseQuotationData(@RequestBody String jsonString) throws JSONException {
        SassCompany customerObj = null;
        JSONObject jsonObject = new JSONObject(jsonString);
        Gson gson = new Gson();
        String status = "Accepted";
        CustomerNotificationsPojo customerNotificationsPojo = new CustomerNotificationsPojo();
        String jsonObj = jsonObject.getString("jsonData");
        JSONObject jsonData = new JSONObject(jsonObj);
        customerNotificationsPojo.setObjectdata(jsonData.get("selectedItemsList").toString());
        customerNotificationsPojo.setSubscriptionType(jsonData.get("subscriptionType").toString());
        customerNotificationsPojo.setObjectdata(jsonString);
        customerNotificationsPojo.setTotalcheckoutamt(jsonData.get("totalCheckOutamt").toString());
        customerNotificationsPojo.setTotaltax(jsonData.get("totalTaxAmt").toString());
        customerNotificationsPojo.setTypeDoc(jsonData.get("typeDoc").toString());
        customerNotificationsPojo.setTypeFlag(jsonData.get("type_flag").toString());
        customerNotificationsPojo.setStatus(jsonData.get("status").toString());
        customerNotificationsPojo.setPiNo(jsonData.get("piNo").toString());
        customerNotificationsPojo.setFromRegno(jsonData.get("from_reg").toString());
        customerNotificationsPojo.setToRegno(jsonData.get("to_reg").toString());
        customerNotificationsPojo.setState(jsonData.get("supplierState").toString());
        customerNotificationsPojo.setStatus(status);
        customerNotificationsPojo.setViewStatus("pending");
        customerNotificationsPojo.setCustNotiId(Long.valueOf(jsonData.get("custNotiId").toString()));
        customerObj = sassOrdersService.getSaasCustomerRegNoObj(customerNotificationsPojo.getFromRegno());
        customerNotificationsPojo.setFromCompname(customerObj.getCustomerName());
        customerObj = sassOrdersService.getSaasCustomerRegNoObj(customerNotificationsPojo.getToRegno());
        customerNotificationsPojo.setToCompname(customerObj.getCustomerName());
        if (customerNotificationsPojo.getTypeDoc() != null) {
            DestinationMap map = sassControlPanelService.getMapObject(customerNotificationsPojo.getTypeDoc());
//            customerNotificationsPojo.setDestinationmap(map.getDestinationmap());
        }
//        String custNotiId = String.valueOf(jsonObject.get("custNotiId"));
//        customerNotifications.setToRegno(jsonObject.get("to_reg").toString());
//        Long transactionId = Long.valueOf(jsonObject.get("transactionId").toString());
//        Long notificationId = Long.valueOf(jsonObject.get("notificationId").toString());
//        TransactionsData transactionsData = sassOrdersService.getTransactionObject(transactionId);
//        transactionsData.setStatus(status);
//        transactionsData.setTypeDoc(jsonObject.get("typeDoc").toString());
//        transactionsData.setTypeFlag(jsonObject.get("typeFlag").toString());
//        transactionsData.setTransactionId(Long.valueOf(jsonObject.get("transactionId").toString()));
        if (customerNotificationsPojo.getSubscriptionType().equals("DesktopWithRTR")) {
            customerNotificationsPojo.setSubscriptionType("RTR");
        }
        if (customerNotificationsPojo.getSubscriptionType().equals("Hiconnect")) {
            customerNotificationsPojo.setSubscriptionType("Hiconnect");
        }
        sassCustomerNotificationsService.getPurchaseQuotationSave(customerNotificationsPojo);
        return new IDMResponse(HttpStatus.OK.value(), "success");
    }

    //--> after accepting notification data appending and saving the data
    //PurchaseInvoice
    @RequestMapping(value = HiConnectConstants.HI_CONNECT_VERSION + HiConnectConstants.HI_CONNECT_BROADCAST_PI_DATA, method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public IDMResponse BroadCastPostPurchaseInvoiceData(@RequestBody String jsonString) throws JSONException {
        SassCompany customerObj = null;
//        Gson gson = new Gson();
        String status = "Accepted";
        JSONObject jsonData1 = new JSONObject(jsonString);
        CustomerNotificationsPojo customerNotificationsPojo = new CustomerNotificationsPojo();
        String jsonObj = jsonData1.getString("jsonData");
        JSONObject jsonData = new JSONObject(jsonObj);
        customerNotificationsPojo.setSubscriptionType(jsonData.get("subscriptionType").toString());
        customerNotificationsPojo.setObjectdata(jsonString);
        customerNotificationsPojo.setCustNotiId(jsonData.getLong("custNotiId"));
        customerNotificationsPojo.setTotalcheckoutamt(jsonData.get("totalCheckOutamt").toString());
        customerNotificationsPojo.setTotaltax(jsonData.get("totalTaxAmt").toString());
        customerNotificationsPojo.setViewStatus("pending");
        customerNotificationsPojo.setStatus(status);
//        if (!jsonData.get("transactionId").toString().equals("null")) {
//            customerNotificationsPojo.setTransactionId(Long.valueOf(jsonData.get("transactionId").toString()));
//        }
        customerNotificationsPojo.setTypeDoc(jsonData.get("typeDoc").toString());
        customerNotificationsPojo.setTypeFlag(jsonData.get("typeFlag").toString());
//        customerNotificationsPojo.setStatus(jsonData.get("getpiStatus").toString());
        if (!jsonData.get("from_reg").toString().equals("null")) {
            customerNotificationsPojo.setFromRegno(jsonData.get("from_reg").toString());
        }
        if (!jsonData.get("to_reg").toString().equals("null")) {
            customerNotificationsPojo.setToRegno(jsonData.get("to_reg").toString());
        }
//        customerNotificationsPojo.setPiNo(jsonData.get("piNo").toString());
//        customerNotificationsPojo.setState(JsonObject.get("supplierState").toString());
//        customerNotificationsPojo.setFromCompname(jsonData.get("fromCompname").toString());
//        if (!jsonData.get("custNotiId").toString().equals("null")) {
//            customerNotificationsPojo.setCustNotiId(Long.valueOf(jsonData.get("custNotiId").toString()));
//        }

        customerObj = sassOrdersService.getSaasCustomerRegNoObj(customerNotificationsPojo.getFromRegno());
        if (customerObj != null)
            customerNotificationsPojo.setFromCompname(customerObj.getCustomerName());
//        customerNotificationsPojo.setSubscriptionType("HiConnect");
//        sassCustomerNotificationsService.getPurchaseInvoiceSave(customerNotificationsPojo);

        if (customerNotificationsPojo.getSubscriptionType().equals("DesktopWithRTR")) {
//            if (!jsonObject.get("from_reg").toString().equals("null")) {
//                customerNotificationsPojo.setToRegno(jsonObject.get("from_reg").toString());
//            }
//            customerNotificationsPojo.setToCompname(jsonData.get("supplierName").toString());
            customerNotificationsPojo.setSubscriptionType("RTR");
        }
        if (customerNotificationsPojo.getSubscriptionType().equals("Hiconnect")) {
            customerNotificationsPojo.setSubscriptionType("Hiconnect");
        }
        sassCustomerNotificationsService.getPurchaseInvoiceSave(customerNotificationsPojo);
        return new IDMResponse(HttpStatus.OK.value(), "success");
    }

    //    --> after accepting notification data appending and saving the data
    //CustomerPayment
    @RequestMapping(value = HiConnectConstants.HI_CONNECT_VERSION + HiConnectConstants.HI_CONNECT_BROADCAST_CP_DATA, method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public IDMResponse BroadCastPostCustomerPaymentData(@RequestBody String jsonString) throws JSONException {
        SassCompany customerObj = null;
        JSONObject jsonObject = new JSONObject(jsonString);
        String jsonObj = jsonObject.getString("jsonData");
        Gson gson = new Gson();
        String status = "Accepted";
        JSONObject jsonData = new JSONObject(jsonObj);
        CustomerNotificationsPojo customerNotificationsPojo = new CustomerNotificationsPojo();
        customerNotificationsPojo.setObjectdata(jsonString);
        customerNotificationsPojo.setSubscriptionType(jsonData.get("subscriptionType").toString());
        customerNotificationsPojo.setTotalcheckoutamt(jsonData.get("totalCheckOutamt").toString());
        customerNotificationsPojo.setTotaltax(jsonData.get("totalTaxAmt").toString());
        customerNotificationsPojo.setTypeDoc(jsonData.get("typeDoc").toString());
        customerNotificationsPojo.setTypeFlag(jsonData.get("type_flag").toString());
        customerNotificationsPojo.setStatus(jsonData.get("transcationStatus").toString());
        customerNotificationsPojo.setSiNo(jsonData.get("formNo").toString());
        customerNotificationsPojo.setFromRegno(jsonData.get("from_reg").toString());
        customerNotificationsPojo.setViewStatus("pending");
        customerNotificationsPojo.setStatus(status);
        customerNotificationsPojo.setCustNotiId(Long.valueOf(jsonData.get("custNotiId").toString()));
        customerNotificationsPojo.setToRegno(jsonData.get("to_reg").toString());
        customerObj = sassOrdersService.getSaasCustomerRegNoObj(customerNotificationsPojo.getFromRegno());
        customerNotificationsPojo.setFromCompname(customerObj.getCustomerName());
        customerObj = sassOrdersService.getSaasCustomerRegNoObj(customerNotificationsPojo.getToRegno());
        customerNotificationsPojo.setFromCompname(customerObj.getCustomerName());
        if (customerNotificationsPojo.getTypeDoc() != null) {
            DestinationMap map = sassControlPanelService.getMapObject(customerNotificationsPojo.getTypeDoc());
            //customerNotificationsPojo.setDestinationmap(map.getDestinationmap());
        }
        if (customerNotificationsPojo.getSubscriptionType().equals("DesktopWithRTR")) {
            customerNotificationsPojo.setSubscriptionType("RTR");
        }
        if (customerNotificationsPojo.getSubscriptionType().equals("Hiconnect")) {
            customerNotificationsPojo.setSubscriptionType("Hiconnect");
        }
        sassCustomerNotificationsService.getCustomerPaymentSave(customerNotificationsPojo);
        return new IDMResponse(HttpStatus.OK.value(), "success");
    }

    //CreditNote
    @RequestMapping(value = HiConnectConstants.HI_CONNECT_VERSION + HiConnectConstants.HI_CONNECT_BROADCAST_SCDNA_DATA, method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public IDMResponse BroadCastPostSalesCreditNoteData(@RequestBody String jsonString) throws JSONException {
        SassCompany customerObj = null;
        JSONObject jsonObject = new JSONObject(jsonString);
        String status = "Accepted";
        CustomerNotificationsPojo customerNotificationsPojo = new CustomerNotificationsPojo();
        String jsonObj = jsonObject.getString("jsonData");
        JSONObject jsonData = new JSONObject(jsonObj);
        Gson gson = new Gson();
        customerNotificationsPojo.setObjectdata(jsonString);
        customerNotificationsPojo.setTotalcheckoutamt(jsonData.get("totalCheckOutamt").toString());
        customerNotificationsPojo.setTotaltax(jsonData.get("totalTaxAmt").toString());
        customerNotificationsPojo.setTypeDoc(jsonData.get("type_doc").toString());
        customerNotificationsPojo.setTypeFlag(jsonData.get("type_flag").toString());
        customerNotificationsPojo.setSubscriptionType(jsonData.get("subscriptionType").toString());
        customerNotificationsPojo.setStatus(status);
        customerNotificationsPojo.setSiNo(jsonData.get("siNo").toString());
        customerNotificationsPojo.setFromRegno(jsonData.get("from_reg").toString());
        customerNotificationsPojo.setToRegno(jsonData.get("to_reg").toString());
        customerNotificationsPojo.setCustNotiId(Long.valueOf(jsonData.get("custNotiId").toString()));
        customerObj = sassOrdersService.getSaasCustomerRegNoObj(customerNotificationsPojo.getFromRegno());
        customerNotificationsPojo.setFromCompname(customerObj.getCustomerName());
        customerObj = sassOrdersService.getSaasCustomerRegNoObj(customerNotificationsPojo.getToRegno());
        customerNotificationsPojo.setToCompname(customerObj.getCustomerName());
        if (customerNotificationsPojo.getTypeDoc() != null) {
            DestinationMap map = sassControlPanelService.getMapObject(customerNotificationsPojo.getTypeDoc());
//            customerNotificationsPojo.setDestinationmap(map.getDestinationmap());
        }
        if (customerNotificationsPojo.getSubscriptionType().equals("DesktopWithRTR")) {
            customerNotificationsPojo.setSubscriptionType("RTR");
        }
        if (customerNotificationsPojo.getSubscriptionType().equals("Hiconnect")) {
            customerNotificationsPojo.setSubscriptionType("Hiconnect");
        }
        sassCustomerNotificationsService.getCreditNoteSave(customerNotificationsPojo);
        return new IDMResponse(HttpStatus.OK.value(), "success");
    }

    @RequestMapping(value = HiConnectConstants.HI_CONNECT_VERSION + HiConnectConstants.HI_CONNECT_BROADCAST_SDR_DATA, method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public IDMResponse BroadCastPostSalesDeliveryReturnData(@RequestBody String jsonString) throws JSONException {
        SassCompany customerObj = null;
        String status = "Accepted";
        JSONObject jsonObject = new JSONObject(jsonString);
        String jsonObj = jsonObject.getString("jsonData");
        JSONObject jsonData = new JSONObject(jsonObj);
        CustomerNotificationsPojo customerNotificationsPojo = new CustomerNotificationsPojo();
        customerNotificationsPojo.setObjectdata(jsonData.get("selectedItemsdata").toString());
        customerNotificationsPojo.setTotalcheckoutamt(jsonData.get("totalCheckOutamt").toString());
        customerNotificationsPojo.setTotaltax(jsonData.get("totalTaxAmt").toString());
        customerNotificationsPojo.setTypeDoc(jsonData.get("typeDoc").toString());
        customerNotificationsPojo.setTypeFlag(jsonData.get("typeFlag").toString());
        customerNotificationsPojo.setSubscriptionType(jsonData.get("subscriptionType").toString());
        customerNotificationsPojo.setStatus(status);
        customerNotificationsPojo.setSiNo(jsonData.get("siNo").toString());
        customerNotificationsPojo.setFromRegno(jsonData.get("from_reg").toString());
        customerNotificationsPojo.setToRegno(jsonData.get("to_reg").toString());
        customerNotificationsPojo.setState(jsonData.get("supplierState").toString());
        customerNotificationsPojo.setCustNotiId(Long.valueOf(jsonData.get("custNotiId").toString()));
        customerObj = sassOrdersService.getSaasCustomerRegNoObj(customerNotificationsPojo.getFromRegno());
        customerNotificationsPojo.setFromCompname(customerObj.getCustomerName());
        customerObj = sassOrdersService.getSaasCustomerRegNoObj(customerNotificationsPojo.getToRegno());
        customerNotificationsPojo.setToCompname(customerObj.getCustomerName());
        if (customerNotificationsPojo.getTypeDoc() != null) {
            DestinationMap map = sassControlPanelService.getMapObject(customerNotificationsPojo.getTypeDoc());
//            customerNotificationsPojo.setDestinationmap(map.getDestinationmap());
        }
        if (customerNotificationsPojo.getSubscriptionType().equals("DesktopWithRTR")) {
            customerNotificationsPojo.setSubscriptionType("RTR");
        }
        if (customerNotificationsPojo.getSubscriptionType().equals("Hiconnect")) {
            customerNotificationsPojo.setSubscriptionType("Hiconnect");
        }
        sassCustomerNotificationsService.getSalesDeliveryReturnSave(customerNotificationsPojo);
        return new IDMResponse(HttpStatus.OK.value(), "success");
    }

//    --> after accepting notification data appending and saving the data

    @RequestMapping(value = HiConnectConstants.HI_CONNECT_VERSION + HiConnectConstants.HI_CONNECT_BROADCAST_SO_DATA, method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public IDMResponse BroadCastPostSalesOrderData(@RequestBody String jsonString) throws JSONException {
        SassCompany customerObj = null;
        Gson gson = new Gson();
        JSONObject jsonObject = new JSONObject(jsonString);
        String jsonObj = jsonObject.getString("jsonData");
        JSONObject jsonData = new JSONObject(jsonObj);
        String status = "Accepted";
//        Long transaction_id = Long.valueOf(jsonObject.get("transactionId").toString());
        CustomerNotificationsPojo customerNotificationsPojo = new CustomerNotificationsPojo();
        customerNotificationsPojo.setObjectdata(jsonString);
        customerNotificationsPojo.setTotalcheckoutamt(jsonData.get("totalCheckOutamt").toString());
        customerNotificationsPojo.setTotaltax(jsonData.get("totalTaxAmt").toString());
        customerNotificationsPojo.setTypeDoc(jsonData.get("typeDoc").toString());
        customerNotificationsPojo.setTypeFlag(jsonData.get("typeFlag").toString());
        customerNotificationsPojo.setStatus(jsonData.get("status").toString());
        customerNotificationsPojo.setSiNo(jsonData.get("siNo").toString());
        customerNotificationsPojo.setStatus(status);
        customerNotificationsPojo.setFromRegno(jsonData.get("from_reg").toString());
        customerNotificationsPojo.setToRegno(jsonData.get("to_reg").toString());
        customerNotificationsPojo.setState(jsonData.get("customerAddress").toString());
        customerNotificationsPojo.setCustNotiId(Long.valueOf(jsonData.get("custNotiId").toString()));
        customerNotificationsPojo.setSubscriptionType(jsonData.get("subscriptionType").toString());
        customerObj = sassOrdersService.getSaasCustomerRegNoObj(customerNotificationsPojo.getFromRegno());
        customerNotificationsPojo.setFromCompname(customerObj.getCustomerName());
        customerObj = sassOrdersService.getSaasCustomerRegNoObj(customerNotificationsPojo.getToRegno());
        customerNotificationsPojo.setToCompname(customerObj.getCustomerName());
        if (customerNotificationsPojo.getTypeDoc() != null) {
            DestinationMap map = sassControlPanelService.getMapObject(customerNotificationsPojo.getTypeDoc());
//            customerNotificationsPojo.setDestinationmap(map.getDestinationmap());
        }
        if (customerNotificationsPojo.getSubscriptionType().equals("DesktopWithRTR")) {
            customerNotificationsPojo.setSubscriptionType("RTR");
        }
        if (customerNotificationsPojo.getSubscriptionType().equals("Hiconnect")) {
            customerNotificationsPojo.setSubscriptionType("Hiconnect");
        }
        sassCustomerNotificationsService.getSalesOrderSave(customerNotificationsPojo);
        return new IDMResponse(HttpStatus.OK.value(), "success");
    }

    @RequestMapping(value = HiConnectConstants.HI_CONNECT_SERVICES + HiConnectConstants.HI_CONNECT_VERSION + HiConnectConstants.HI_CONNECT_NOTIFICATIONS,
            method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public IDMResponse getZomatoData(String jsonInString, String fromRegno,String completeData) throws JSONException,Exception {
        CustomerNotificationsPojo customerNotificationsPojo = new CustomerNotificationsPojo();
        String aggregatorId = null;
        List<SassCompany> sassComapny = (List<SassCompany>) sassCompanyRepository.findAll();
        String json2 = new Gson().toJson(sassComapny);
        JSONObject companyData = new JSONObject(json2.substring(json2.indexOf('{')));
        customerNotificationsPojo.setFromRegno(companyData.get("hiConnectCompnyRegNo").toString());

        customerNotificationsPojo.setTypeDoc("ZSO");
        customerNotificationsPojo.setTypeFlag("Restaurant");
        customerNotificationsPojo.setViewStatus("pending");
        customerNotificationsPojo.setFromCompname(fromRegno);
        customerNotificationsPojo.setStatus("pending");
        customerNotificationsPojo.setObjectdata(jsonInString);
        customerNotificationsPojo.setCompleteData(completeData);
        final ObjectMapper mapper = new ObjectMapper();
        final JsonNode object = mapper.readTree(customerNotificationsPojo.getObjectdata());
        final JsonNode order = mapper.readTree(object.get("order").toString());
        String restaurant_id = order.get("restaurant_id").asText();
        String order_id = order.get("order_id").asText();
        if(StringUtils.isEmpty(completeData)){
            customerNotificationsPojo.setFromContact("Zomato");
            aggregatorId=order_id;
            Cartregistration cartregistration=cartRegistrationRepository.findByCartName("Zomato");
            if(cartregistration!=null) {
                CartCustomerLink customerLink = cartCustomerRepository.findByClientIdAndCartId(customerNotificationsPojo.getRestaurantId(), cartregistration);
                if(customerLink!=null)
                    customerNotificationsPojo.setRestaurantName(customerLink.getClientSecret());
            }
        }else {
            customerNotificationsPojo.setFromContact("UrbanPiper");
            aggregatorId=order.get("aggregatorId").asText();
            Cartregistration cartregistration=cartRegistrationRepository.findByCartName("UrbanPiper");
            if(cartregistration!=null) {
                CartCustomerLink customerLink = cartCustomerRepository.findByClientIdAndCartId(customerNotificationsPojo.getRestaurantId(), cartregistration);
                if(customerLink!=null)
                customerNotificationsPojo.setRestaurantName(customerLink.getClientSecret());
            }
        }
        customerNotificationsPojo.setRestaurantId(restaurant_id);
        customerNotificationsPojo.setCustomerNotification(order_id);
        customerNotificationsPojo.setOrderId(aggregatorId);
        sassCustomerNotificationsService.getZomatoSave(customerNotificationsPojo);
        return new IDMResponse(HttpStatus.OK.value(), "success");
    }

    public List<CustomerNotificationsPojo> getPendingNotificationsByRestaurantId(String restaurantId){
        Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC, "custNotiId"));
        List<CustomerNotifications> customerNotifications = sassCustomerNotificationsRepository.findAllByRestaurantIdAndStatus(restaurantId,"Placed",sort);
        List<CustomerNotificationsPojo> customerNotificationsPojos = ObjectMapperUtils.mapAll(customerNotifications,CustomerNotificationsPojo.class);
        return customerNotificationsPojos;
    }
    public List<CustomerNotificationsPojo> getAllNotifications(String jsonString)throws Exception{
        JSONObject jsonObject = new JSONObject(jsonString);
        Long notificationId=null;
        String searchText = jsonObject.getString("searchText");
        String restaurantId = jsonObject.getString("restaurantId");
        List<CustomerNotifications> customerNotifications;
        if(!StringUtils.isEmpty(searchText)) {
            String customerName = "\"name\":\"" + searchText;
            String customerNo = "\"phone_number\":\"" + searchText;
            boolean matches=searchText.matches("-?\\d+(\\.\\d+)?");
            if(matches){
                notificationId=Long.parseLong(searchText);
            }
            customerNotifications = sassCustomerNotificationsRepository.findAllBy(restaurantId,notificationId,"%"+customerName+"%","%"+customerNo+"%");
        }else {
            customerNotifications = sassCustomerNotificationsRepository.findAllByRestaurantId(restaurantId);
        }

        List<CustomerNotificationsPojo> customerNotificationsPojos = ObjectMapperUtils.mapAll(customerNotifications,CustomerNotificationsPojo.class);
        return customerNotificationsPojos;
    }


//    //Debit Note
//    @RequestMapping(value = HiConnectConstants.HI_CONNECT_VERSION + HiConnectConstants.HI_CONNECT_BROADCAST_PDN_DATA, method = RequestMethod.POST,
//            produces = MediaType.APPLICATION_JSON_VALUE)
//    public IDMResponse BroadCastPostPurchaseDnData(@RequestBody String jsonString) throws JSONException {
//        SassCompany customerObj = null;
//        JSONObject jsonObject = new JSONObject(jsonString);
//        Gson gson = new Gson();
//        String status = "pending";
//        String jsonObj = jsonObject.getString("jsonData");
//        JSONObject jsonData = new JSONObject(jsonObj);
//        CustomerNotificationsPojo customerNotificationsPojo = new CustomerNotificationsPojo();
//        customerNotificationsPojo.setObjectdata(jsonString);
//        customerNotificationsPojo.setTotalcheckoutamt(jsonData.get("totalCheckOutamt").toString());
//        customerNotificationsPojo.setTotaltax(jsonData.get("totalTaxAmt").toString());
//        customerNotificationsPojo.setFromRegno(jsonData.get("from_reg").toString());
//        customerNotificationsPojo.setToRegno(jsonData.get("to_reg").toString());
//        customerNotificationsPojo.setTypeDoc(jsonData.get("type_doc").toString());
//        customerNotificationsPojo.setTypeFlag(jsonData.get("type_flag").toString());
//        customerNotificationsPojo.setSubscriptionType(jsonData.get("subscriptionType").toString());
//        customerNotificationsPojo.setStatus(status);
////        customerNotificationsPojo.setPiNo(jsonData.get("piNo").toString());
//        customerObj = sassOrdersService.getSaasCustomerRegNoObj(customerNotificationsPojo.getFromRegno());
//        customerNotificationsPojo.setFromCompname(customerObj.getCustomerName());
//        customerObj = sassOrdersService.getSaasCustomerRegNoObj(customerNotificationsPojo.getToRegno());
//        customerNotificationsPojo.setToCompname(customerObj.getCustomerName());
//        if(customerNotificationsPojo.getTypeDoc() != null) {
//            DestinationMap map = sassControlPanelService.getMapObject(customerNotificationsPojo.getTypeDoc());
////            customerNotificationsPojo.setDestinationmap(map.getDestinationmap());
//        }
//        if (customerNotificationsPojo.getSubscriptionType().equals("DesktopWithRTR")) {
//            customerNotificationsPojo.setSubscriptionType("RTR");
//        }
//        if(customerNotificationsPojo.getSubscriptionType().equals("Hiconnect")){
//            customerNotificationsPojo.setSubscriptionType("Hiconnect");
//        }
//        sassCustomerNotificationsService.getDebitNoteSave(customerNotificationsPojo);
//        return new IDMResponse(HttpStatus.OK.value(), "success");
//
//    }

    //SaveNewItemData
    @RequestMapping(value = HiConnectConstants.HI_CONNECT_VERSION + HiConnectConstants.HI_CONNECT_BROADCAST_SNI_DATA, method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public IDMResponse BroadCastPostSaveNewItemData(@RequestBody String jsonString) throws JSONException {
        JSONObject jsonObject = new JSONObject(jsonString);
        Gson gson = new Gson();
        IcItem icItem = gson.fromJson(jsonString, IcItem.class);
        String msic = jsonObject.getString("itemMsicCode");
//        JSONObject jsonObject1 = new JSONObject(msic);
        icItem.setHsnCode(msic);
        String brand = jsonObject.getString("itemBrandName");
//        JSONObject jsonObject3 = new JSONObject(brand);
        icItem.setBrandName(brand);
        String category = jsonObject.getString("itemCategoryName");
//        JSONObject jsonObject4 = new JSONObject(category);
        icItem.setItemCategoryName(category);
        String itemtype = jsonObject.getString("itemTypeName");
//        JSONObject jsonObject5 = new JSONObject(itemtype);
        icItem.setItemTypeName(itemtype);
        String counttype = jsonObject.getString("itemCountTypeName");
//        JSONObject jsonObject9 = new JSONObject(counttype);
        icItem.setInventoryMovementName(counttype);
        String inputtax = jsonObject.getString("itemIPTaXCode");
//        JSONObject jsonObject6 = new JSONObject(inputtax);
        icItem.setInputTaxId(inputtax);
        String outputtax = jsonObject.getString("itemOPTaxCode");
//        JSONObject jsonObject7 = new JSONObject(outputtax);
        icItem.setOutputTaxId(outputtax);
        String uom = jsonObject.getString("itemUomName");
//        JSONObject jsonObject8 = new JSONObject(uom);
        icItem.setUnitOfMeasurementId(uom);
        String cart = jsonObject.getString("addedCartsList");
        icItem.setItemSelectedCarts(cart);
        sassOrdersService.getSaveNewItemData(icItem);
        return new IDMResponse(HttpStatus.OK.value(), "success");
    }

    //SaveSalesInvoiceData
    @RequestMapping(value = HiConnectConstants.HI_CONNECT_VERSION + HiConnectConstants.HI_CONNECT_BROADCAST_SSI_DATA, method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public IDMResponse broadCastPostSaveSalesInvoiceData(@RequestBody String jsonString) throws JSONException {
        JSONObject jsonObject = new JSONObject(jsonString);
        Gson gson = new Gson();
        IcItem icItem = gson.fromJson(jsonString, IcItem.class);
        String selectitemlist = jsonObject.getString("selectedItemsList");
        JSONObject selecteditemlist = new JSONObject(selectitemlist.substring(selectitemlist.indexOf('{')));
        icItem.setItemCode(selecteditemlist.get("itemCode").toString());
        icItem.setItemName(selecteditemlist.get("itemName").toString());
        icItem.setItemDesc(selecteditemlist.get("itemDescription").toString());
        icItem.setItemStatus(jsonObject.get("siStatus").toString());
        sassOrdersService.getSaveSalesInvoiceData(icItem);
        return new IDMResponse(HttpStatus.OK.value(), "success");

    }

    //StockUpdate in icItem table in IDM with  EXISTING stock value
    @RequestMapping(value = HiConnectConstants.HI_CONNECT_VERSION + HiConnectConstants.HI_CONNECT_BROADCAST_SIS_DATA, method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public IDMResponse broadCastPostSalesInvoiceStockUpdate(@RequestBody String jsonString) throws JSONException {
        JSONObject jsonObject = new JSONObject(jsonString);
        Gson gson = new Gson();
        String itemCode = jsonObject.getString("itemCode");
        String qty = jsonObject.getString("qty");
        IcItem icItemObj = icItemRepository.findByitemCode(itemCode);
        Double stockval = (icItemObj.getStock() - Double.valueOf(qty));
        icItemObj.setStock(stockval);
        icItemRepository.save(icItemObj);
        return new IDMResponse(HttpStatus.OK.value(), "success");

    }

    //StockUpdate in icItem table in IDM with  EXISTING stock value
    @RequestMapping(value = HiConnectConstants.HI_CONNECT_VERSION + HiConnectConstants.HI_CONNECT_BROADCAST_SDO_DATA, method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public IDMResponse broadCastPostSalesDeliveryStockUpdate(@RequestBody String jsonString) throws JSONException {
        JSONObject jsonObject = new JSONObject(jsonString);
        Gson gson = new Gson();
        String itemCode = jsonObject.getString("itemCode");
        String qty = jsonObject.getString("qty");
        IcItem icItemObj = icItemRepository.findByitemCode(itemCode);
        Double stockval = (icItemObj.getStock() - Double.valueOf(qty));
        icItemObj.setStock(stockval);
        icItemRepository.save(icItemObj);
        return new IDMResponse(HttpStatus.OK.value(), "success");

    }

    //StockUpdate in icItem table in IDM with  EXISTING stock value
    @RequestMapping(value = HiConnectConstants.HI_CONNECT_VERSION + HiConnectConstants.HI_CONNECT_BROADCAST_PRI_DATA, method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public IDMResponse broadCastPostReceiveItemStockUpdate(@RequestBody String jsonString) throws JSONException {
        JSONObject jsonObject = new JSONObject(jsonString);
        Gson gson = new Gson();
        String itemCode = jsonObject.getString("itemCode");
        String qty = jsonObject.getString("qty");
        IcItem icItemObj = icItemRepository.findByitemCode(itemCode);
        Double stockval = (icItemObj.getStock() + Double.valueOf(qty));
        icItemObj.setStock(stockval);
        icItemRepository.save(icItemObj);
        return new IDMResponse(HttpStatus.OK.value(), "success");

    }

    //StockUpdate in icItem table in IDM with  EXISTING stock value
    @RequestMapping(value = HiConnectConstants.HI_CONNECT_VERSION + HiConnectConstants.HI_CONNECT_BROADCAST_PIS_DATA, method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public IDMResponse broadCastPostPurchaseInvoiceStockUpdate(@RequestBody String jsonString) throws JSONException {
        JSONObject jsonObject = new JSONObject(jsonString);
        Gson gson = new Gson();
        String itemCode = jsonObject.getString("itemCode");
        String qty = jsonObject.getString("qty");
        IcItem icItemObj = icItemRepository.findByitemCode(itemCode);
        Double stockval = (icItemObj.getStock() + Double.valueOf(qty));
        icItemObj.setStock(stockval);
        icItemRepository.save(icItemObj);
        return new IDMResponse(HttpStatus.OK.value(), "success");

    }

    @RequestMapping(value = HiConnectConstants.HI_CONNECT_VERSION + HiConnectConstants.HI_CONNECT_RTR_NOTIFICATIONS, method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Object getRTRNotifications(@RequestBody String jsonString) throws JSONException {
        JSONObject jsonObject = new JSONObject(jsonString);
        String regNo = jsonObject.getString("regno");
        String status = "";
        List<CustomerNotifications> gettingstatus = sassCustomerNotificationsService.getSubscriptionType(regNo, "RTR");
        CustomerListBasedOnToRegNoPojo custNtftnList = new CustomerListBasedOnToRegNoPojo();
        custNtftnList.setCustomerNotificationsList(gettingstatus);
        Gson gson = new Gson();
        String custNotftnList = gson.toJson(custNtftnList);
        return new IDMResponse(HttpStatus.OK.value(), "success", custNotftnList);
    }

    @RequestMapping(value = HiConnectConstants.HI_CONNECT_VERSION + HiConnectConstants.HI_CONNECT_RTR_STATUS_UPDATE, method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public IDMResponse rtrTransactions(@RequestBody String jsonString) throws JSONException {
        JSONObject jsonObject = new JSONObject(jsonString);
        String custNotiId = jsonObject.getString("custNotiId");
        CustomerNotifications customerNotificationObj = sassCustomerNotificationsService.getUpdateRTRviewStatus(custNotiId);
        customerNotificationObj.setViewStatus("RTRCompleted");
        sassCustomerNotificationsRepository.save(customerNotificationObj);
        return new IDMResponse(HttpStatus.OK.value(), "success");

    }

    @RequestMapping(value = HiConnectConstants.HI_CONNECT_VERSION + HiConnectConstants.HI_CONNECT_CART_MASTER_UPDATE, method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public IDMResponse updatingCartMaster(@RequestBody String jsonString) throws JSONException {
        JSONObject jsonObject = new JSONObject(jsonString);
        String custNotiId = jsonObject.getString("custNotiId");
        CustomerNotifications customerNotificationObj = sassCustomerNotificationsService.getUpdateRTRviewStatus(custNotiId);
        customerNotificationObj.setViewStatus("RTRCompleted");
        sassCustomerNotificationsRepository.save(customerNotificationObj);
        return new IDMResponse(HttpStatus.OK.value(), "success");

    }

    //AddMaster
    @RequestMapping(value = HiConnectConstants.HI_CONNECT_VERSION + HiConnectConstants.RTR_MASTERS, method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public IDMResponse BroadCastMasterData(@RequestBody String jsonString) throws JSONException {
        SassCompany customerObj = null;
        DestinationMap mapObj = null;
        JSONObject jsonData1 = new JSONObject(jsonString);
        Gson gson = new Gson();
        String status = "pending";
        CustomerNotificationsPojo customerNotificationsPojo = new CustomerNotificationsPojo();
        String jsonObj = jsonData1.getString("jsonData");
        JSONObject jsonData = new JSONObject(jsonObj);
        String jsonData2 = jsonData.getString("jsonData");
        JSONObject jsonData3 = new JSONObject(jsonData2);
        customerNotificationsPojo.setSubscriptionType(jsonData.get("subscriptionType").toString());
        customerNotificationsPojo.setObjectdata(jsonString);
        customerNotificationsPojo.setFromRegno(jsonData.get("from_reg").toString());
        customerNotificationsPojo.setToRegno(jsonData.get("to_reg").toString());
        customerNotificationsPojo.setTypeDoc(jsonData.get("typeDoc").toString());
        customerNotificationsPojo.setTypeFlag(jsonData.get("typeFlag").toString());
        customerNotificationsPojo.setStatus(status);
        customerNotificationsPojo.setViewStatus("pending");
        customerObj = sassOrdersService.getSaasCustomerRegNoObj(customerNotificationsPojo.getFromRegno());
        if (customerNotificationsPojo.getTypeDoc() != null) {
            DestinationMap map = sassControlPanelService.getMapObject(customerNotificationsPojo.getTypeDoc());
        }
        if (customerNotificationsPojo.getSubscriptionType().equals("DesktopWithRTR")) {
            customerNotificationsPojo.setSubscriptionType("RTR");
        }
        sassCustomerNotificationsService.getSalesInvoiceSave(customerNotificationsPojo);
        return new IDMResponse(HttpStatus.OK.value(), "success");
    }


    //Transaction
    @RequestMapping(value = HiConnectConstants.HI_CONNECT_VERSION + HiConnectConstants.RTR_TRANSACTION, method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public IDMResponse BroadCastTransactionData(@RequestBody String jsonString) throws JSONException {
        SassCompany customerObj = null;
        DestinationMap mapObj = null;
        JSONObject jsonData1 = new JSONObject(jsonString);
        Gson gson = new Gson();
        String status = "pending";
        CustomerNotificationsPojo customerNotificationsPojo = new CustomerNotificationsPojo();
        String jsonObj = jsonData1.getString("jsonData");
        JSONObject jsonData = new JSONObject(jsonObj);
        customerNotificationsPojo.setObjectdata(jsonString);
        //  customerNotificationsPojo.setTotalcheckoutamt(jsonData.get("totalCheckOutamt").toString());
        //  customerNotificationsPojo.setTotaltax(jsonData.get("totalTaxAmt").toString());
        customerNotificationsPojo.setSubscriptionType(jsonData.get("subscriptionType").toString());
        customerNotificationsPojo.setFromRegno(jsonData.get("from_reg").toString());
        customerNotificationsPojo.setToRegno(jsonData.get("to_reg").toString());
        customerNotificationsPojo.setTypeDoc(jsonData.get("typeDoc").toString());
        customerNotificationsPojo.setTypeFlag(jsonData.get("typeFlag").toString());
        customerNotificationsPojo.setStatus(status);
        //  customerNotificationsPojo.setSiNo(jsonData.get("siNo").toString());
        customerNotificationsPojo.setViewStatus("pending");
        //  customerObj = sassOrdersService.getSaasCustomerRegNoObj(customerNotificationsPojo.getFromRegno());
        //  customerNotificationsPojo.setFromCompname(jsonData.get("cutomerName").toString());
        if (customerNotificationsPojo.getTypeDoc() != null) {
            DestinationMap map = sassControlPanelService.getMapObject(customerNotificationsPojo.getTypeDoc());
//            customerNotificationsPojo.setDestinationmap(map.getDestinationmap());
        }
        if (customerNotificationsPojo.getSubscriptionType().equals("DesktopWithRTR")) {
            customerNotificationsPojo.setSubscriptionType("RTR");
        }
        sassCustomerNotificationsService.getSalesInvoiceSave(customerNotificationsPojo);
        return new IDMResponse(HttpStatus.OK.value(), "success");
    }


    @RequestMapping(value = HiConnectConstants.HI_CONNECT_VERSION + HiConnectConstants.HI_CONNECT_BROADCAST_PR_DATA, method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public IDMResponse BroadCastPostPurchaseReturnData(@RequestBody String jsonString) throws JSONException {
        SassCompany customerObj = null;
        DestinationMap mapObj = null;
        JSONObject jsonData1 = new JSONObject(jsonString);
        Gson gson = new Gson();
        String status = "pending";
        CustomerNotificationsPojo customerNotificationsPojo = new CustomerNotificationsPojo();
        String jsonObj = jsonData1.getString("jsonData");
        JSONObject jsonData = new JSONObject(jsonObj);
        customerNotificationsPojo.setObjectdata(jsonString);
        customerNotificationsPojo.setTotalcheckoutamt(jsonData.get("totalCheckOutamt").toString());
        customerNotificationsPojo.setTotaltax(jsonData.get("totalTaxAmt").toString());
        customerNotificationsPojo.setSubscriptionType(jsonData.get("subscriptionType").toString());
        customerNotificationsPojo.setFromRegno(jsonData.get("from_reg").toString());
        customerNotificationsPojo.setToRegno(jsonData.get("to_reg").toString());
        customerNotificationsPojo.setTypeDoc(jsonData.get("typeDoc").toString());
        customerNotificationsPojo.setTypeFlag(jsonData.get("type_flag").toString());
        customerNotificationsPojo.setStatus(status);
        customerNotificationsPojo.setSiNo(jsonData.get("piNo").toString());
        customerNotificationsPojo.setViewStatus("pending");
        customerObj = sassOrdersService.getSaasCustomerRegNoObj(customerNotificationsPojo.getFromRegno());
        customerNotificationsPojo.setFromCompname(customerObj.getCustomerName());
        customerObj = sassOrdersService.getSaasCustomerRegNoObj(customerNotificationsPojo.getToRegno());
        customerNotificationsPojo.setToCompname(customerObj.getCustomerName());
        if (customerNotificationsPojo.getTypeDoc() != null) {
            DestinationMap map = sassControlPanelService.getMapObject(customerNotificationsPojo.getTypeDoc());
//            customerNotificationsPojo.setDestinationmap(map.getDestinationmap());
        }
        if (customerNotificationsPojo.getSubscriptionType().equals("DesktopWithRTR")) {
            customerNotificationsPojo.setSubscriptionType("RTR");
        }
        if (customerNotificationsPojo.getSubscriptionType().equals("Hiconnect")) {
            customerNotificationsPojo.setSubscriptionType("Hiconnect");
        }
        sassCustomerNotificationsService.getSalesInvoiceSave(customerNotificationsPojo);
        return new IDMResponse(HttpStatus.OK.value(), "success");
    }

//    @RequestMapping(value = HiConnectConstants.HI_CONNECT_VERSION + HiConnectConstants.HI_CONNECT_RTR_SERVICE, method = RequestMethod.POST,
//            produces = MediaType.APPLICATION_JSON_VALUE)
//    public IDMResponse rtrService(@RequestBody String jsonString) throws JSONException {
//        JSONObject jsonObject = new JSONObject(jsonString);
//        Gson gson = new Gson();
//        String data = jsonObject.getString("transactionData");
//        CustomerNotificationsPojo customerNotificationsPojo = new CustomerNotificationsPojo();
//        customerNotificationsPojo.setObjectdata(data);
//        customerNotificationsPojo.setTypeDoc(jsonObject.get("type_doc").toString());
//        customerNotificationsPojo.setTypeFlag(jsonObject.get("type_flag").toString());
//        customerNotificationsPojo.setStatus(jsonObject.get("transcationStatus").toString());
//        customerNotificationsPojo.setPiNo(jsonObject.get("piNo").toString());
//        sassCustomerNotificationsService.getPurchaseOrderSave(customerNotificationsPojo);
//        return new IDMResponse(HttpStatus.OK.value(), "success");
//
//    }

//    @RequestMapping(value = HiConnectConstants.HI_CONNECT_VERSION + HiConnectConstants.HI_CONNECT_RTR_TRANSACTIONS, method = RequestMethod.POST,
//            produces = MediaType.APPLICATION_JSON_VALUE)
//    public IDMResponse rtrTransactions(@RequestBody String jsonString) throws JSONException {
//        JSONObject jsonObject = new JSONObject(jsonString);
//        String status = jsonObject.getString("status");
//        List<CustomerNotifications> customerNotificationObj = sassCustomerNotificationsService.getRTRTransactions(status);
//        Gson gson = new Gson();
//        String custNotftnList = gson.toJson(customerNotificationObj);
//        return new IDMResponse(HttpStatus.OK.value(), "success", custNotftnList);
//
//    }

//    // SalesQuotation
//
//    @RequestMapping(value = HiConnectConstants.HI_CONNECT_VERSION  + HiConnectConstants.HI_CONNECT_BROADCAST_SQ_DATA,method = RequestMethod.POST,
//            produces = MediaType.APPLICATION_JSON_VALUE)
//    public IDMResponse BroadCastPostSalesQuotationData(@RequestBody String jsonString) throws JSONException {
//        JSONObject jsonObject = new JSONObject(jsonString);
//        Gson gson = new Gson();
//        String status = "pending";
//        TransactionsDataPojo transactionsDataPojo = new TransactionsDataPojo();
//        transactionsDataPojo.setObjectdata(jsonObject.get("selectedItemsList").toString());
////        transactionsDataPojo.setStatus(jsonObject.get("status").toString());
//        transactionsDataPojo.setStatus(status);
//        transactionsDataPojo.setTotalcheckoutamt(jsonObject.get("totalCheckOutamt").toString());
//        transactionsDataPojo.setTotaltax(jsonObject.get("totalTaxAmt").toString());
//        transactionsDataPojo.setTypeDoc(jsonObject.get("type_doc").toString());
//        transactionsDataPojo.setTypeFlag(jsonObject.get("type_flag").toString());
//        saasTranscationsDataService.getSalesQuotationSave(transactionsDataPojo);
//        return new IDMResponse(HttpStatus.OK.value(), "success");
//    }

    @RequestMapping(value = HiConnectConstants.HI_CONNECT_VERSION + HiConnectConstants.HI_CONNECT_USER_AS, method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public IDMResponse addNewUserDetails(@RequestBody String jsonString) throws JSONException {
        JSONObject jsonObject = new JSONObject(jsonString);
        SassUser sassUser = new SassUser();
        SassUser sassUser1 = new SassUser();
        if (jsonObject.get("userToken").equals("")) {
            sassUser1 = SassUserRepository.findByCompanyNameAndUserName(jsonObject.get("companyName").toString(), jsonObject.get("user_name").toString());
            if (sassUser1 != null) {
                if (sassUser1.getCompanyName().equalsIgnoreCase(jsonObject.get("companyName").toString())
                        && (sassUser1.getUserName().equals(jsonObject.get("user_name").toString()))) {
                    return new IDMResponse(HttpStatus.OK.value(), "Already registered", sassUser1);
                }
            } else {


                int saasUserCount = SassUserRepository.countByCompanyName(jsonObject.get("companyName").toString());
                int saasUserCount1 = saasUserCount + 1;
                SassCompany sassCompany = sassCompanyRepository.findByHiConnectCompnyRegNo(jsonObject.get("companyName").toString()).get(0);
                int saasCompanyCount = Integer.parseInt(sassCompany.getSassSubscriptionsId().getUsers());
                if (saasUserCount1 > saasCompanyCount) {
                    return new IDMResponse(HttpStatus.OK.value(), "cannot add more user", sassUser);
                } else {
                    sassUser.setPasswordUser(jsonObject.get("password").toString());
                    sassUser.setSecurityQuestion(jsonObject.get("security_question").toString());
                    sassUser.setSecurityAnswer(jsonObject.get("security_answer").toString());
                    sassUser.setUserName(jsonObject.get("user_name").toString());
                    sassUser.setCompanyName(jsonObject.get("companyName").toString());
                    sassUser.setEmail(jsonObject.get("user_email").toString());
                    sassUser.setPhone(jsonObject.get("telephone_number").toString());
                    sassUser.setFull_name(jsonObject.get("full_name").toString());
                    sassUser.setStatus(jsonObject.get("status").toString());
                    SassUserRepository.save(sassUser);
                }
            }

        } else if (jsonObject.has("userToken")) {
            sassUser = SassUserRepository.findByUserToken(jsonObject.get("userToken").toString());
            sassUser.setPasswordUser(jsonObject.get("password").toString());
            sassUser.setSecurityQuestion(jsonObject.get("security_question").toString());
            sassUser.setSecurityAnswer(jsonObject.get("security_answer").toString());
            sassUser.setUserName(jsonObject.get("user_name").toString());
            sassUser.setEmail(jsonObject.get("user_email").toString());
            sassUser.setPhone(jsonObject.get("telephone_number").toString());
            sassUser.setFull_name(jsonObject.get("full_name").toString());
            sassUser.setStatus(jsonObject.get("status").toString());
            SassUserRepository.save(sassUser);
            return new IDMResponse(HttpStatus.OK.value(), "success", sassUser);
        }
        return new IDMResponse(HttpStatus.OK.value(), "success", sassUser);
    }

    @RequestMapping(value = HiConnectConstants.HI_CONNECT_VERSION + HiConnectConstants.HI_CONNECT_CART_MASTER, method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public IDMResponse addNewCart(@RequestBody String jsonString) throws JSONException {
        JSONObject jsonObject = new JSONObject(jsonString);
        CartCustomerLink link = new CartCustomerLink();
        if (jsonObject.has("email")) {
            link = cartCustomerRepository.findByEmail(jsonObject.get("email").toString());
            if(link != null) {
                if(link.getEmail().equalsIgnoreCase(jsonObject.get("email").toString())) ;

                link.setUserName(jsonObject.get("user_name").toString());
                link.setCompanyId(jsonObject.get("companyId").toString());
                link.setPassword(jsonObject.get("password").toString());
                link.setStatus(jsonObject.get("status").toString());
                link.setEmail(jsonObject.get("email").toString());
                cartCustomerRepository.save(link);
            } else {
                CartCustomerLink customerLink = new CartCustomerLink();
                link = cartCustomerRepository.findByCartCustId(jsonObject.getLong("cartCustId"));
                link.setUserName(jsonObject.get("user_name").toString());
                link.setCompanyId(jsonObject.get("companyId").toString());
                link.setPassword(jsonObject.get("password").toString());
                link.setStatus(jsonObject.get("status").toString());
                link.setEmail(jsonObject.get("email").toString());
                cartCustomerRepository.save(link);


                return new IDMResponse(HttpStatus.OK.value(), "success", link);
            }

        }
        return new IDMResponse(HttpStatus.OK.value(), "success", link);
    }


    //MASTER PKT Permissions
    @RequestMapping(value = HiConnectConstants.HI_CONNECT_VERSION + HiConnectConstants.HI_CONNECT_MASTER_PKT, method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public IDMResponse getPermissionPKT(@RequestBody String jsonString) throws JSONException {
        String object = "";
        List<PktPermissions> pktPermissionPojos =pktService.getPktPermissionList(jsonString);

        return new IDMResponse(HttpStatus.OK.value(), "success", pktPermissionPojos);
    }



    @RequestMapping(value = HiConnectConstants.HI_CONNECT_VERSION + HiConnectConstants.HI_CONNECT_IDM_PERMISSIONS, method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public IDMResponse getAllPermissionPerms() throws JSONException {
        List<PktPermissions> pktPermissionPojos =pktService.getAllPktPermissionList();
        return new IDMResponse(HttpStatus.OK.value(), "success", pktPermissionPojos);
    }



    @RequestMapping(value = HiConnectConstants.HI_CONNECT_VERSION + HiConnectConstants.HI_CONNECT_DEFAULT_MASTER_PKT, method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public IDMResponse getdefaultPermissionPKT() throws JSONException {
        String object = "";
        List<defaultPermissions> defaultPojos = sassControlPanelService. getDefPktPermissionList();
        return new IDMResponse(HttpStatus.OK.value(), "success", defaultPojos);
    }







    //MASTER PKT BUILDER
    @RequestMapping(value =HiConnectConstants.HI_CONNECT_VERSION+HiConnectConstants.HI_CONNECT_BUILDER_PKT,method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public IDMResponse getPktBuilder(@RequestBody String jsonString) throws JSONException {
       List<PktBuilder>  pktBuilders = pktService.getpktBuilderList(jsonString);
       return new IDMResponse(HttpStatus.OK.value(),"success",pktBuilders);


    }
}












