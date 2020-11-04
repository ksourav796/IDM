package com.hyva.idm.sass.sassservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.hyva.idm.sass.sassentities.Cartregistration;
import com.hyva.idm.sass.sassentities.CustomerNotifications;
import com.hyva.idm.sass.sasspojo.ZomatoPojo;
import com.hyva.idm.sass.sassrespositories.CartRegistrationRepository;
import com.hyva.idm.sass.sassrespositories.SassCustomerNotificationsRepository;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.io.IOException;


@Component
public class ZomatoService {
    @Autowired
    CartRegistrationRepository cartRegistrationRepository;
    @Autowired
    SassCustomerNotificationsRepository sassCustomerNotificationsRepository;


    @Transactional
    public ZomatoPojo changeStatus(ZomatoPojo zomatoPojo)  {
        CustomerNotifications customerNotifications =sassCustomerNotificationsRepository.findAllByCustNotiId(zomatoPojo.getCustNotiId());
        customerNotifications.setStatus(zomatoPojo.getStatus());
        sassCustomerNotificationsRepository.save(customerNotifications);
        return zomatoPojo;
    }
    @Transactional
    public ZomatoPojo saveasiandelivery(ZomatoPojo zomatoPojo) {
        CustomerNotifications customerNotifications =sassCustomerNotificationsRepository.findAllByCustNotiId(zomatoPojo.getCustNotiId());
        customerNotifications.setStatus("Assigned");
        sassCustomerNotificationsRepository.save(customerNotifications);
        Cartregistration cartregistration = cartRegistrationRepository.findOne(1L);
        String strUrl=cartregistration.getUrl()+"/assigned";
        ObjectMapper ZomatoMapper = new ObjectMapper();
        ObjectNode zomatoObjectNode = ZomatoMapper.createObjectNode();
        zomatoObjectNode.put("order_id", zomatoPojo.getOrderId());
        zomatoObjectNode.put("rider_name", zomatoPojo.getRiderName());
        zomatoObjectNode.putPOJO("rider_phone_number", zomatoPojo.getRiderPhoneNo());

        //Spring Rest Client Call
        RestTemplate zomatoRestTemplate = new RestTemplate();
        HttpHeaders zomatoHeaders = new HttpHeaders();
        zomatoHeaders.add("X-Zomato-Api-Key", cartregistration.getApi());
        zomatoHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> zomatoEntity = new HttpEntity<String>(zomatoObjectNode.toString(), zomatoHeaders);
        ResponseEntity<String> responseEntity = null;
        try {
            responseEntity = zomatoRestTemplate.exchange(strUrl, HttpMethod.POST, zomatoEntity, String.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return zomatoPojo;
    }
    @Transactional
    public ZomatoPojo savepickedup( ZomatoPojo zomatoPojo)  {
        CustomerNotifications customerNotifications =sassCustomerNotificationsRepository.findAllByCustNotiId(zomatoPojo.getCustNotiId());
        customerNotifications.setStatus("Picked");
        sassCustomerNotificationsRepository.save(customerNotifications);
        Cartregistration cartregistration = cartRegistrationRepository.findOne(1L);
        String strUrl=cartregistration.getUrl()+"/pickedup";
        ObjectMapper ZomatoMapper = new ObjectMapper();
        ObjectNode zomatoObjectNode = ZomatoMapper.createObjectNode();
        zomatoObjectNode.put("order_id", zomatoPojo.getOrderId());
        zomatoObjectNode.put("rider_name", zomatoPojo.getRiderName());
        zomatoObjectNode.putPOJO("rider_phone_number", zomatoPojo.getRiderPhoneNo());

        //Spring Rest Client Call
        RestTemplate zomatoRestTemplate = new RestTemplate();
        HttpHeaders zomatoHeaders = new HttpHeaders();
        zomatoHeaders.add("X-Zomato-Api-Key", cartregistration.getApi());
        zomatoHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> zomatoEntity = new HttpEntity<String>(zomatoObjectNode.toString(), zomatoHeaders);
        ResponseEntity<String> responseEntity = null;
        try {
            responseEntity = zomatoRestTemplate.exchange(strUrl, HttpMethod.POST, zomatoEntity, String.class);
        } catch (Exception e) {
e.printStackTrace();
        }
        return zomatoPojo;
    }
    @Transactional
    public ZomatoPojo savedeliverd( ZomatoPojo zomatoPojo)  {
        CustomerNotifications customerNotifications =sassCustomerNotificationsRepository.findAllByCustNotiId(zomatoPojo.getCustNotiId());
        customerNotifications.setStatus("Delivered");
        sassCustomerNotificationsRepository.save(customerNotifications);
        Cartregistration cartregistration= cartRegistrationRepository.findOne(1L);
        String strUrl=cartregistration.getUrl()+"/delivered";
        ObjectMapper ZomatoMapper = new ObjectMapper();
        ObjectNode zomatoObjectNode = ZomatoMapper.createObjectNode();
        zomatoObjectNode.put("order_id", zomatoPojo.getOrderId());

        //Spring Rest Client Call
        RestTemplate zomatoRestTemplate = new RestTemplate();
        HttpHeaders zomatoHeaders = new HttpHeaders();
        zomatoHeaders.add("X-Zomato-Api-Key", cartregistration.getApi());
        zomatoHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> zomatoEntity = new HttpEntity<String>(zomatoObjectNode.toString(), zomatoHeaders);
        ResponseEntity<String> responseEntity = null;
        try {
            responseEntity = zomatoRestTemplate.exchange(strUrl, HttpMethod.POST, zomatoEntity, String.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return zomatoPojo;
    }

    @Transactional
    public ZomatoPojo saveready(ZomatoPojo zomatoPojo)  {
        CustomerNotifications customerNotifications =sassCustomerNotificationsRepository.findAllByCustNotiId(zomatoPojo.getCustNotiId());
        customerNotifications.setStatus("Ready");
        sassCustomerNotificationsRepository.save(customerNotifications);
        Cartregistration cartregistration = cartRegistrationRepository.findOne(1L);
        if(cartregistration!=null) {
            String strUrl = cartregistration.getUrl() + "/ready";
            ObjectMapper ZomatoMapper = new ObjectMapper();
            ObjectNode zomatoObjectNode = ZomatoMapper.createObjectNode();
            ObjectNode zomatoObject = ZomatoMapper.createObjectNode();
            zomatoObjectNode.put("order_type", "PICKUP");
            zomatoObject.put("prep_time", zomatoPojo.getPrepareTime());
            zomatoObject.putPOJO("customer_arrival_timestamp", zomatoPojo.getCustomerArrivalTime());
            zomatoObjectNode.put("pickup_details", zomatoObject.toString());

            //Spring Rest Client Call
            RestTemplate zomatoRestTemplate = new RestTemplate();
            HttpHeaders zomatoHeaders = new HttpHeaders();
            zomatoHeaders.add("X-Zomato-Api-Key", cartregistration.getApi());
            zomatoHeaders.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> zomatoEntity = new HttpEntity<String>(zomatoObjectNode.toString(), zomatoHeaders);
            ResponseEntity<String> responseEntity = null;
            try {
                responseEntity = zomatoRestTemplate.exchange(strUrl, HttpMethod.POST, zomatoEntity, String.class);
            } catch (Exception e) {
e.printStackTrace();
            }
        }
        return zomatoPojo;
    }






}
