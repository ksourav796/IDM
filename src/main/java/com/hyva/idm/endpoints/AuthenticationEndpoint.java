package com.hyva.idm.endpoints;

import com.hyva.idm.constants.EndpointConstants;
import com.hyva.idm.service.ThirdPartyAccessTokenService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tnataraj on 1/15/18.
 */
@RestController
@RequestMapping(EndpointConstants.AUTHENTICATION_ENDPOINT)
public class AuthenticationEndpoint {

    @RequestMapping(value = "/authenticate_access_token",method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String auhtenticateUserNamePass()
    {
      return "success";
    }


    @RequestMapping(value = "flip_kart/access_token",method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String getFlipKartAccessToken()
    {

        return ThirdPartyAccessTokenService.getAccessToken();
    }


}
