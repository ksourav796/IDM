package com.hyva.idm.sass.sassendpoints;

import com.hyva.idm.constants.EndpointConstants;
import com.hyva.idm.pojo.IDMResponse;
import com.hyva.idm.sass.sassentities.PosPaymentTypes;
import com.hyva.idm.sass.sassentities.SassOrders;
import com.hyva.idm.sass.sasspojo.BasePojo;
import com.hyva.idm.sass.sasspojo.PermissionGroupDTO;
import com.hyva.idm.sass.sasspojo.SassCurrencyPojo;
import com.hyva.idm.sass.sasspojo.SassOrdersPojo;
import com.hyva.idm.sass.sassservice.SassControlPanelService;
import com.hyva.idm.sass.sassservice.SassOrdersService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(EndpointConstants.SERVICES_ENDPOINT)
public class SassRespondingController {
    @Autowired
    SassOrdersService sassOrdersService;
    @Autowired
    SassControlPanelService sassControlPanelService;
    @Autowired
    HiConnectEndPoint hiConnectEndPoint;
    private static final Logger LOGGER = Logger.getLogger("SassRespondingController.class");

    @RequestMapping(value = "/buynowOrderSave", method = RequestMethod.POST, consumes = "application/json",produces = "application/json")
    public IDMResponse buynowOrderSave(@RequestBody SassOrdersPojo details) throws Exception{
        SassOrders sassOrders = null;
//        details.setUserId(userId);
        sassOrders = sassOrdersService.createbuynowOrderSave(details);
        String message=null;
        if(sassOrders==null){
            message="Duplicate";
        }else {
            message="Success";
        }
        return new IDMResponse(HttpStatus.OK.value(), message,sassOrders);
    }
    @RequestMapping(value = "/getCompanyDetails", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity getCompanyDetails(@RequestParam(value = "id", required = false) Long id) {
        return ResponseEntity.status(200).body(sassOrdersService.companyDetails(id));
    }
    @RequestMapping(value = "/getSubscriptionDetails", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity getSubscriptionDetails(@RequestParam(value = "id", required = false) Long id) {
        return ResponseEntity.status(200).body(sassOrdersService.subscriptionDetails(id));
    }
    @RequestMapping(value = "/getPaymentDetails", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity getPaymentDetails(@RequestParam(value = "id", required = false) Long id)throws  Exception {
        return ResponseEntity.status(200).body(sassOrdersService.paymentDetails(id));
    }

    @RequestMapping(value = "/getOrderList",
            method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public IDMResponse getOrderList(){
        List<SassOrdersPojo> sassOrdersPojos= sassOrdersService.OrderList();
        return new IDMResponse(HttpStatus.OK.value(), "success",sassOrdersPojos);
    }


    @RequestMapping(value = "/getRenewToken",
            method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public IDMResponse getRenewToken(@RequestParam("Parent_Token") String parent_Token,@RequestParam("email") String email){
        SassOrders sassOrders=sassOrdersService.validateParent_Token(parent_Token,email);

        return new IDMResponse(HttpStatus.OK.value(), "success");
    }

    @RequestMapping(value = "/getOrderListByEmail",method = RequestMethod.GET,produces="application/json")
    public List<SassOrders> getOrderListByEmail(@RequestParam("email") String email)
    {
        return sassOrdersService.getOrderListByEmail(email);
    }
    @RequestMapping(value = "/getPermissionList",
            method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public IDMResponse getPermissionList(){
        System.out.println("helloooo");

        return new IDMResponse(HttpStatus.OK.value(), "azgar success");
    }
    @RequestMapping(value = "/getPermissionLists",
            method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
    public IDMResponse getPermissionLists(){
        List<PermissionGroupDTO>permissionGroupList=sassControlPanelService.getpermissiongroupList1();

        return new IDMResponse(HttpStatus.OK.value(),"success",permissionGroupList);
    }

    @RequestMapping(value = "/getPaymentsList",
            method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public IDMResponse getPaymentsList(){
        List<PosPaymentTypes> posPaymentTypes=sassOrdersService.getPaymentsList();
        return new IDMResponse(HttpStatus.OK.value(), "azgar success",posPaymentTypes);
    }


    @RequestMapping(value = "/getCurrencyPrerequisite",
            method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public IDMResponse getCurrencyPrerequisite(){
        SassCurrencyPojo sassCurrencyPojo=sassControlPanelService.getCurrencyPrerequisite();
        return new IDMResponse(HttpStatus.OK.value(), "azgar success",sassCurrencyPojo);
    }

    @RequestMapping(value = "/getPaginatedorderList", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity getPaginatedItemCategoryList(@RequestParam(value = "searchText",required = false) String searchText,
                                                       @RequestBody BasePojo basePojo) {
        return ResponseEntity.status(200).body(sassOrdersService.getPaginatedOrderList(basePojo,searchText));
    }





//    @RequestMapping(value = "/getLicence",
//            method = RequestMethod.POST,
//            produces = MediaType.APPLICATION_JSON)
//    public License getLicence(@RequestBody License license){
//        System.out.println("helloooo"+license.toString());
//        LOGGER.debug("I am in the controller and gotj user name: " + license.toString());
//        return license;
//
//    }

}
