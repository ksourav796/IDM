package com.hyva.idm.sass.sassmapper;

import com.hyva.idm.sass.sassentities.SassUser;
import com.hyva.idm.sass.sasspojo.SassUserPojo;

import java.util.ArrayList;
import java.util.List;

public class SassUserMapper {

    public static SassUser mapPojoToEntity(SassUserPojo sassUserPojo) {
        SassUser sassUser = new SassUser();
        sassUser.setUseraccountid(sassUserPojo.getUseraccount_id());
        sassUser.setEmail(sassUserPojo.getEmail());
        sassUser.setUserName(sassUserPojo.getUserName());
        sassUser.setPasswordUser(sassUserPojo.getPasswordUser());
        sassUser.setFull_name(sassUserPojo.getFull_name());
        sassUser.setPhone(sassUserPojo.getPhone());
        sassUser.setSecurityAnswer(sassUserPojo.getSecurityAnswer());
        sassUser.setSecurityQuestion(sassUserPojo.getSecurityQuestion());
        sassUser.setStatus(sassUserPojo.getStatus());
        return sassUser;
    }

    public static List<SassUserPojo> mapEntityToPojo(List<SassUser> sassUserList){
        List<SassUserPojo> sassUserPojos = new ArrayList<>();
        for(SassUser sassUser:sassUserList){
            SassUserPojo sassUserPojo = new SassUserPojo();
            sassUserPojo.setUseraccount_id( sassUser.getUseraccountid());
            sassUserPojo.setFull_name( sassUser.getFull_name());
            sassUserPojo.setUserName( sassUser.getUserName());
            sassUserPojo.setEmail( sassUser.getEmail());
            sassUserPojo.setPasswordUser( sassUser.getPasswordUser());
            sassUserPojo.setPhone( sassUser.getPhone());
            sassUserPojos.add(sassUserPojo);
        }
        return sassUserPojos;
    }

}
