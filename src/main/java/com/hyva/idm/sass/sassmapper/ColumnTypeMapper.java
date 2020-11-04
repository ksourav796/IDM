package com.hyva.idm.sass.sassmapper;

import com.hyva.idm.sass.sassentities.ColumnType;
import com.hyva.idm.sass.sassentities.Permission;
import com.hyva.idm.sass.sasspojo.ColumnTypePojo;
import com.hyva.idm.sass.sasspojo.PermissionPojo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class ColumnTypeMapper {

    public static ColumnType mapColumnTypePojoToEntity(ColumnTypePojo columnTypePojo) {

        ColumnType columnType = new ColumnType();
        if(columnTypePojo.getId()!=null)
        columnType.setId(columnTypePojo.getId());
        columnType.setName(columnTypePojo.getName());
        columnType.setDescription(columnTypePojo.getDescription());
        columnType.setStatus(columnTypePojo.getStatus());
        return columnType;
    }


    public static List<ColumnTypePojo> mapColumnTypeEntityToPojo(List<ColumnType> columnTypeList) {
        List<ColumnTypePojo> permissionPojos = new ArrayList<>();
        for (ColumnType columnType : columnTypeList) {
            ColumnTypePojo columnTypePojo = new ColumnTypePojo();
            columnTypePojo.setId(columnType.getId());
            columnTypePojo.setName(columnType.getName());
            columnTypePojo.setDescription(columnType.getDescription());
            columnTypePojo.setStatus(columnType.getStatus());
            permissionPojos.add(columnTypePojo);

        }
        return permissionPojos;
    }
}
