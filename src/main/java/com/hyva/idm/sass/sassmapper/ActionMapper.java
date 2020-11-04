package com.hyva.idm.sass.sassmapper;

import com.hyva.idm.sass.sassentities.Action;
import com.hyva.idm.sass.sassentities.Validator;
import com.hyva.idm.sass.sasspojo.ActionPojo;
import com.hyva.idm.sass.sasspojo.ValidatorPojo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by krishna.
 */
public class ActionMapper {

    public static Action mapActionPojoToEnity(ActionPojo actionPojo){
        Action action  = new Action();
        action.setId(actionPojo.getId());
        action.setName(actionPojo.getName());
        action.setDescription(actionPojo.getDescription());
        action.setStatus(actionPojo.getStatus());
        return  action;
    }

    public static List<ActionPojo> mapOperatorEntityToPojo(List<Action> operatorList){
        List<ActionPojo> list=new ArrayList<>();
        for(Action operator:operatorList) {
            ActionPojo pojo = new ActionPojo();
            pojo.setId(operator.getId());
            pojo.setName(operator.getName());
            pojo.setDescription(operator.getDescription());
            list.add(pojo);
        }
        return list;
}
}

