package com.hyva.idm.service;

import com.lambdaworks.crypto.SCryptUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by tnataraj on 1/15/18.
 */
@Service
public class ScryptPasswordManager {

    @Value("${scrypt.N}")
    private int scryptN;

    @Value("${scrypt.r}")
    private int scryptR;

    @Value("${scrypt.p}")
    private int scryptP;


    public  String encrypt( String plainTextPassword) {
        return SCryptUtil.scrypt(plainTextPassword, scryptN, scryptR, scryptP);
    }



    public  boolean matches( String plainPassword,String encryptedPassword) {
        return  SCryptUtil.check(plainPassword, encryptedPassword);
    }
}
