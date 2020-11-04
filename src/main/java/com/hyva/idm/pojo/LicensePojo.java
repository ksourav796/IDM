package com.hyva.idm.pojo;

import com.license4j.*;
import com.license4j.exceptions.LicenseSecurityException;
import com.license4j.util.Crypto;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.*;
import java.util.Date;
import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LicensePojo {
        private LicenseText licenseString;
        private LicenseKey licenseKey;
        private ValidationStatus validationStatus;
//        private ActivationStatus d ;
//        private ModificationStatus e;
//        private String f;
//        private Timer g ;
//        private Timer h;
//        private Thread i;
//        private int j = 0;
//        private long l;

    public LicenseText getLicenseString() {
        return licenseString;
    }

    public void setLicenseString(LicenseText licenseString) {
        this.licenseString = licenseString;
    }

//    public LicenseKey getLicenseKey() {
//        return licenseKey;
//    }
//
//    public void setLicenseKey(LicenseKey licenseKey) {
//        this.licenseKey = licenseKey;
//    }
//
//    public ValidationStatus getValidationStatus() {
//        return validationStatus;
//    }
//
//    public void setValidationStatus(ValidationStatus validationStatus) {
//        this.validationStatus = validationStatus;
//    }
//
//    public ActivationStatus getD() {
//        return d;
//    }
//
//    public void setD(ActivationStatus d) {
//        this.d = d;
//    }
//
//    public ModificationStatus getE() {
//        return e;
//    }
//
//    public void setE(ModificationStatus e) {
//        this.e = e;
//    }
//
//    public String getF() {
//        return f;
//    }
//
//    public void setF(String f) {
//        this.f = f;
//    }
//
//    public Timer getG() {
//        return g;
//    }
//
//    public void setG(Timer g) {
//        this.g = g;
//    }
//
//    public Timer getH() {
//        return h;
//    }
//
//    public void setH(Timer h) {
//        this.h = h;
//    }
//
//    public Thread getI() {
//        return i;
//    }
//
//    public void setI(Thread i) {
//        this.i = i;
//    }
//
//    public int getJ() {
//        return j;
//    }
//
//    public void setJ(int j) {
//        this.j = j;
//    }
//
//    public long getL() {
//        return l;
//    }
//
//    public void setL(long l) {
//        this.l = l;
//    }
}
