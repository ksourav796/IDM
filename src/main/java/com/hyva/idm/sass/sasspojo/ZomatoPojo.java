package com.hyva.idm.sass.sasspojo;

import lombok.Data;

@Data
public class ZomatoPojo {

    private Long custNotiId;
    private Long orderId;
    private Long externalOrderId;
    private String rejectionMessageId;
    private String status;
    private String deliveryTime;
    private String prepareTime;
    private String riderName;
    private String riderPhoneNo;
    private String vendorRejectionMessage;
    private String customerArrivalTime;
}
