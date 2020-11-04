package com.hyva.idm.pkt.pktMappers;

import com.hyva.idm.pkt.pktRelations.Actions;
import com.hyva.idm.pkt.pktBeans.ActionBean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * krishna
 */
@Component
public class ActionMapper {

    public static Actions mapActionPojoToEnity(ActionBean actionPojo){
        Actions action  = new Actions();
        action.setId(actionPojo.getId());
        action.setName(actionPojo.getName());
        action.setDescription(actionPojo.getDescription());
        action.setStatus(actionPojo.getStatus());
        return  action;
    }

    public static List<ActionBean> mapOperatorEntityToPojo(List<Actions> operatorList){
        List<ActionBean> list=new ArrayList<>();
        for(Actions operator:operatorList) {
            ActionBean pojo = new ActionBean();
            pojo.setId(operator.getId());
            pojo.setName(operator.getName());
            pojo.setDescription(operator.getDescription());
            pojo.setStatus(operator.getStatus());
            list.add(pojo);
        }
        return list;
    }
}
