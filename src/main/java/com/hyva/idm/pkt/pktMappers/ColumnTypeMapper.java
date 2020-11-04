package com.hyva.idm.pkt.pktMappers;

import com.hyva.idm.pkt.pktBeans.ColumnTypeBean;
import com.hyva.idm.pkt.pktRelations.ColumnTypes;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * krishna
 */
@Component
public class ColumnTypeMapper {
    public static ColumnTypes mapColumnTypePojoToEntity(ColumnTypeBean columnTypePojo) {

        ColumnTypes columnType = new ColumnTypes();

        if(columnTypePojo.getId()!=null){
            columnType.setId(columnTypePojo.getId());
        }
        columnType.setName(columnTypePojo.getName());
        columnType.setDescription(columnTypePojo.getDescription());
        columnType.setStatus(columnTypePojo.getStatus());
        return columnType;
    }


    public static List<ColumnTypeBean> mapColumnTypeEntityToPojo(List<ColumnTypes> columnTypeList) {
        List<ColumnTypeBean> permissionPojos = new ArrayList<>();
        for (ColumnTypes columnType : columnTypeList) {
            ColumnTypeBean columnTypePojo = new ColumnTypeBean();
            columnTypePojo.setId(columnType.getId());
            columnTypePojo.setName(columnType.getName());
            columnTypePojo.setDescription(columnType.getDescription());
            columnTypePojo.setStatus(columnType.getStatus());
            permissionPojos.add(columnTypePojo);

        }
        return permissionPojos;
    }
}
