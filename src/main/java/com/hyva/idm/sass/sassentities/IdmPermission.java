package com.hyva.idm.sass.sassentities;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 *
 */

@Entity
@Data
public class IdmPermission {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long idmpermissionId;
    private boolean orderList;
    private boolean paymentList;
    private boolean controlPannel;
    private boolean currency;
    private boolean paymentMethod;
    private boolean country;
    private boolean state;
    private boolean versionControl;
    private boolean subscription;
    private boolean packages;
    private boolean practitionerRegistration;
    private boolean practitionerOrders;
    private boolean customer;
    private boolean addOn;
    private boolean item;
    private boolean cartRegistration;
    private boolean user;
    private boolean cartCustomer;
    private boolean rtrSyncSettings;
    private boolean hiconnect;
    private boolean customerNotification;
    private boolean transactionsData;
    private boolean destinationType;
    private boolean destinationMap;
    private boolean email;
    private boolean permissionMaster;
    private boolean permissionGroup;
    private boolean pkt;
    private boolean tableValue;
    private boolean tableColoumMapping;
    private boolean validator;
    private boolean operator;
    private boolean action;
    private boolean Permission;
    private boolean columnType;
    private boolean columnPosition;
    private boolean pktFeilds;
    private boolean addNewTable;
    private boolean application;
    private Long userId;

}
