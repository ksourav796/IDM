package com.hyva.idm.sass.sassservice;

import com.hyva.idm.sass.sassrespositories.SassCustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HiConnectService {
    @Autowired
    SassCustomerRepository sassCustomerRepository;


}
