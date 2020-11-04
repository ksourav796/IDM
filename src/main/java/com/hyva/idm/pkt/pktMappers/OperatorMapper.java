package com.hyva.idm.pkt.pktMappers;

import com.hyva.idm.pkt.pktBeans.OperatorBean;
import com.hyva.idm.pkt.pktRelations.Operators;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * krishna
 */
@Component
public class OperatorMapper {

    public static Operators mapOperatorPojoToEnity(OperatorBean operatorpojo){
        Operators operator  = new Operators();
        operator.setId(operatorpojo.getId());
        operator.setName(operatorpojo.getName());
        operator.setDescription(operatorpojo.getDescription());
        operator.setStatus(operatorpojo.getStatus());
        return  operator;
    }

    public static List<OperatorBean> mapOperatorEntityToPojo(List<Operators> operatorList){
        List<OperatorBean> list=new ArrayList<>();
        for(Operators operator:operatorList) {
            OperatorBean pojo = new OperatorBean();
            pojo.setId(operator.getId());
            pojo.setName(operator.getName());
            pojo.setDescription(operator.getDescription());
            pojo.setStatus(operator.getStatus());
            list.add(pojo);
        }
        return list;
    }
}
