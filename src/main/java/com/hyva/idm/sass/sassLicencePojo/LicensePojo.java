package com.hyva.idm.sass.sassLicencePojo;

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

    private LicenseText a = null;
    private LicenseKey b = null;
    private ValidationStatus c = null;
    private ActivationStatus d = null;
    private ModificationStatus e = null;
    private String f;
    private Timer g = null;
    private Timer h = null;
    private Thread i = null;
    private int j = 0;
    private static String k = "License4J HTTPClient";
    private long l;

    protected LicensePojo(LicenseText licenseText, String publicKey, ValidationStatus validationStatus) {
        this.a = licenseText;
        this.c = validationStatus;
        this.f = publicKey;
    }

    protected LicensePojo(LicenseKey licenseKey, String publicKey, ValidationStatus validationStatus) {
        this.b = licenseKey;
        this.c = validationStatus;
        this.f = publicKey;
    }

    protected LicensePojo(ValidationStatus validationStatus) {
        this.c = validationStatus;
    }

    public ValidationStatus getValidationStatus() {
        return this.c;
    }

    public ModificationStatus getModificationStatus() {
        if (this.getValidationStatus() != ValidationStatus.LICENSE_VALID && this.getValidationStatus() == ValidationStatus.LICENSE_EXPIRED && this.getValidationStatus() == ValidationStatus.LICENSE_MAINTENANCE_EXPIRED) {
            Logger.getLogger(LicenseValidator.class.getName()).log(Level.SEVERE, "Given License Validation Status is INVALID.");
        } else if (this.getActivationStatus() != ActivationStatus.ACTIVATION_COMPLETED) {
            Logger.getLogger(LicenseValidator.class.getName()).log(Level.SEVERE, "Given License Activation Status is NOT ACTIVATION COMPLETED.");
        } else if (this.getLicenseText() == null) {
            Logger.getLogger(LicenseValidator.class.getName()).log(Level.SEVERE, "Modification is only supported for activated license text, activation code cannot be modified.");
        }

        return this.e;
    }

    public ActivationStatus getActivationStatus() {
        if (this.d == null) {
            if (this.a != null) {
                if (this.a.isActivationRequired()) {
                    this.d = ActivationStatus.ACTIVATION_REQUIRED;
                } else if (this.a.isActivationCompleted()) {
                    this.d = ActivationStatus.ACTIVATION_COMPLETED;
                } else {
                    this.d = ActivationStatus.ACTIVATION_NOT_REQUIRED;
                }
            } else if (this.b != null) {
                if (this.b.isActivationRequired()) {
                    this.d = ActivationStatus.ACTIVATION_REQUIRED;
                } else if (this.b.isActivationCompleted()) {
                    this.d = ActivationStatus.ACTIVATION_COMPLETED;
                } else {
                    this.d = ActivationStatus.ACTIVATION_NOT_REQUIRED;
                }
            }
        }

        return this.d;
    }

    protected final void a(ValidationStatus var1) {
        this.c = var1;
    }

    protected final void a(ActivationStatus var1) {
        this.d = var1;
    }

    protected final void a(ModificationStatus var1) {
        this.e = var1;
    }

    public String getLicenseString() {
        if (this.a != null) {
            try {
                return this.a.getContent(this.f);
            } catch (LicenseSecurityException var2) {
                Logger.getLogger(License.class.getName()).log(Level.SEVERE, (String)null, var2);
            }
        } else if (this.b != null) {
            if (this.getActivationStatus() == ActivationStatus.ACTIVATION_COMPLETED) {
                return this.b.getTheKey() + "-" + this.b.getHardwareIDValidationMethod();
            }

            return this.b.getTheKey();
        }

        return null;
    }

    public String getManualActivationRequestString() {
        if (this.getActivationStatus() == ActivationStatus.ACTIVATION_NOT_REQUIRED) {
            return null;
        } else {
            String var1 = "";
            String var2 = HardwareID.getHardwareIDFromHostName();
            String var3 = HardwareID.getHardwareIDFromEthernetAddress();
            String var4 = HardwareID.getHardwareIDFromVolumeSerialNumber();
            String var5 = HardwareID.getHardwareIDFromHDDSerial();
            if (var2 != null) {
                var1 = var2;
            }

            if (var3 != null) {
                var1 = var1 + "!" + var3;
            }

            if (var4 != null) {
                var1 = var1 + "!" + var4;
            }

            if (var5 != null) {
                var1 = var1 + "!" + var5;
            }

            var2 = "";

            try {
                var2 = InetAddress.getLocalHost().getHostName();
            } catch (UnknownHostException var7) {
                ;
            }

            if (var2.length() == 0) {
                var2 = "unknown";
            }

            var3 = this.getLicenseString();
            if ((var4 = System.getProperty("os.name")) == null || var4.length() == 0) {
                var4 = "unknown";
            }

            var1 = var2 + "@" + var4 + "@" + var1 + "@" + this.f.hashCode() + "@" + var3 + "@";
            var2 = "";

            try {
                var2 = Crypto.encrypt(var1, "rManuelActivate");
            } catch (Exception var6) {
                ;
            }

            return var2;
        }
    }

    public String getManualActivationRequestStringWithCustomHardwareID(String customHardwareID) {
        if (this.getActivationStatus() == ActivationStatus.ACTIVATION_NOT_REQUIRED) {
            return null;
        } else if (customHardwareID != null && customHardwareID.length() != 0) {
            String var2 = "";

            try {
                var2 = InetAddress.getLocalHost().getHostName();
            } catch (UnknownHostException var6) {
                ;
            }

            if (var2.length() == 0) {
                var2 = "unknown";
            }

            String var3 = this.getLicenseString();
            String var4;
            if ((var4 = System.getProperty("os.name")) == null || var4.length() == 0) {
                var4 = "unknown";
            }

            customHardwareID = var2 + "@" + var4 + "@cid-" + customHardwareID + "@" + this.f.hashCode() + "@" + var3 + "@";
            var2 = "";

            try {
                var2 = Crypto.encrypt(customHardwareID, "rManuelActivate");
            } catch (Exception var5) {
                ;
            }

            return var2;
        } else {
            return null;
        }
    }

    public String getManualActivationRequestStringWithUserInformation(boolean modifyOnlyOnFirstActivation, String fullname, String registeredto, String email, String company, String street, String telnumber, String faxnumber, String city, String zip, String country) {
        if (this.getActivationStatus() == ActivationStatus.ACTIVATION_NOT_REQUIRED) {
            return null;
        } else {
            String var12 = "";
            String var13 = HardwareID.getHardwareIDFromHostName();
            String var14 = HardwareID.getHardwareIDFromEthernetAddress();
            String var15 = HardwareID.getHardwareIDFromVolumeSerialNumber();
            String var16 = HardwareID.getHardwareIDFromHDDSerial();
            if (var13 != null) {
                var12 = var13;
            }

            if (var14 != null) {
                var12 = var12 + "!" + var14;
            }

            if (var15 != null) {
                var12 = var12 + "!" + var15;
            }

            if (var16 != null) {
                var12 = var12 + "!" + var16;
            }

            var13 = "";

            try {
                var13 = InetAddress.getLocalHost().getHostName();
            } catch (UnknownHostException var18) {
                ;
            }

            if (var13.length() == 0) {
                var13 = "unknown";
            }

            var14 = this.getLicenseString();
            if ((var15 = System.getProperty("os.name")) == null || var15.length() == 0) {
                var15 = "unknown";
            }

            String modifyOnlyOnFirstActivation1 = var13 + "@" + var15 + "@" + var12 + "@" + this.f.hashCode() + "@" + var14 + "@" + (modifyOnlyOnFirstActivation ? "true" : "false") + "@" + (fullname != null && fullname.length() > 0 ? fullname : "~") + "@" + (registeredto != null && registeredto.length() > 0 ? registeredto : "~") + "@" + (email != null && email.length() > 0 ? email : "~") + "@" + (company != null && company.length() > 0 ? company : "~") + "@" + (street != null && street.length() > 0 ? street : "~") + "@" + (telnumber != null && telnumber.length() > 0 ? telnumber : "~") + "@" + (faxnumber != null && faxnumber.length() > 0 ? faxnumber : "~") + "@" + (city != null && city.length() > 0 ? city : "~") + "@" + (zip != null && zip.length() > 0 ? zip : "~") + "@" + (country != null && country.length() > 0 ? country : "~");
            fullname = "";

            try {
                fullname = Crypto.encrypt(modifyOnlyOnFirstActivation1, "rManuelActivate");
            } catch (Exception var17) {
                ;
            }

            return fullname;
        }
    }

    public String getManualActivationRequestStringWithCustomHardwareIDWithUserInformation(String customHardwareID, boolean modifyOnlyOnFirstActivation, String fullname, String registeredto, String email, String company, String street, String telnumber, String faxnumber, String city, String zip, String country) {
        if (this.getActivationStatus() == ActivationStatus.ACTIVATION_NOT_REQUIRED) {
            return null;
        } else if (customHardwareID != null && customHardwareID.length() != 0) {
            String var13 = "";

            try {
                var13 = InetAddress.getLocalHost().getHostName();
            } catch (UnknownHostException var17) {
                ;
            }

            if (var13.length() == 0) {
                var13 = "unknown";
            }

            String var14 = this.getLicenseString();
            String var15;
            if ((var15 = System.getProperty("os.name")) == null || var15.length() == 0) {
                var15 = "unknown";
            }

            customHardwareID = var13 + "@" + var15 + "@cid-" + customHardwareID + "@" + this.f.hashCode() + "@" + var14 + "@" + (modifyOnlyOnFirstActivation ? "true" : "false") + "@" + (fullname != null && fullname.length() > 0 ? fullname : "~") + "@" + (registeredto != null && registeredto.length() > 0 ? registeredto : "~") + "@" + (email != null && email.length() > 0 ? email : "~") + "@" + (company != null && company.length() > 0 ? company : "~") + "@" + (street != null && street.length() > 0 ? street : "~") + "@" + (telnumber != null && telnumber.length() > 0 ? telnumber : "~") + "@" + (faxnumber != null && faxnumber.length() > 0 ? faxnumber : "~") + "@" + (city != null && city.length() > 0 ? city : "~") + "@" + (zip != null && zip.length() > 0 ? zip : "~") + "@" + (country != null && country.length() > 0 ? country : "~");
            String modifyOnlyOnFirstActivation1 = "";

            try {
                modifyOnlyOnFirstActivation1 = Crypto.encrypt(customHardwareID, "rManuelActivate");
            } catch (Exception var16) {
                ;
            }

            return modifyOnlyOnFirstActivation1;
        } else {
            return null;
        }
    }

    public String getManualModificationRequestString(String modificationKey) {
        if (this.getActivationStatus() != ActivationStatus.ACTIVATION_COMPLETED) {
            return null;
        } else if (this.getLicenseString().length() < 70) {
            return null;
        } else {
            String var2 = "";

            try {
                var2 = InetAddress.getLocalHost().getHostName();
            } catch (UnknownHostException var6) {
                ;
            }

            if (var2.length() == 0) {
                var2 = "unknown";
            }

            String var3;
            if ((var3 = System.getProperty("os.name")) == null || var3.length() == 0) {
                var3 = "unknown";
            }

            String var4 = null;
            if (this.getLicenseText() != null) {
                var4 = String.valueOf(this.getLicenseText().getActivationID());
            }

            modificationKey = var2 + "@" + var3 + "@" + this.f.hashCode() + "@" + var4 + "@" + modificationKey;
            var2 = "";

            try {
                var2 = Crypto.encrypt(modificationKey, "rManuelModify");
            } catch (Exception var5) {
                ;
            }

            return var2;
        }
    }

    public String getManualDeactivationRequestString() {
        if (this.getActivationStatus() != ActivationStatus.ACTIVATION_COMPLETED) {
            return null;
        } else {
            String var1 = "";

            try {
                var1 = InetAddress.getLocalHost().getHostName();
            } catch (UnknownHostException var6) {
                ;
            }

            if (var1.length() == 0) {
                var1 = "unknown";
            }

            String var2 = this.getLicenseString();
            String var3;
            if ((var3 = System.getProperty("os.name")) == null || var3.length() == 0) {
                var3 = "unknown";
            }

            String var4 = null;
            if (this.getLicenseText() != null) {
                var4 = String.valueOf(this.getLicenseText().getActivationID());
            }

            if (var4 == null) {
                var1 = var1 + "@" + var3 + "@" + this.f.hashCode() + "@" + var2 + "@";
            } else {
                var1 = var1 + "@" + var3 + "@" + this.f.hashCode() + "@" + var2 + "@" + var4 + "@";
            }

            var2 = "";

            try {
                var2 = Crypto.encrypt(var1, "rManuelDeActivate");
            } catch (Exception var5) {
                ;
            }

            return var2;
        }
    }

    public String getPublicKey() {
        return this.f;
    }

    public boolean isActivationRequired() {
        if (this.a != null) {
            return this.a.isActivationRequired();
        } else {
            return this.b != null ? this.b.isActivationRequired() : false;
        }
    }

    public boolean isActivationCompleted() {
        if (this.a != null) {
            return this.a.isActivationCompleted();
        } else {
            return this.b != null ? this.b.isActivationCompleted() : false;
        }
    }

    public int getLicenseActivationDaysRemaining(Date currentDate) {
        if (this.a != null) {
            return this.a.getLicenseActivationDaysRemaining(currentDate);
        } else {
            return this.b != null ? this.b.getLicenseActivationDaysRemaining(currentDate) : -1;
        }
    }

    public int getLicenseActivationPeriod(Date currentDate) {
        if (this.a != null) {
            return this.a.getActivationPeriod();
        } else {
            return this.b != null ? this.b.getActivationPeriod() : -1;
        }
    }

    public LicenseText getLicenseText() {
        return this.a;
    }

    public LicenseKey getLicenseKey() {
        return this.b;
    }

    public int getUseCountCurrent() {
        int var1 = 0;
        String var2;
        if (this.getLicenseText() != null && (var2 = this.getLicenseText().getCustomSignedFeature("use-count")) != null) {
            try {
                var1 = Integer.parseInt(var2);
            } catch (Exception var3) {
                ;
            }
        }

        return var1;
    }

    public int getUseCountAllowed() {
        int var1 = 0;
        String var2;
        if (this.getLicenseText() != null && (var2 = this.getLicenseText().getCustomSignedFeature("allowed-use-count")) != null) {
            try {
                var1 = Integer.parseInt(var2);
            } catch (Exception var3) {
                ;
            }
        }

        return var1;
    }

    public long getUseTimeCurrent() {
        long var1 = 0L;
        String var3;
        if (this.getLicenseText() != null && (var3 = this.getLicenseText().getCustomSignedFeature("use-time")) != null) {
            try {
                var1 = Long.parseLong(var3);
            } catch (Exception var4) {
                ;
            }
        }

        return var1 / 1000L;
    }

    public long getUseTimeLimitAllowed() {
        long var1 = 0L;
        String var3;
        if (this.getLicenseText() != null && (var3 = this.getLicenseText().getCustomSignedFeature("allowed-use-time")) != null) {
            try {
                var1 = Long.parseLong(var3);
            } catch (Exception var4) {
                ;
            }
        }

        return var1 * 60L;
    }

    public String getUsedModificationKeys() {
        String var1 = null;
        if (this.getLicenseText() != null) {
            var1 = this.getLicenseText().getCustomSignedFeature("license-modified-by");
        }

        return var1;
    }

    protected final Timer a() {
        return this.g;
    }

    protected final void a(Timer var1) {
        this.g = var1;
    }

    protected final Timer b() {
        return this.h;
    }

    protected final void b(Timer var1) {
        this.h = var1;
    }

    protected final Thread c() {
        return this.i;
    }

    protected final void a(Thread var1) {
        this.i = var1;
    }

    public synchronized void stopFloatingLicenseCheckTimers() {
        if (this.g != null) {
            this.g.cancel();
        }

        if (this.h != null) {
            this.h.cancel();
        }

        if (this.i != null) {
            Runtime.getRuntime().removeShutdownHook(this.i);
        }

    }

    public synchronized void releaseFloatingLicense() {
        this.stopFloatingLicenseCheckTimers();
        if (this.i != null && this.i.getState() == Thread.State.NEW) {
            this.i.start();
            this.c = ValidationStatus.LICENSE_INVALID;
            this.a = null;
        }

    }

    public int getFloatingLicenseServerVersion() {
        return this.j;
    }

    protected final void a(int var1) {
        this.j = var1;
    }

    public String[] checkForNewMessage() {
        return this.checkForNewMessage((String)null);
    }

    public String[] checkForNewMessage(String licenseServer) {
        String[] var2 = "~@~".split("~@~");
        boolean var3 = true;
        if (licenseServer == null || licenseServer.startsWith("http://")) {
            var3 = false;
        }

        String var4;
        if ((var4 = HardwareID.getHardwareIDFromEthernetAddress()) == null) {
            var4 = "unknown";

            try {
                var4 = InetAddress.getLocalHost().getHostName();
            } catch (UnknownHostException var50) {
                ;
            }
        }

        Object licenseServer1;
        try {
            if (licenseServer == null) {
                licenseServer1 = (HttpsURLConnection)(new URL("https://online.license4j.com/e/checkmessageupdate")).openConnection();
            } else if (var3) {
                licenseServer1 = (HttpsURLConnection)(new URL(licenseServer)).openConnection();
            } else {
                licenseServer1 = (HttpURLConnection)(new URL(licenseServer)).openConnection();
            }

            ((URLConnection)licenseServer1).setConnectTimeout(10000);
            ((URLConnection)licenseServer1).setReadTimeout(10000);
            if (System.getProperty("license4j-user-agent") != null) {
                k = System.getProperty("license4j-user-agent");
            }

            ((URLConnection)licenseServer1).setRequestProperty("User-Agent", k);
            ((URLConnection)licenseServer1).setDoOutput(true);
            ((URLConnection)licenseServer1).setRequestProperty("Accept-Charset", "UTF-8");
            ((URLConnection)licenseServer1).setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
        } catch (Exception var55) {
            return var2;
        }

        String var5 = String.valueOf(this.getPublicKey().hashCode());
        OutputStreamWriter var6 = null;
        boolean var40 = false;

        label562: {
            try {
                var40 = true;
                (var6 = new OutputStreamWriter(((URLConnection)licenseServer1).getOutputStream(), "UTF-8")).write("action=cfnm&");
                if (this.getActivationStatus() == ActivationStatus.ACTIVATION_COMPLETED) {
                    var6.write("lsa=" + this.getLicenseString() + "&");
                } else if (this.getLicenseText() != null && this.getLicenseText().getCustomSignedFeature("use-count") != null) {
                    var6.write("lso=" + this.getLicenseString() + "&");
                } else {
                    var6.write("ls=" + this.getLicenseString() + "&");
                }

                var6.write("chon=" + var4 + "&");
                var6.write("pa=" + var5 + "&");
                var40 = false;
                break label562;
            } catch (Exception var53) {
                var40 = false;
            } finally {
                if (var40) {
                    if (var6 != null) {
                        try {
                            var6.close();
                        } catch (Exception var46) {
                            ;
                        }
                    }

                }
            }

            if (var6 != null) {
                try {
                    var6.close();
                } catch (Exception var45) {
                    ;
                }
            }

            return var2;
        }

        try {
            var6.close();
        } catch (Exception var49) {
            ;
        }

        StringBuilder var57 = new StringBuilder();
        InputStreamReader var7 = null;
        BufferedReader var58 = null;
        boolean var24 = false;

        String var59;
        label564: {
            try {
                var24 = true;
                int var8;
                if (var3) {
                    var8 = ((HttpsURLConnection)licenseServer1).getResponseCode();
                } else {
                    var8 = ((HttpURLConnection)licenseServer1).getResponseCode();
                }

                if (var8 != 200 && var8 != 200) {
                    var24 = false;
                } else {
                    var7 = new InputStreamReader(((URLConnection)licenseServer1).getInputStream());
                    var58 = new BufferedReader(var7);

                    while((var59 = var58.readLine()) != null) {
                        var57.append(var59);
                    }

                    var24 = false;
                }
                break label564;
            } catch (Exception var51) {
                var24 = false;
            } finally {
                if (var24) {
                    if (var7 != null) {
                        try {
                            var7.close();
                        } catch (Exception var44) {
                            ;
                        }
                    }

                    if (var58 != null) {
                        try {
                            var58.close();
                        } catch (Exception var43) {
                            ;
                        }
                    }

                }
            }

            if (var7 != null) {
                try {
                    var7.close();
                } catch (Exception var42) {
                    ;
                }
            }

            if (var58 != null) {
                try {
                    var58.close();
                } catch (Exception var41) {
                    ;
                }
            }

            return var2;
        }

        if (var7 != null) {
            try {
                var7.close();
            } catch (Exception var48) {
                ;
            }
        }

        if (var58 != null) {
            try {
                var58.close();
            } catch (Exception var47) {
                ;
            }
        }

        if (var3) {
            ((HttpsURLConnection)licenseServer1).disconnect();
        } else {
            ((HttpURLConnection)licenseServer1).disconnect();
        }

        if ((var59 = var57.toString().trim()).length() >= var5.length() && var5.compareToIgnoreCase(var59.substring(0, var5.length())) == 0) {
            if ((var59 = var57.toString().substring(var5.length())).length() > 3 && var59.startsWith("~@~")) {
                var59 = var59.substring(3);
            } else if (var59.length() <= 3) {
                var59 = "~@~";
            }

            var2 = var59.split("~@~");
        }

        return var2;
    }

    public String checkForUpdate(String productEdition, String productVersion) {
        return this.checkForUpdate(productEdition, productVersion, (String)null);
    }

    public String checkForUpdate(String productEdition, String productVersion, String licenseServer) {
        String var4 = null;
        boolean var5 = true;
        if (licenseServer == null || licenseServer.startsWith("http://")) {
            var5 = false;
        }

        String var6;
        if ((var6 = HardwareID.getHardwareIDFromEthernetAddress()) == null) {
            var6 = "unknown";

            try {
                var6 = InetAddress.getLocalHost().getHostName();
            } catch (UnknownHostException var42) {
                ;
            }
        }

        Object licenseServer1;
        try {
            if (licenseServer == null) {
                licenseServer1 = (HttpsURLConnection)(new URL("https://online.license4j.com/e/checkmessageupdate")).openConnection();
            } else if (var5) {
                licenseServer1 = (HttpsURLConnection)(new URL(licenseServer)).openConnection();
            } else {
                licenseServer1 = (HttpURLConnection)(new URL(licenseServer)).openConnection();
            }

            ((URLConnection)licenseServer1).setConnectTimeout(10000);
            ((URLConnection)licenseServer1).setReadTimeout(10000);
            if (System.getProperty("license4j-user-agent") != null) {
                k = System.getProperty("license4j-user-agent");
            }

            ((URLConnection)licenseServer1).setRequestProperty("User-Agent", k);
            ((URLConnection)licenseServer1).setDoOutput(true);
            ((URLConnection)licenseServer1).setRequestProperty("Accept-Charset", "UTF-8");
            ((URLConnection)licenseServer1).setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
        } catch (Exception var47) {
            return null;
        }

        String var7 = String.valueOf(this.getPublicKey().hashCode());
        OutputStreamWriter var8 = null;
        boolean var36 = false;

        label555: {
            try {
                var36 = true;
                (var8 = new OutputStreamWriter(((URLConnection)licenseServer1).getOutputStream(), "UTF-8")).write("action=cfu&");
                if (this.getActivationStatus() == ActivationStatus.ACTIVATION_COMPLETED) {
                    var8.write("lsa=" + this.getLicenseString() + "&");
                } else if (this.getLicenseText() != null && this.getLicenseText().getCustomSignedFeature("use-count") != null) {
                    var8.write("lso=" + this.getLicenseString() + "&");
                } else {
                    var8.write("ls=" + this.getLicenseString() + "&");
                }

                if (productVersion == null || productVersion.trim().length() == 0) {
                    productVersion = "~";
                }

                if (productEdition == null || productEdition.trim().length() == 0) {
                    productEdition = "~";
                }

                if (productEdition.length() > 64) {
                    productEdition = productEdition.substring(0, 64);
                }

                if (productVersion.length() > 64) {
                    productVersion = productVersion.substring(0, 64);
                }

                var8.write("e=" + productEdition + "&");
                var8.write("v=" + productVersion + "&");
                var8.write("chon=" + var6 + "&");
                var8.write("pa=" + var7 + "&");
                var36 = false;
                break label555;
            } catch (Exception var45) {
                var36 = false;
            } finally {
                if (var36) {
                    if (var8 != null) {
                        try {
                            var8.close();
                        } catch (Exception var39) {
                            ;
                        }
                    }

                }
            }

            if (var8 != null) {
                try {
                    var8.close();
                } catch (Exception var40) {
                    ;
                }
            }

            return null;
        }

        try {
            var8.close();
        } catch (Exception var41) {
            ;
        }

        StringBuilder productEdition1 = new StringBuilder();
        InputStreamReader productVersion1 = null;
        BufferedReader var51 = null;

        label508: {
            try {
                int var9;
                if (var5) {
                    var9 = ((HttpsURLConnection)licenseServer1).getResponseCode();
                } else {
                    var9 = ((HttpURLConnection)licenseServer1).getResponseCode();
                }

                if (var9 == 200 || var9 == 200) {
                    productVersion1 = new InputStreamReader(((URLConnection)licenseServer1).getInputStream());
                    var51 = new BufferedReader(productVersion1);

                    String var52;
                    while((var52 = var51.readLine()) != null) {
                        productEdition1.append(var52);
                    }
                }
                break label508;
            } catch (Exception var43) {
                ;
            } finally {
                if (productVersion1 != null) {
                    try {
                        productVersion1.close();
                    } catch (Exception var38) {
                        ;
                    }
                }

                if (var51 != null) {
                    try {
                        var51.close();
                    } catch (Exception var37) {
                        ;
                    }
                }

            }

            return null;
        }

        if (var5) {
            ((HttpsURLConnection)licenseServer1).disconnect();
        } else {
            ((HttpURLConnection)licenseServer1).disconnect();
        }

        String var53;
        if ((var53 = productEdition1.toString().trim()).length() >= var7.length() && var7.compareToIgnoreCase(var53.substring(0, var7.length())) == 0 && (var4 = var53.substring(var7.length() + 3)).trim().length() < 3) {
            var4 = null;
        }

        return var4;
    }

    public String checkForUpdateMessage(String productEdition, String newVersion) {
        return this.checkForUpdateMessage(productEdition, newVersion, (String)null);
    }

    public String checkForUpdateMessage(String productEdition, String newVersion, String licenseServer) {
        String var4 = null;
        boolean var5 = true;
        if (licenseServer == null || licenseServer.startsWith("http://")) {
            var5 = false;
        }

        Object licenseServer1;
        try {
            if (licenseServer == null) {
                licenseServer1 = (HttpsURLConnection)(new URL("https://online.license4j.com/e/checkmessageupdate")).openConnection();
            } else if (var5) {
                licenseServer1 = (HttpsURLConnection)(new URL(licenseServer)).openConnection();
            } else {
                licenseServer1 = (HttpURLConnection)(new URL(licenseServer)).openConnection();
            }

            ((URLConnection)licenseServer1).setConnectTimeout(10000);
            ((URLConnection)licenseServer1).setReadTimeout(10000);
            if (System.getProperty("license4j-user-agent") != null) {
                k = System.getProperty("license4j-user-agent");
            }

            ((URLConnection)licenseServer1).setRequestProperty("User-Agent", k);
            ((URLConnection)licenseServer1).setDoOutput(true);
            ((URLConnection)licenseServer1).setRequestProperty("Accept-Charset", "UTF-8");
            ((URLConnection)licenseServer1).setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
        } catch (Exception var43) {
            return null;
        }

        String var6 = String.valueOf(this.getPublicKey().hashCode());
        OutputStreamWriter var7 = null;
        boolean var33 = false;

        label534: {
            try {
                var33 = true;
                (var7 = new OutputStreamWriter(((URLConnection)licenseServer1).getOutputStream(), "UTF-8")).write("action=cfum&");
                if (this.getActivationStatus() == ActivationStatus.ACTIVATION_COMPLETED) {
                    var7.write("lsa=" + this.getLicenseString() + "&");
                } else if (this.getLicenseText() != null && this.getLicenseText().getCustomSignedFeature("use-count") != null) {
                    var7.write("lso=" + this.getLicenseString() + "&");
                } else {
                    var7.write("ls=" + this.getLicenseString() + "&");
                }

                if (newVersion == null || newVersion.trim().length() == 0) {
                    newVersion = "~";
                }

                if (productEdition == null || productEdition.trim().length() == 0) {
                    productEdition = "~";
                }

                if (productEdition.length() > 64) {
                    productEdition = productEdition.substring(0, 64);
                }

                if (newVersion.length() > 64) {
                    newVersion = newVersion.substring(0, 64);
                }

                var7.write("e=" + productEdition + "&");
                var7.write("v=" + newVersion + "&");
                var7.write("pa=" + var6 + "&");
                var33 = false;
                break label534;
            } catch (Exception var41) {
                var33 = false;
            } finally {
                if (var33) {
                    if (var7 != null) {
                        try {
                            var7.close();
                        } catch (Exception var35) {
                            ;
                        }
                    }

                }
            }

            if (var7 != null) {
                try {
                    var7.close();
                } catch (Exception var34) {
                    ;
                }
            }

            return null;
        }

        try {
            var7.close();
        } catch (Exception var38) {
            ;
        }

        StringBuilder productEdition1 = new StringBuilder();
        InputStreamReader newVersion1 = null;
        BufferedReader var47 = null;

        String var48;
        label489: {
            try {
                int var8;
                if (var5) {
                    var8 = ((HttpsURLConnection)licenseServer1).getResponseCode();
                } else {
                    var8 = ((HttpURLConnection)licenseServer1).getResponseCode();
                }

                if (var8 == 200 || var8 == 200) {
                    newVersion1 = new InputStreamReader(((URLConnection)licenseServer1).getInputStream());
                    var47 = new BufferedReader(newVersion1);

                    while((var48 = var47.readLine()) != null) {
                        productEdition1.append(var48);
                    }
                }
                break label489;
            } catch (Exception var39) {
                ;
            } finally {
                if (newVersion1 != null) {
                    try {
                        newVersion1.close();
                    } catch (Exception var37) {
                        ;
                    }
                }

                if (var47 != null) {
                    try {
                        var47.close();
                    } catch (Exception var36) {
                        ;
                    }
                }

            }

            return null;
        }

        if (var5) {
            ((HttpsURLConnection)licenseServer1).disconnect();
        } else {
            ((HttpURLConnection)licenseServer1).disconnect();
        }

        if ((var48 = productEdition1.toString().trim()).length() >= var6.length() && var6.compareToIgnoreCase(var48.substring(0, var6.length())) == 0 && (var48 = productEdition1.toString().substring(var6.length())).length() > 3 && var48.startsWith("~@~")) {
            var4 = var48.substring(3);
        }

        return var4;
    }

    protected final long d() {
        return this.l;
    }

    protected final void a(long var1) {
        this.l = var1;
    }




}
