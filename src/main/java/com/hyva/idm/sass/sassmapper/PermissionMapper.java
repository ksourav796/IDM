package com.hyva.idm.sass.sassmapper;

import com.hyva.idm.sass.sassentities.Permission;
import com.hyva.idm.sass.sasspojo.PermissionPojo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class PermissionMapper {
    public static Permission mapPermissionPojoToEntity(PermissionPojo permissionPojo){

        Permission permission = new Permission();
        permission.setPermissionId(permissionPojo.getPermissionId());
        permission.setName(permissionPojo.getName());
        permission.setDescription(permissionPojo.getDescription());
        permission.setStatus(permissionPojo.getStatus());
        return  permission;
    }



    public static List<PermissionPojo> mapPermissionEntityToPojo(List<Permission> permissionList){
        List<PermissionPojo> permissionPojos = new ArrayList<>();
        for (Permission permission:permissionList) {
            PermissionPojo permissionPojo = new PermissionPojo();
            permissionPojo.setPermissionId(permission.getPermissionId());
            permissionPojo.setName(permission.getName());
            permissionPojo.setDescription(permission.getDescription());
            permissionPojo.setStatus(permission.getStatus());
            permissionPojos.add(permissionPojo);

        }
        return  permissionPojos;
    }


}
