package com.hyva.idm.pkt.pktMappers;

import com.hyva.idm.pkt.pktBeans.PktBuilderBean;
import com.hyva.idm.pkt.pktRelations.PktBuilder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * krishna
 */
@Component
public class PktBuilderMapper {
    public static PktBuilder mapPktBuilderBeanToEntity(PktBuilderBean pktBuilderBean){
        PktBuilder pktBuilder = new PktBuilder();
        pktBuilder.setPktBuilderId(pktBuilderBean.getPktBuilderId());
        pktBuilder.setApplicationName(pktBuilderBean.getApplicationName());
        pktBuilder.setFooterValue(pktBuilderBean.getFooterValue());
        pktBuilder.setHeaderValue(pktBuilderBean.getHeaderValue());
        pktBuilder.setBuilderValue(pktBuilderBean.getBuilderValue());
        pktBuilder.setStatus("Active");
        return pktBuilder;
    }
    public static List<PktBuilderBean> mapPktEntityToBuilderBean(List<PktBuilder> pktBuilderBean){
        List<PktBuilderBean>  pktBuilderBeanList = new ArrayList<>();
        for (PktBuilder pktBuilderBean1:pktBuilderBean) {
            PktBuilderBean pktBuilderBean2 = new PktBuilderBean();
            pktBuilderBean2.setApplicationName(pktBuilderBean1.getApplicationName());
            pktBuilderBean2.setPktBuilderId(pktBuilderBean1.getPktBuilderId());
            pktBuilderBean2.setStatus(pktBuilderBean1.getStatus());
            pktBuilderBeanList.add(pktBuilderBean2);
        }
        return pktBuilderBeanList;
    }
}
