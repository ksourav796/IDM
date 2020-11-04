package com.hyva.idm.sass.sassmapper;


import com.hyva.idm.sass.sassentities.IdmPermission;
import com.hyva.idm.sass.sasspojo.IdmPermissionPojo;

import java.util.ArrayList;
import java.util.List;

public class IdmPermissionMapper {

    public  static IdmPermission mapPojoToEntity(IdmPermissionPojo idmPermissionPojo){
        IdmPermission idmPermission=new IdmPermission();
        idmPermission.setIdmpermissionId(idmPermissionPojo.getIdmpermissionId());
        idmPermission.setControlPannel(idmPermissionPojo.getControlPannel());
        idmPermission.setPermission( idmPermissionPojo.getPermission());
        idmPermission.setAddNewTable( idmPermissionPojo.getAddNewTable() );
        idmPermission.setOrderList( idmPermissionPojo.getOrderList() );
        idmPermission.setUser( idmPermissionPojo.getUser() );
        idmPermission.setPaymentList(idmPermissionPojo.getPaymentList());
        idmPermission.setControlPannel(idmPermissionPojo.getControlPannel());
        idmPermission.setCurrency(idmPermissionPojo.getCurrency());
        idmPermission.setPaymentMethod(idmPermissionPojo.getPaymentMethod());
        idmPermission.setCountry(idmPermissionPojo.getCountry());
        idmPermission.setState(idmPermissionPojo.getState());
        idmPermission.setVersionControl(idmPermissionPojo.getVersionControl());
        idmPermission.setSubscription(idmPermissionPojo.getSubscription());
        idmPermission.setPackages(idmPermissionPojo.getPackages());
        idmPermission.setPractitionerRegistration(idmPermissionPojo.getPractitionerRegistration());
        idmPermission.setPractitionerOrders(idmPermissionPojo.getPractitionerOrders());
        idmPermission.setCustomer(idmPermissionPojo.getCustomer());
        idmPermission.setItem(idmPermissionPojo.getItem());
        idmPermission.setAddOn(idmPermissionPojo.getAddOn());
        idmPermission.setCartRegistration(idmPermissionPojo.getCartRegistration());
        idmPermission.setCartCustomer(idmPermissionPojo.getCartCustomer());
        idmPermission.setRtrSyncSettings(idmPermissionPojo.getRtrSyncSettings());
        idmPermission.setHiconnect(idmPermissionPojo.getHiconnect());
        idmPermission.setCustomerNotification(idmPermissionPojo.getCustomerNotification());
        idmPermission.setTransactionsData(idmPermissionPojo.getTransactionsData());
        idmPermission.setDestinationType(idmPermissionPojo.getDestinationType());
        idmPermission.setDestinationMap(idmPermissionPojo.getDestinationMap());
        idmPermission.setEmail(idmPermissionPojo.getEmail());
        idmPermission.setPermissionMaster(idmPermissionPojo.getPermissionMaster());
        idmPermission.setPermissionGroup(idmPermissionPojo.getPermissionGroup());
        idmPermission.setPkt(idmPermissionPojo.getPkt());
        idmPermission.setTableValue(idmPermissionPojo.getTableValue());
        idmPermission.setTableColoumMapping(idmPermissionPojo.getTableColoumMapping());
        idmPermission.setOperator(idmPermissionPojo.getOperator());
        idmPermission.setValidator(idmPermissionPojo.getValidator());
        idmPermission.setAction(idmPermissionPojo.getAction());
        idmPermission.setColumnType(idmPermissionPojo.getColumnType());
        idmPermission.setColumnPosition(idmPermissionPojo.getColumnPosition());
        idmPermission.setPktFeilds(idmPermissionPojo.getPktFeilds());
        idmPermission.setApplication(idmPermissionPojo.getApplication());
        idmPermission.setUserId(idmPermissionPojo.getUserId());
        return  idmPermission;
    }



    public static List<IdmPermissionPojo> mapEntityToPojo(List<IdmPermission> idmPermissionList){
       List<IdmPermissionPojo> idmPermissionPojos = new ArrayList<>();
       for(IdmPermission idmPermission:idmPermissionList){
           IdmPermissionPojo idmPermissionPojo = new IdmPermissionPojo();
           idmPermissionPojo.setIdmpermissionId( idmPermission.getIdmpermissionId());
           idmPermissionPojo.setUserId(idmPermission.getUserId());
           idmPermissionPojo.setUser( idmPermission.isUser());
           idmPermissionPojo.setPermission( idmPermission.isPermission());
           idmPermissionPojo.setAddNewTable( idmPermission.isAddNewTable());
           idmPermissionPojo.setOrderList( idmPermission.isOrderList());
           idmPermissionPojo.setCurrency( idmPermission.isCurrency());
           idmPermissionPojo.setPaymentList( idmPermission.isPaymentList());
           idmPermissionPojo.setControlPannel(idmPermission.isControlPannel());
           idmPermissionPojo.setPaymentMethod(idmPermission.isPaymentMethod()  );
           idmPermissionPojo.setCountry(idmPermission.isCountry()  );
           idmPermissionPojo.setState(idmPermission.isState()  );
           idmPermissionPojo.setVersionControl( idmPermission.isVersionControl() );
           idmPermissionPojo.setSubscription( idmPermission.isSubscription() );
           idmPermissionPojo.setPackages( idmPermission.isPackages() );
           idmPermissionPojo.setPractitionerOrders(idmPermission.isPractitionerOrders()  );
           idmPermissionPojo.setPractitionerRegistration( idmPermission.isPractitionerRegistration() );
           idmPermissionPojo.setCustomer(idmPermission.isCustomer() );
           idmPermissionPojo.setItem(idmPermission.isItem()  );
           idmPermissionPojo.setAddOn( idmPermission.isAddOn() );
           idmPermissionPojo.setCartRegistration( idmPermission.isCartRegistration() );
           idmPermissionPojo.setCartCustomer( idmPermission.isCartCustomer() );
           idmPermissionPojo.setRtrSyncSettings( idmPermission.isRtrSyncSettings() );
           idmPermissionPojo.setHiconnect( idmPermission.isHiconnect() );
           idmPermissionPojo.setCustomerNotification( idmPermission.isCustomerNotification() );
           idmPermissionPojo.setTransactionsData( idmPermission.isTransactionsData() );
           idmPermissionPojo.setDestinationType( idmPermission.isDestinationType() );
           idmPermissionPojo.setDestinationMap( idmPermission.isDestinationMap() );
           idmPermissionPojo.setEmail( idmPermission.isEmail() );
           idmPermissionPojo.setPermissionMaster( idmPermission.isPermissionMaster() );
           idmPermissionPojo.setPermissionGroup( idmPermission.isPermissionGroup() );
           idmPermissionPojo.setPkt( idmPermission.isPkt() );
           idmPermissionPojo.setTableValue( idmPermission.isTableValue() );
           idmPermissionPojo.setTableColoumMapping( idmPermission.isTableColoumMapping() );
           idmPermissionPojo.setOperator( idmPermission.isOperator() );
           idmPermissionPojo.setValidator( idmPermission.isValidator() );
           idmPermissionPojo.setAction( idmPermission.isAction() );
           idmPermissionPojo.setColumnType( idmPermission.isColumnType() );
           idmPermissionPojo.setColumnPosition( idmPermission.isColumnPosition() );
           idmPermissionPojo.setPktFeilds( idmPermission.isPktFeilds() );
           idmPermissionPojo.setApplication( idmPermission.isApplication());
           idmPermissionPojos.add( idmPermissionPojo);
        }
       return idmPermissionPojos;
    }




}
