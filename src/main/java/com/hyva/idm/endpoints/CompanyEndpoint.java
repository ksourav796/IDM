package com.hyva.idm.endpoints;

import com.hyva.idm.constants.EndpointConstants;
import com.hyva.idm.pojo.CompanyPojo;
import com.hyva.idm.pojo.IDMResponse;
import com.hyva.idm.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * Created by tnataraj on 1/15/18.
 */
@RestController
@RequestMapping(EndpointConstants.COMPANY_ENDPOINT)
public class CompanyEndpoint {

    @Autowired
    CompanyService companyService;

    @RequestMapping(value = "/createCompany",method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public IDMResponse createCompany(@Validated @RequestBody CompanyPojo companyPojo)
    {
        return companyService.createCompany(companyPojo);
    }

    @RequestMapping(method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public IDMResponse deleteCompany(@RequestParam("companyName") String companyName)
    {
        return companyService.deleteCompany(companyName);
    }

    @RequestMapping(value = "/email", method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String updateEmail() {
        return "update email";
    }
}
