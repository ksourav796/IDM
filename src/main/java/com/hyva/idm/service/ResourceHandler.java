package com.hyva.idm.service;

import java.io.InputStream;

public class ResourceHandler {

    public InputStream getResourceAsStream(String FileName) throws Exception {
        ClassLoader classLoader = this.getClass().getClassLoader();
        InputStream resourceStream = classLoader.getResourceAsStream(FileName);
        return resourceStream;
    }
}
