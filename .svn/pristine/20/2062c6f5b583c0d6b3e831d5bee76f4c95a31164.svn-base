package com.hyva.idm.sass.sassmapper;

import com.hyva.idm.sass.sassentities.Operator;
import com.hyva.idm.sass.sassentities.PktFields;
import com.hyva.idm.sass.sasspojo.Operatorpojo;
import com.hyva.idm.sass.sasspojo.PktFieldsPojo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by krishna.
 */
public class OperatorMapper {

    public static Operator mapOperatorPojoToEnity(Operatorpojo operatorpojo){
        Operator operator  = new Operator();
        operator.setId(operatorpojo.getId());
        operator.setName(operatorpojo.getName());
        operator.setDescription(operatorpojo.getDescription());
        operator.setStatus(operatorpojo.getStatus());
        return  operator;
    }

    public static List<Operatorpojo> mapOperatorEntityToPojo(List<Operator> operatorList){
        List<Operatorpojo> list=new ArrayList<>();
        for(Operator operator:operatorList) {
            Operatorpojo pojo = new Operatorpojo();
            pojo.setId(operator.getId());
            pojo.setName(operator.getName());
            pojo.setDescription(operator.getDescription());
            list.add(pojo);
        }
        return list;
    }
}
