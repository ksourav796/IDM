package com.hyva.idm.sass.sassendpoints;

import com.hyva.idm.constants.EndpointConstants;
import com.hyva.idm.pojo.LicensePojo;
import com.license4j.License;
import com.license4j.LicenseText;
import com.license4j.ValidationStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

@RestController
@RequestMapping(EndpointConstants.SERVICES_ENDPOINT)
public class LicenceController {



    @RequestMapping(value = "/authenticate/license",
            method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public String authenticateLicense(@RequestBody LicensePojo license) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor<License> constructor  = License.class.getDeclaredConstructor(LicenseText.class,
                String.class,ValidationStatus.class);
        constructor.setAccessible(true);
//        License instance = constructor.newInstance(license.getLicenseKey(),license.getLicenseString(),
//                license.getValidationStatus());
//        License activatedLicense = LicenseValidator.autoActivate(license, ActivationServer);
//     return activatedLicense;
        return "success";

    }








}
