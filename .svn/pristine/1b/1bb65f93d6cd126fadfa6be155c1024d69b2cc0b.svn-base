package com.hyva.idm.sass.sassmapper;

import com.hyva.idm.sass.sassentities.CustomerNotifications;
import com.hyva.idm.sass.sassentities.SassCustomer;
import com.hyva.idm.sass.sasspojo.CustomerNotificationsPojo;

import java.util.ArrayList;
import java.util.List;


public class CustomerNotificationMapper {
    public static CustomerNotifications mapPojoToEntity(CustomerNotificationsPojo customerNotificationsPojo){
        CustomerNotifications customerNotifications=new CustomerNotifications();
        customerNotifications.setCustNotiId(customerNotificationsPojo.getCustNotiId());
        customerNotifications.setFromRegno(customerNotificationsPojo.getFromRegno());
        customerNotifications.setToRegno(customerNotificationsPojo.getToRegno());
        customerNotifications.setStatus(customerNotificationsPojo.getStatus());
        customerNotifications.setTimestamp(customerNotificationsPojo.getTimestamp());
        customerNotifications.setTypeDoc(customerNotificationsPojo.getTypeDoc());
        customerNotifications.setUserId(customerNotificationsPojo.getUserId());
        customerNotifications.setNotificationId(Long.parseLong(customerNotificationsPojo.getOrderId()));
        customerNotifications.setToCompname(customerNotificationsPojo.getToCompname());
        customerNotifications.setToEmail(customerNotificationsPojo.getToEmail());
        customerNotifications.setContact(customerNotificationsPojo.getContact());
        customerNotifications.setAddress(customerNotificationsPojo.getAddress());
        customerNotifications.setFromCompname(customerNotificationsPojo.getFromCompname());
        customerNotifications.setFromEmail(customerNotificationsPojo.getFromEmail());
        customerNotifications.setFromContact(customerNotificationsPojo.getFromContact());
        customerNotifications.setFromAddress(customerNotificationsPojo.getFromAddress());
        customerNotifications.setTypeFlag(customerNotificationsPojo.getTypeFlag());
        customerNotifications.setViewStatus(customerNotificationsPojo.getViewStatus());
        customerNotifications.setGstIn(customerNotificationsPojo.getGstIn());
        customerNotifications.setState(customerNotificationsPojo.getState());
        customerNotifications.setCountry(customerNotificationsPojo.getCountry());
        customerNotifications.setCurrency(customerNotificationsPojo.getCurrency());
        customerNotifications.setObjectdata(customerNotificationsPojo.getObjectdata());
        customerNotifications.setPiNo(customerNotificationsPojo.getPiNo());
        customerNotifications.setTotaltax(customerNotificationsPojo.getTotaltax());
        customerNotifications.setTotalcheckoutamt(customerNotificationsPojo.getTotalcheckoutamt());
        customerNotifications.setTransactionId(customerNotificationsPojo.getTransactionId());
        customerNotifications.setSiNo(customerNotificationsPojo.getSiNo());
        customerNotifications.setDestinationmap(customerNotificationsPojo.getDestinationmap());
        customerNotifications.setCompleteData(customerNotificationsPojo.getCompleteData());
        customerNotifications.setCustomerNotification(customerNotificationsPojo.getCustomerNotification());
        customerNotifications.setRestaurantId(customerNotificationsPojo.getRestaurantId());
        customerNotifications.setRestaurantName(customerNotificationsPojo.getRestaurantName());
        return customerNotifications;
    }

    public static List<CustomerNotificationsPojo> mapEntityToPojo(List<CustomerNotifications> customerNotifications){
        List<CustomerNotificationsPojo> list=new ArrayList<>();
        for(CustomerNotifications customerNotifications1:customerNotifications) {
            CustomerNotificationsPojo customerNotificationsPojo = new CustomerNotificationsPojo();
            customerNotificationsPojo.setCustNotiId(customerNotifications1.getCustNotiId());
            customerNotificationsPojo.setFromRegno(customerNotifications1.getFromRegno());
            customerNotificationsPojo.setToRegno(customerNotifications1.getToRegno());
            customerNotificationsPojo.setStatus(customerNotifications1.getStatus());
            customerNotificationsPojo.setTimestamp(customerNotifications1.getTimestamp());
            customerNotificationsPojo.setTypeDoc(customerNotifications1.getTypeDoc());
            customerNotificationsPojo.setUserId(customerNotifications1.getUserId());
            customerNotificationsPojo.setNotificationId(customerNotifications1.getNotificationId());
            customerNotificationsPojo.setToCompname(customerNotifications1.getToCompname());
            customerNotificationsPojo.setToEmail(customerNotifications1.getToEmail());
            customerNotificationsPojo.setContact(customerNotifications1.getContact());
            customerNotificationsPojo.setAddress(customerNotifications1.getAddress());
            customerNotificationsPojo.setFromCompname(customerNotifications1.getFromCompname());
            customerNotificationsPojo.setFromEmail(customerNotifications1.getFromEmail());
            customerNotificationsPojo.setFromContact(customerNotifications1.getFromContact());
            customerNotificationsPojo.setFromAddress(customerNotifications1.getFromAddress());
            customerNotificationsPojo.setTypeFlag(customerNotifications1.getTypeFlag());
            customerNotificationsPojo.setViewStatus(customerNotifications1.getViewStatus());
            customerNotificationsPojo.setGstIn(customerNotifications1.getGstIn());
            customerNotificationsPojo.setState(customerNotifications1.getState());
            customerNotificationsPojo.setCountry(customerNotifications1.getCountry());
            customerNotificationsPojo.setCurrency(customerNotifications1.getCurrency());
            customerNotificationsPojo.setObjectdata(customerNotifications1.getObjectdata());
            customerNotificationsPojo.setPiNo(customerNotifications1.getPiNo());
            customerNotificationsPojo.setTotaltax(customerNotifications1.getTotaltax());
            customerNotificationsPojo.setTotalcheckoutamt(customerNotifications1.getTotalcheckoutamt());
            customerNotificationsPojo.setTransactionId(customerNotifications1.getTransactionId());
            customerNotificationsPojo.setSiNo(customerNotifications1.getSiNo());
            customerNotificationsPojo.setDestinationmap(customerNotifications1.getDestinationmap());
            customerNotificationsPojo.setCompleteData(customerNotifications1.getCompleteData());
            customerNotificationsPojo.setCustomerNotification(customerNotifications1.getCustomerNotification());
            customerNotificationsPojo.setRestaurantId(customerNotifications1.getRestaurantId());
            customerNotificationsPojo.setRestaurantName(customerNotifications1.getRestaurantName());
            list.add(customerNotificationsPojo);
        }
        return list;
    }
}
