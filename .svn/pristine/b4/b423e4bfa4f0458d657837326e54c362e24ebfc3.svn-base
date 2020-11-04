package com.hyva.idm.sass.sassutil;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.net.URLCodec;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;



public class AccessTokenGenerator {


    private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    public static String randomAlphaNumeric() {
//           int count=60;
//           StringBuilder builder = new StringBuilder();
//
//        while (count-- != 0) {
//
//            int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
//
//            builder.append(ALPHA_NUMERIC_STRING.charAt(character));
//
//        }
//
//        return builder.toString();


        int length = 60;
        boolean useLetters = true;
        boolean useNumbers = true;
        String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
        System.out.println(generatedString);
        return  generatedString;

    }

}
