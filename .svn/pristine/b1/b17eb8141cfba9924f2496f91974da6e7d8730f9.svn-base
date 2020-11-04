package com.hyva.idm.sass.kafka;
import com.hyva.idm.sass.sassendpoints.HiConnectEndPoint;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {
    private static final Logger log = LoggerFactory.getLogger(KafkaConsumer.class);
    @Autowired
    HiConnectEndPoint hiConnectEndPoint;
    @Autowired
    MessageStorage storage;
    @KafkaListener(topics="${jsa.kafka.topic}")
    public void processMessage(String content) throws JSONException {
        log.info("received content = '{}'", content);
        JSONObject jsonObj = new JSONObject(content);
        if(jsonObj.getString("typeFlag").equalsIgnoreCase("AddMaster") || jsonObj.getString("typeFlag").equalsIgnoreCase("EditMaster")){
            hiConnectEndPoint.BroadCastMasterData(jsonObj.toString());
        }
        if(jsonObj.getString("typeFlag").equalsIgnoreCase("purchase")){
            hiConnectEndPoint.BroadCastTransactionData(jsonObj.toString());
        }
        if(jsonObj.getString("typeFlag").equalsIgnoreCase("sales")){
            hiConnectEndPoint.BroadCastTransactionData(jsonObj.toString());
        }


//        if(jsonObj.getString("typeDoc").equalsIgnoreCase("SR")){
//            hiConnectEndPoint.setHiConnectNotificationsCompany(jsonObj.toString());
//        }
//        if(jsonObj.getString("typeDoc").equalsIgnoreCase("PI")){
//            hiConnectEndPoint.BroadCastPostPurchaseInvoiceData(jsonObj.toString());
//        }
//        if(jsonObj.getString("typeDoc").equalsIgnoreCase("PQ")){
//            hiConnectEndPoint.BroadCastPostPurchaseQuotationData(jsonObj.toString());
//        }
//        if(jsonObj.getString("typeDoc").equalsIgnoreCase("SDR")){
//            hiConnectEndPoint.BroadCastPostSalesDeliveryReturnData(jsonObj.toString());
//        }
//        if(jsonObj.getString("typeDoc").equalsIgnoreCase("RI")){
//            hiConnectEndPoint.BroadCastPostReceiveItemData(jsonObj.toString());
//        }
//        if(jsonObj.getString("typeDoc").equalsIgnoreCase("PCN")){
//            hiConnectEndPoint.BroadCastPostPurchaseCreditData(jsonObj.toString());
//        }
//        if(jsonObj.getString("typeDoc").equalsIgnoreCase("SO")){
//            hiConnectEndPoint.BroadCastPostSalesOrderData(jsonObj.toString());
//        }
//        if(jsonObj.getString("typeDoc").equalsIgnoreCase("PO")){
//            hiConnectEndPoint.BroadCastPostPurchaseOrderData(jsonObj.toString());
//        }
//        if(jsonObj.getString("typeDoc").equalsIgnoreCase("SQ")){
//            hiConnectEndPoint.BroadCastPostSalesQuotationData(jsonObj.toString());
//        }
//        if(jsonObj.getString("typeDoc").equalsIgnoreCase("CP")){
//            hiConnectEndPoint.BroadCastPostCustomerPaymentData(jsonObj.toString());
//        }
//        if(jsonObj.getString("typeDoc").equalsIgnoreCase("SP")){
//            hiConnectEndPoint.BroadCastPostSupplierPaymentData(jsonObj.toString());
//        }
//        if(jsonObj.getString("typeDoc").equalsIgnoreCase("SDN")){
//            hiConnectEndPoint.BroadCastPostSalesDebitNoteData(jsonObj.toString());
//        }
//        if(jsonObj.getString("typeDoc").equalsIgnoreCase("SIN")){
//            hiConnectEndPoint.BroadCastPostSalesInvoiceData(jsonObj.toString());
//        }
//        if(jsonObj.getString("typeDoc").equalsIgnoreCase("SDO")){
//            hiConnectEndPoint.BroadCastPostSalesDeliveryOrderData(jsonObj.toString());
//        }
//        if(jsonObj.getString("typeDoc").equalsIgnoreCase("SP")){
//            hiConnectEndPoint.BroadCastPostSupplierPaymentData(jsonObj.toString());
//        }

    }

}