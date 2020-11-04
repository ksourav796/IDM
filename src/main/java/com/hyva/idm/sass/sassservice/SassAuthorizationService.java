package com.hyva.idm.sass.sassservice;

import com.hyva.idm.sass.sassentities.SassCustomer;
import com.hyva.idm.sass.sassrespositories.SassCustomerRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class SassAuthorizationService {
    @Autowired
    SassCustomerRepository sassCustomerRepository;

    public String getAuthorizationToken(SassCustomer credentials) throws Exception {
//       SassCustomer sassCustomer=sassCustomerRepository.findByEmailAndlAndLoginNameAndlAndLoginPassword( credentials.getEmail(),credentials.getLoginName(),credentials.getLoginPassword());
//       if (sassCustomer != null) {
//            AccessTokenGenerator accessTokenGenerator = new AccessTokenGenerator();
//            String authorizationToken = accessTokenGenerator.getAuthorizationToken(credentialsMap);
//            AccessToken accessToken = new AccessToken();
//            accessToken.setAccessToken(authorizationToken);
//            accessToken.setCreationTime(new java.sql.Timestamp(new Date().getTime()));
//            accessToken.setStatus(true);
//            accessToken.setValidityInMins(HiNextConstants.COOKIE_AGE / 60);
//            accessToken.setUserAccountSetup(userAccountSetup);
//            userAccountSetup.getAccessTokenSet().clear();
//            userAccountSetup.getAccessTokenSet().add(accessToken);
//            hiposDAO.saveAccountSetup(userAccountSetup, dbKeyword);
//            return authorizationToken;
//        } else {
//            return "";
//        }

        return "";


    }










}
