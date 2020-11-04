package com.hyva.idm.pkt.pktMappers;

import com.hyva.idm.pkt.pktBeans.ValidatorBean;
import com.hyva.idm.pkt.pktRelations.Validator;
import com.hyva.idm.sass.sasspojo.ValidatorPojo;
import org.springframework.stereotype.Component;

/**
 * krishna
 */
@Component
public class ValidatorMapper {
    public static Validator mapValidatorPojoToEnity(ValidatorBean validatorPojo){
        Validator validator  = new Validator();
        validator.setId(validatorPojo.getId());
        validator.setName(validatorPojo.getName());
        validator.setDescription(validatorPojo.getDescription());
        validator.setStatus(validatorPojo.getStatus());
        return  validator;
    }
}
