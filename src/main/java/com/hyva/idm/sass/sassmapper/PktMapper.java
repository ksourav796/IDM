package com.hyva.idm.sass.sassmapper;

import com.hyva.idm.sass.sassentities.PktPermission;
import com.hyva.idm.sass.sasspojo.PktPermissionPojo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by krishna.
 */
public class PktMapper {

    public static PktPermission mapPktPermissionPojoToEnity(PktPermissionPojo pktPermissionPojo){
        PktPermission pktPermission  = new PktPermission();
        pktPermission.setPktPermissionId(pktPermissionPojo.getPktPermissionId());
        pktPermission.setKeyAction(pktPermissionPojo.getKeyAction());
        pktPermission.setKeyGroup(pktPermissionPojo.getKeyGroup());
        pktPermission.setKeyName(pktPermissionPojo.getKeyName());
        pktPermission.setKeyPlaceHolder(pktPermissionPojo.getKeyPlaceHolder());
        pktPermission.setKeyPriority(pktPermissionPojo.getKeyPriority());
        pktPermission.setKeyVisibility(pktPermissionPojo.getKeyVisibility());
        pktPermission.setKeySubscription(pktPermissionPojo.getKeySubscription());
        pktPermission.setKeyValidation(pktPermissionPojo.getKeyValidation());
        pktPermission.setKeyTiming(pktPermissionPojo.getKeyTiming());
        pktPermission.setKeyValue(pktPermissionPojo.getKeyValue());
        pktPermission.setKeyReference(pktPermissionPojo.getKeyReference());
        pktPermission.setKeyGroup(pktPermissionPojo.getKeyGroup());
        pktPermission.setSync(pktPermissionPojo.getSync());
        pktPermission.setPermission(pktPermissionPojo.getPermission());
        pktPermission.setDescriptor(pktPermissionPojo.getDescriptor());
        pktPermission.setStatus(pktPermissionPojo.getStatus());
        pktPermission.setColumnPosition(pktPermissionPojo.getColumnPosition());
        pktPermission.setColumnName(pktPermissionPojo.getColumnName());
        pktPermission.setOperation(pktPermissionPojo.getOperation());
        pktPermission.setRoundOff(pktPermissionPojo.getRoundOff());
        pktPermission.setOperator(pktPermissionPojo.getOperator());
        pktPermission.setTableName(pktPermissionPojo.getTableName());
        pktPermission.setInputType(pktPermissionPojo.getInputType());
        return  pktPermission;
    }

    public static List<PktPermissionPojo> mapEntityToPojo(List<PktPermission> pkt){
        List<PktPermissionPojo> list=new ArrayList<>();
        for(PktPermission pktper:pkt) {
            PktPermissionPojo pojo=new PktPermissionPojo();
            pojo.setPktPermissionId(pktper.getPktPermissionId());
            pojo.setKeyAction(pktper.getKeyAction());
            pojo.setKeyGroup(pktper.getKeyGroup());
            pojo.setKeyName(pktper.getKeyName());
            pojo.setKeyPlaceHolder(pktper.getKeyPlaceHolder());
            pojo.setKeyPriority(pktper.getKeyPriority());
            pojo.setKeyVisibility(pktper.getKeyVisibility());
            pojo.setKeySubscription(pktper.getKeySubscription());
            pojo.setKeyValidation(pktper.getKeyValidation());
            pojo.setKeyTiming(pktper.getKeyTiming());
            pojo.setKeyValue(pktper.getKeyValue());
            pojo.setKeyReference(pktper.getKeyReference());
            pojo.setKeyGroup(pktper.getKeyGroup());
            pojo.setSync(pktper.getSync());
            pojo.setPermission(pktper.getPermission());
            pojo.setDescriptor(pktper.getDescriptor());
            pojo.setStatus(pktper.getStatus());
            pojo.setColumnPosition(pktper.getColumnPosition());
            pojo.setColumnName(pktper.getColumnName());
            pojo.setOperation(pktper.getOperation());
            pojo.setRoundOff(pktper.getRoundOff());
            pojo.setOperator(pktper.getOperator());
            pojo.setTableName(pktper.getTableName());
            list.add(pojo);

        }
            return list;
        }



}
