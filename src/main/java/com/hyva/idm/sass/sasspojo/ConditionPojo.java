package com.hyva.idm.sass.sasspojo;

import lombok.Data;

public class ConditionPojo {
public String Condition;
public String Operation;


    public String getCondition() {
        return Condition;
    }

    public void setCondition(String condition) {
        Condition = condition;
    }

    public String getOperation() {
        return Operation;
    }

    public void setOperation(String operation) {
        Operation = operation;
    }
}
