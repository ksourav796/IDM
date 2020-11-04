package com.hyva.idm.sass.sassservice;

import com.hyva.idm.sass.sassentities.CustomerNotifications;
import com.hyva.idm.sass.sassentities.SassCompany;
import com.hyva.idm.sass.sassmapper.CustomerNotificationMapper;
import com.hyva.idm.sass.sasspojo.CustomerNotificationsPojo;
import com.hyva.idm.sass.sassrespositories.SassCustomerNotificationsRepository;
import com.hyva.idm.sass.sassutil.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SassCustomerNotificationsService {
    @Autowired
    SassCustomerNotificationsRepository sassCustomerNotificationsRepository;

    public CustomerNotifications getCustomerNotificationSave(CustomerNotificationsPojo customerNotificationsPojo, List<SassCompany> toreglist, List<SassCompany> fromreglist) {
        if((toreglist.size()>0 || fromreglist.size()>0) && (toreglist!=null || fromreglist!=null) ) {
            if(fromreglist.get(0).getCustomerAddress()!=null)
                customerNotificationsPojo.setFromAddress(fromreglist.get(0).getCustomerAddress());
            if(toreglist.get(0).getCompanyEmail()!=null)
                customerNotificationsPojo.setToEmail(toreglist.get(0).getCompanyEmail());
            if(toreglist.get(0).getCustomerName()!=null)
                customerNotificationsPojo.setToCompname(toreglist.get(0).getCustomerName());
            if(fromreglist.get(0).getCustomerName()!=null)
                customerNotificationsPojo.setFromCompname(fromreglist.get(0).getCustomerName());
            if(fromreglist.get(0).getCustomerNumber()!=null)
                customerNotificationsPojo.setFromContact(fromreglist.get(0).getCustomerNumber());
            if(fromreglist.get(0).getCompanyEmail()!=null)
                customerNotificationsPojo.setFromEmail(fromreglist.get(0).getCompanyEmail());
        }
//        customerNotificationsPojo.set
        CustomerNotifications customerNotifications = CustomerNotificationMapper.mapPojoToEntity(customerNotificationsPojo);
        customerNotifications = sassCustomerNotificationsRepository.save(customerNotifications);
        return customerNotifications;
    }

    public List<CustomerNotifications> getCustomerRegNo(String fromRegno,String status){
        List<CustomerNotifications> order =sassCustomerNotificationsRepository.findByTypeFlagOrTypeFlagOrTypeFlagAndToRegnoAndStatus("Purchase","Restaurant","Sales",fromRegno,status);
        return order;
    }
    public List<CustomerNotifications> getCustomerReg(String fromRegno,String status){
        List<CustomerNotifications> order =sassCustomerNotificationsRepository.findByTypeFlagAndToRegnoAndStatus("Restaurant",fromRegno,status);
        return order;
    }
    public List<String> getList(){
        List<String> order = sassCustomerNotificationsRepository.findDistinctByRestaurantName();
        return order;
    }
    public CustomerNotifications getSalesQuotationSave(CustomerNotificationsPojo customerNotificationsPojo){
        CustomerNotifications customerNotifications = CustomerNotificationMapper.mapPojoToEntity(customerNotificationsPojo);
        customerNotifications = sassCustomerNotificationsRepository.save(customerNotifications);
        return customerNotifications;

    }
    public CustomerNotifications getPurchaseOrderSave(CustomerNotificationsPojo customerNotificationsPojo){
        CustomerNotifications customerNotifications = CustomerNotificationMapper.mapPojoToEntity(customerNotificationsPojo);
        customerNotifications = sassCustomerNotificationsRepository.save(customerNotifications);
        return customerNotifications;

    }
    public CustomerNotifications getSalesDOSave(CustomerNotificationsPojo customerNotificationsPojo){
        CustomerNotifications customerNotifications = CustomerNotificationMapper.mapPojoToEntity(customerNotificationsPojo);
        customerNotifications = sassCustomerNotificationsRepository.save(customerNotifications);
        return customerNotifications;

    }
//    public CustomerNotifications getSupplierPaymentSave(CustomerNotificationsPojo customerNotificationsPojo){
//        CustomerNotifications customerNotifications = CustomerNotificationMapper.mapPojoToEntity(customerNotificationsPojo);
//        customerNotifications = sassCustomerNotificationsRepository.save(customerNotifications);
//        return customerNotifications;
//
//    }
    public CustomerNotifications getPurchaseQuotationSave(CustomerNotificationsPojo customerNotificationsPojo){
        CustomerNotifications customerNotifications = CustomerNotificationMapper.mapPojoToEntity(customerNotificationsPojo);
        customerNotifications = sassCustomerNotificationsRepository.save(customerNotifications);
        return customerNotifications;

    }
    public CustomerNotifications getPurchaseReceiveItemSave(CustomerNotificationsPojo customerNotificationsPojo){
        CustomerNotifications customerNotifications = CustomerNotificationMapper.mapPojoToEntity(customerNotificationsPojo);
        customerNotifications = sassCustomerNotificationsRepository.save(customerNotifications);
        return customerNotifications;

    }
    public CustomerNotifications getSalesOrderSave(CustomerNotificationsPojo customerNotificationsPojo){
        CustomerNotifications customerNotifications = CustomerNotificationMapper.mapPojoToEntity(customerNotificationsPojo);
        customerNotifications = sassCustomerNotificationsRepository.save(customerNotifications);
        return customerNotifications;

    }
    public CustomerNotifications getZomatoSave(CustomerNotificationsPojo customerNotificationsPojo){
        CustomerNotifications customerNotifications = CustomerNotificationMapper.mapPojoToEntity(customerNotificationsPojo);
        customerNotifications = sassCustomerNotificationsRepository.save(customerNotifications);
        return customerNotifications;
    }
    public CustomerNotifications getPurchaseInvoiceSave(CustomerNotificationsPojo customerNotificationsPojo){
        CustomerNotifications customerNotifications = CustomerNotificationMapper.mapPojoToEntity(customerNotificationsPojo);
        customerNotifications = sassCustomerNotificationsRepository.save(customerNotifications);
        return customerNotifications;

    }
    public CustomerNotifications getCustomerPaymentSave(CustomerNotificationsPojo customerNotificationsPojo){
        CustomerNotifications customerNotifications = CustomerNotificationMapper.mapPojoToEntity(customerNotificationsPojo);
        customerNotifications = sassCustomerNotificationsRepository.save(customerNotifications);
        return customerNotifications;

    }
    public CustomerNotifications getSupplierPaymentSave(CustomerNotificationsPojo customerNotificationsPojo){
        CustomerNotifications customerNotifications = CustomerNotificationMapper.mapPojoToEntity(customerNotificationsPojo);
        customerNotifications = sassCustomerNotificationsRepository.save(customerNotifications);
        return customerNotifications;

    }
    public CustomerNotifications getSalesDNSave(CustomerNotificationsPojo customerNotificationsPojo){
        CustomerNotifications customerNotifications = CustomerNotificationMapper.mapPojoToEntity(customerNotificationsPojo);
        customerNotifications = sassCustomerNotificationsRepository.save(customerNotifications);
        return customerNotifications;

    }
    public CustomerNotifications getPurchaseCreditNoteSave(CustomerNotificationsPojo customerNotificationsPojo){
        CustomerNotifications customerNotifications = CustomerNotificationMapper.mapPojoToEntity(customerNotificationsPojo);
        customerNotifications = sassCustomerNotificationsRepository.save(customerNotifications);
        return customerNotifications;

    }
    public CustomerNotifications getPurchaseRRI(CustomerNotificationsPojo customerNotificationsPojo){
        CustomerNotifications customerNotifications = CustomerNotificationMapper.mapPojoToEntity(customerNotificationsPojo);
        customerNotifications = sassCustomerNotificationsRepository.save(customerNotifications);
        return customerNotifications;

    }
    public CustomerNotifications getSalesDeliveryReturnSave(CustomerNotificationsPojo customerNotificationsPojo){
        CustomerNotifications customerNotifications = CustomerNotificationMapper.mapPojoToEntity(customerNotificationsPojo);
        customerNotifications = sassCustomerNotificationsRepository.save(customerNotifications);
        return customerNotifications;

    }
    public CustomerNotifications getDebitNoteSave(CustomerNotificationsPojo customerNotificationsPojo){
        CustomerNotifications customerNotifications = CustomerNotificationMapper.mapPojoToEntity(customerNotificationsPojo);
        customerNotifications = sassCustomerNotificationsRepository.save(customerNotifications);
        return customerNotifications;

    }
    public CustomerNotifications getCreditNoteSave(CustomerNotificationsPojo customerNotificationsPojo){
        CustomerNotifications customerNotifications = CustomerNotificationMapper.mapPojoToEntity(customerNotificationsPojo);
        customerNotifications = sassCustomerNotificationsRepository.save(customerNotifications);
        return customerNotifications;

    }
    public CustomerNotifications getSalesInvoiceSave(CustomerNotificationsPojo customerNotificationsPojo){
        CustomerNotifications customerNotifications = CustomerNotificationMapper.mapPojoToEntity(customerNotificationsPojo);
        customerNotifications = sassCustomerNotificationsRepository.save(customerNotifications);
        return customerNotifications;

    }

    public List<CustomerNotifications> getStatus(String fromRegno){
        List<CustomerNotifications> gettingstatus =sassCustomerNotificationsRepository.findByToRegno(fromRegno);
        return gettingstatus;
    }

    public List<CustomerNotifications> getSubscriptionType(String fromRegno ,String subscriptionType){
        List<CustomerNotifications> gettingstatus =sassCustomerNotificationsRepository.findByFromRegnoAndSubscriptionTypeAndViewStatus(fromRegno,subscriptionType,"pending");
        return gettingstatus;
    }

    public CustomerNotifications getRTRTransactionsUpdate(String fromRegNo,String toRegNo,String typeDoc){
        CustomerNotifications gettingstatus =sassCustomerNotificationsRepository.findByFromRegnoAndToRegnoAndTypeDoc(fromRegNo,toRegNo,typeDoc);
        return gettingstatus;
    }
    public CustomerNotifications getUpdateRTRviewStatus(String custNotiId){
        CustomerNotifications gettingstatus =sassCustomerNotificationsRepository.findOne(Long.parseLong(custNotiId));
        return gettingstatus;
    }
}
