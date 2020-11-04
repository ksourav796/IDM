package com.hyva.idm.sass.sassmapper;

import com.hyva.idm.sass.sassentities.PermissionGroup;
import com.hyva.idm.sass.sassentities.SassOrders;
import com.hyva.idm.sass.sasspojo.PermissionGroupDTO;
import com.hyva.idm.sass.sasspojo.SassOrdersPojo;
import com.hyva.idm.sass.sasspojo.SassPermissionGroupPojo;

public class SassPermissionGroupMapper {

    public static PermissionGroup mapPojoToEntity(PermissionGroupDTO permissionGroupDTO){

//        SassPermissionGroupMapper sassPermissionGroupMapper=new SassPermissionGroupMapper();
        PermissionGroup permissionGroup=new PermissionGroup();
        permissionGroup.setDescription(permissionGroupDTO.getDescription());
        permissionGroup.setFeatureName(permissionGroupDTO.getFeatureName());
        permissionGroup.setPgkey(permissionGroupDTO.getPgkey());
        permissionGroup.setSaasStatus(permissionGroupDTO.getSaasStatus());


        return permissionGroup;
    }

//    public static SassPermissionGroupPojo mapEntityToPojo(SassOrders sassOrders){
//        SassPermissionGroupPojo sassPermissionGroupPojo=new SassPermissionGroupPojo();
//
//
//        return sassPermissionGroupPojo;
//
//    }
}
