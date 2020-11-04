package com.hyva.idm.sass.sassservice;


import com.hyva.idm.icitem.IcItem;
import com.hyva.idm.sass.sassentities.CustomerNotifications;
import com.hyva.idm.sass.sassentities.TransactionsData;
import com.hyva.idm.sass.sassmapper.CustomerNotificationMapper;
import com.hyva.idm.sass.sassmapper.SaasTransactionsDataMapper;
import com.hyva.idm.sass.sasspojo.CustomerNotificationsPojo;
import com.hyva.idm.sass.sasspojo.TransactionsDataPojo;
import com.hyva.idm.sass.sassrespositories.SaasTranscationsDataRepository;

import com.hyva.idm.sass.sassrespositories.SassCustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component

public class SaasTranscationsDataService {

    @Autowired
    SaasTranscationsDataRepository saasTranscationsDataRepository;

    public TransactionsData getSalesInvoiceSave(TransactionsDataPojo transactionsDataPojo){
        TransactionsData transactionsData = SaasTransactionsDataMapper.mapPojoToEntity(transactionsDataPojo);


        transactionsData= saasTranscationsDataRepository.save(transactionsData);
        return transactionsData;


    }

//    public CustomerNotifications getSalesQuotationSave(CustomerNotificationsPojo customerNotificationsPojo){
//        CustomerNotifications customerNotifications = CustomerNotificationMapper.mapPojoToEntity(customerNotificationsPojo);
//
//
//        SassCustomerRepository.save(customerNotifications);
//        return customerNotifications;
//
//
//    }
    public TransactionsData getPurchaseOrderSave(TransactionsDataPojo transactionsDataPojo){
        TransactionsData transactionsData1 = SaasTransactionsDataMapper.mapPojoToEntity(transactionsDataPojo);


        transactionsData1= saasTranscationsDataRepository.save(transactionsData1);
        return transactionsData1;


    }

    public void getPurchaseInvoiceSave(CustomerNotifications customerNotifications) {
        saasTranscationsDataRepository.save(customerNotifications);

    }
    public  void getCustomerPaymentSave(CustomerNotifications customerNotifications){
        saasTranscationsDataRepository.save(customerNotifications);
    }

    public void getSupplierPaymentSave(CustomerNotifications customerNotifications){
        saasTranscationsDataRepository.save(customerNotifications);

    }
    public void getDebitNoteSave(CustomerNotifications customerNotifications){
        saasTranscationsDataRepository.save(customerNotifications);
    }
    public void getCreditNoteSave(CustomerNotifications customerNotifications ){
        saasTranscationsDataRepository.save(customerNotifications);

    }
    public void getPurchaseInvoiceSave(TransactionsData transactionsData){
        saasTranscationsDataRepository.save(transactionsData);
    }

    public void getPurchaseQuotationSave(CustomerNotifications customerNotifications){
        saasTranscationsDataRepository.save(customerNotifications);
    }

    public void getSalesOrderSave(CustomerNotifications customerNotifications){
        saasTranscationsDataRepository.save(customerNotifications);
    }

    public void getPurchaseCreditNoteSave(TransactionsData transactionsData){
        saasTranscationsDataRepository.save(transactionsData);
    }

    public TransactionsData getPurchaseRRI(TransactionsDataPojo transactionsDataPojo){
        TransactionsData transactionsData1 = SaasTransactionsDataMapper.mapPojoToEntity(transactionsDataPojo);


        transactionsData1= saasTranscationsDataRepository.save(transactionsData1);
        return transactionsData1;

    }

    public void getSalesDeliveryReturnSave(TransactionsData transactionsData){
        saasTranscationsDataRepository.save(transactionsData);
    }

    public TransactionsData getSalesDOSave(TransactionsDataPojo transactionsDataPojo){
        TransactionsData transactionsData = SaasTransactionsDataMapper.mapPojoToEntity(transactionsDataPojo);


        transactionsData= saasTranscationsDataRepository.save(transactionsData);
        return transactionsData;


    }

    public TransactionsData getSalesDNSave(TransactionsDataPojo transactionsDataPojo){
        TransactionsData transactionsData = SaasTransactionsDataMapper.mapPojoToEntity(transactionsDataPojo);


        transactionsData= saasTranscationsDataRepository.save(transactionsData);
        return transactionsData;


    }

    public void getPurchaseReceiveItemSave(CustomerNotifications customerNotifications){
        saasTranscationsDataRepository.save(customerNotifications);
    }







}
