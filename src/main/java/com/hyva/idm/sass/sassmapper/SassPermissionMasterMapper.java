package com.hyva.idm.sass.sassmapper;

import com.hyva.idm.sass.sassentities.PermissionGroup;
import com.hyva.idm.sass.sassentities.PermissionMaster;
import com.hyva.idm.sass.sassentities.SassOrders;
import com.hyva.idm.sass.sasspojo.PermissionMasterDTO;
import com.hyva.idm.sass.sasspojo.SassOrdersPojo;
import com.hyva.idm.sass.sasspojo.SassPermissionMasterPojo;

public class SassPermissionMasterMapper {

    public static PermissionMaster mapPojoToEntity(PermissionMasterDTO permissionMasterDTO){
        PermissionMaster permissionMaster=new PermissionMaster();
        permissionMaster.setDescription(permissionMasterDTO.getDescription());
        permissionMaster.setSaasStatus(permissionMasterDTO.getSaasStatus());
        permissionMaster.setPermissionMasterkey(permissionMasterDTO.getPermissionMasterkey());
//        permissionMaster.setParentPM(new PermissionMaster(permissionMasterDTO.getPermId()));
//        permissionMaster.setParentPM(new PermissionMaster(permissionMasterDTO.getPerm3()));
//




//        permissionMaster.setPermissionGroupId(permissionMasterDTO.getPgId());




//        SassPermissionMasterMapper sassPermissionMasterMapper=new SassPermissionMasterMapper();

        return permissionMaster;
    }

//    public static SassPermissionMasterPojo mapEntityToPojo(SassOrders sassOrders){
//        SassPermissionMasterPojo sassPermissionMasterPojo=new SassPermissionMasterPojo();
//
//        return sassPermissionMasterPojo;
//
//    }
}
