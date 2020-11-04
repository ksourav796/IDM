package com.hyva.idm.pkt.pktMappers;

import com.hyva.idm.pkt.pktBeans.PktFieldsBean;
import com.hyva.idm.pkt.pktRelations.PktFields;
import com.hyva.idm.sass.sasspojo.PktFieldsPojo;
import org.springframework.stereotype.Component;

/**
 * krishna
 */
@Component
public class PktFieldsMapper {
    public static PktFields mapPktFieldPojoToEnity(PktFieldsBean pktFieldsPojo){
        PktFields pktFields  = new PktFields();
        pktFields.setId(pktFieldsPojo.getId());
        pktFields.setTableName(pktFieldsPojo.getTableName());
        pktFields.setFieldName(pktFieldsPojo.getFieldName());
        pktFields.setGroupOf(pktFieldsPojo.getGroupOf());
        pktFields.setStatus(pktFieldsPojo.getStatus());
        return  pktFields;
    }
}
