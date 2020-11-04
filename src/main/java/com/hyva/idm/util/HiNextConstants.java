package com.hyva.idm.util;

public class HiNextConstants {

    String APARCODE_NONE = "NONE";
    String APARCODE_ALL = "ALL";
    String APARCODE_AP = "AP";
    String APARCODE_AR = "AR";
    String SERVICE = "Service";
    String RETAIL = "Retail";
    String FANDB = "FandB";
    String FULL_VERSION = "FullVersion";
    int TERMS_LENGTH = 5000;
    /**
     * This is the keyword has to be there in the session based on this keyword
     * sessionFactory will be chosen.
     */
    String DATABASE_KEYWORD = "DatabaseKeyWord";
    //this is the key word for masterDatabase and sessionFactory Name also.
    String MASTER_DATABASE_KEYWORD = "hiaccountsmdb";
    String IMAGE_SERVER = "/hiaccountsimages/";
    String DATABASE = "database";
    String HOST = "host";
    String PORT = "port";
    String USERNAME = "username";
    String PASSWORD = "password";
    String BUILD = "build";
    String OFFLINE = "offline";
    String ONLINE = "online";
    String FEATURES = "features";
    String COMPANYDATA = "CompanyData";
    String Available = "Available";
    String USER_IN_SESSION = "userobj";
    int COOKIE_AGE = 1800;//in seconds
    String GST_CLASS_NAME = "GST Tax";
    String Posting = "Yes";
    String INVOICE_STATUS = "Cancelled";
    String PURCHASE_INVOICE_STATUS = "Closed";
    static final String PATH = "path";
    static final String EXTERNAL_PROPS_FILE = "DataBase.properties";
    static final String IMAGES_FOLDER_NAME = "HiAccounts_Images";
    static final String BACKUP_FOLDER_NAME = "HiAccounts_Databackup";
    static final String DOCS_FOLDER_NAME = "HiAccounts_Reports";
    String IN_PROGRESS = "In Progress";
    String GENERATED = "Generated";
    String ACTIVE = "Active";
    String INACTIVE = "InActive";
    String DEFAULT_TENANT_ID = "HIACC";
    String TENANT_DB_CONFIGS_OVERRIDE = "HICC";
    String TENANT_REGEX = "";
    String CURRENT_TENANT_ID = "current_tenant_id";
}
