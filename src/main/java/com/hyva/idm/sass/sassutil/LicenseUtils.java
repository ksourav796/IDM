///*
// * LicenseUtils helper class to validate, activate license.
// */
//package com.hyva.idm.sass.sassutil;
//import com.license4j.*;
//import com.license4j.exceptions.LicenseSecurityException;
//import com.license4j.util.FileUtils;
//import org.apache.log4j.Logger;
//import org.springframework.context.annotation.DependsOn;
//import org.springframework.stereotype.Component;
//import javax.annotation.PostConstruct;
//import javax.servlet.ServletContext;
//import java.io.File;
//import java.io.IOException;
//import java.nio.channels.FileLockInterruptionException;
//@Component
//@DependsOn("fileSystemOperations")
//public class LicenseUtils {
//    /**
//     * License file is saved to "conf" directory of running tomcat. It can be
//     * saved into any other folder which tomcat process has write access.
//     * License can also be saved into a database.
//     */
//    private static String licenseFileOnDisk;
//    private static final Logger LOGGER = Logger.getLogger(LicenseUtils.class);
//    private static final String ActivationServer = "http://license.hiaccounts.com:9090/algas/";
//    /**
//     * Our unique public key for Example Web Application.
//     */
//    private static final String publickey = "30819f300d06092a864886f70d010101050003818d0030818930323010060" +
//            "72a8648ce3d02002EC311215SHA512withECDSA106052b810400060" +
//            "31e000429fe52de3a8fd0352e792d6dcb10d0ee8b5e445456359da4" +
//            "637ab7faG028181008d39befd33367659ee67458d08e10c137e6475" +
//            "4560d7e28d8d9e002429098917ec59824924c1a756db29695932bdc" +
//            "d75f9c4d5eb0d5d50a1fe7a7ca9cc8c62cea6d3b646975f0bef284b" +
//            "77d95adf23d5eed1e21e5fe58c9a2d999710a152560d03RSA410241" +
//            "3SHA512withRSAb10ff9c4da46d791176a79e58a8208a33ede71d72" +
//            "591ae7ad31198db60f9c29d0203010001";
//    /**
//     * Variables needed for license key.
//     */
//    private static final String internalString = "HinextIndiaActivation";
//    private static final String nameforValidation = null;
//    private static final String companyforValidation = null;
//    private static final int hardwareIDMethod = 0;
//
//    /**
//     * Variables needed for license text.
//     */
//    private static final String productID = "hinextindianversion";
//    private static final String productEdition = null;
//    private static final String productVersion = null;
//
//    @PostConstruct
//    public void init() {
//
//    }
//
//    public static License validate(String licenseString) {
//        /**
//         * a boolean variable to control license save to disk. We save license
//         * to disk only if it is supplied by user. If it is read from disk
//         *
//         * was previously saved, it will not be overwritten.
//         */
//        boolean saveToDisk;
//
//        /**
//         * If given license string is null, read license file on disk to get a
//         * previously saved license string.
//         */
//        if (licenseString == null) {
//            saveToDisk = false;
//
//            try {
//                licenseString = FileUtils.readFile(licenseFileOnDisk).trim();
//            } catch (IOException ex) {
//                //Logger.getLogger(LicenseUtils.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        } else {
//            saveToDisk = true;
//
//            // trim string discard whitespaces.
//            licenseString = licenseString.trim();
//        }
//
//        License license = null;
//
//        if (licenseString != null && licenseString.length() <= 70) {
//            /**
//             * It is a 25 characters basic license key (separated with -
//             * character).
//             */
//
//            license = validateLicenseKey(licenseString, saveToDisk);
//
//            if (license.isActivationRequired()) {
//                /**
//                 * If license requires activation, silently activate license
//                 * here and save it to disk.
//                 */
//                license = activateLicense(license, true);
//            }
//        } else {
//            /**
//             * It is a license text.
//             */
//            license = validateLicenseText(licenseString, saveToDisk);
//
//            if (license.isActivationRequired()) {
//                /**
//                 * If license requires activation, silently activate license
//                 * here and save it to disk.
//                 */
//                license = activateLicense(license, true);
//            }
//        }
//
//        return license;
//    }
//
//    public static void delete(ServletContext sce) {
//        File f = new File(licenseFileOnDisk);
//        f.delete();
//        sce.removeAttribute("license");
//    }
//
//    public static License validateLicenseKey(String key, boolean saveToDisk) {
//        License licenseKeyObject = LicenseValidator.validate(
//                key,
//                publickey,
//                internalString,
//                nameforValidation,
//                companyforValidation,
//                hardwareIDMethod);
//
//        /**
//         * If key is valid and saveToDisk argument is true, then save license
//         * key to license key file on disk to use on next startup.
//         */
//        if (saveToDisk && licenseKeyObject.getValidationStatus() == ValidationStatus.LICENSE_VALID) {
//            try {
//                FileUtils.writeFile(licenseFileOnDisk, licenseKeyObject.getLicenseString());
//            } catch (IOException ex) {
//                LOGGER.error("ERROR: Cannot save validated license key to file: " + licenseFileOnDisk, ex);
//            }
//        }
//
//        /**
//         * Return license key object to check validation status.
//         */
//        return licenseKeyObject;
//    }
//
//    public static License validateLicenseText(String text, boolean saveToDisk) {
//        /**
//         * If text is not null, then validate it.
//         */
//        License licenseTextObject = LicenseValidator.validate(
//                text,
//                publickey,
//                productID,
//                productEdition,
//                productVersion,
//                null,
//                null);
//
//        /**
//         * If text is valid and saveToDisk argument is true, then save license
//         * text to license text file on disk to use on next startup.
//         */
//        if (saveToDisk && licenseTextObject.getValidationStatus() == ValidationStatus.LICENSE_VALID) {
//            try {
//                FileUtils.writeFile(licenseFileOnDisk, licenseTextObject.getLicenseString());
//            } catch (IOException ex) {
//                LOGGER.error("ERROR: Cannot save validated license text to file: " + licenseFileOnDisk, ex);
//            }
//        }
//
//        /**
//         * Return license text object to check validation status.
//         */
//        return licenseTextObject;
//    }
//
//    public static License activateLicense(License license, boolean saveToDisk) {
//
//
//        License activatedLicense = LicenseValidator.autoActivate(license, ActivationServer);
////        License activatedLicense = LicenseValidator.autoActivate(license, "http://localhost:8090/algas/");
//
//        /**
//         * If activation status is ACTIVATION_COMPLETED saveToDisk argument is
//         * true, then save activated license to license file on disk to use on
//         * next startup.
//         */
//        if (saveToDisk && activatedLicense.getActivationStatus() == ActivationStatus.ACTIVATION_COMPLETED) {
//            try {
//                FileUtils.writeFile(licenseFileOnDisk, activatedLicense.getLicenseString());
//            } catch (IOException ex) {
//                LOGGER.error("ERROR: Cannot save activated license to file: " + licenseFileOnDisk, ex);
//            }
//        }
//
//        return activatedLicense;
//    }
//
//    public static License deActivateLicense(License license) throws FileLockInterruptionException {
//        License deActivatedLicense = LicenseValidator.autoDeactivate(license, ActivationServer);
////        License activatedLicense = LicenseValidator.autoActivate(license, "http://localhost:8090/algas/");
//        LOGGER.info("deActivatedLicense = " + deActivatedLicense.getActivationStatus());
//        if (deActivatedLicense.getActivationStatus() == ActivationStatus.DEACTIVATION_COMPLETED) {
//            LOGGER.info("deActivatedLicense = " + deActivatedLicense.getActivationStatus());
//            try {
//                File licenseFile = new File(licenseFileOnDisk);
//                if (licenseFile.exists()) {
//                    licenseFile.delete();
//                }
//            } catch (Exception ex) {
//                LOGGER.error("ERROR: Cannot delete DeActivated license file: " + licenseFileOnDisk, ex);
//                throw new FileLockInterruptionException();
//            }
//        }
//
//        return deActivatedLicense;
//    }
//
//    public static LicenseText getLicenseTextObj() throws IOException, LicenseSecurityException {
//        return new LicenseText(FileUtils.readFile(licenseFileOnDisk).trim(), publickey);
//    }
//}
