package com.hyva.idm.sass.sassmapper;

import com.hyva.idm.sass.sassentities.Operator;
import com.hyva.idm.sass.sassentities.Validator;
import com.hyva.idm.sass.sasspojo.Operatorpojo;
import com.hyva.idm.sass.sasspojo.ValidatorPojo;

/**
 * Created by krishna.
 */
public class ValidatorMapper {

    public static Validator mapValidatorPojoToEnity(ValidatorPojo validatorPojo){
        Validator validator  = new Validator();
        validator.setId(validatorPojo.getId());
        validator.setName(validatorPojo.getName());
        validator.setDescription(validatorPojo.getDescription());
        validator.setStatus(validatorPojo.getStatus());
        return  validator;
    }
}
