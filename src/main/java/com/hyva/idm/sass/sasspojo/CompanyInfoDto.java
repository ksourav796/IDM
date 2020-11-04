/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hyva.idm.sass.sasspojo;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class CompanyInfoDto implements Serializable {
    //============================================== Company ================================================================================
    private Long tempId;
//    private Long companyId;
    private String lang;
    private Long countryId;
    private boolean registeredCompany;
    private String registerNo;
    private String company_name;
    private String company_no;
    private String address;
    private String phone;
    private String fax;
    private String email;
    private String web;
    private String incdate;
    private Long currencyId;
    private String accCodeSep;
    private int gstId;
    private Long industryClassificationId;
    private Long businessTypeId;
    private String logo;
    private Date GSTRegisteredDate;
//    private CompanyInfoDTO companyId;
    private String panNumber;
    //=========================================================================================================================================
    private String yearclosing;
    private String startperiod;
    private String closingperiod;
    private String startyear;
    private String endyear;
    private String closingMethod;
    private int bufferDays;
    private String gstRegisteredDate;
    private String bufferDate;
    //================================================================ Chart of Accounts =====================================================
    private String createOrSelectAM;
//    private Collection<BasicChartAccounts> coaBLDBList;
//    private Collection<BasicChartAccounts> coaPLDBList;
    //================================================================ File Company ==========================================================    
//    private MultipartFile myFile;
//    private byte[] imageBlob;
//    private String myFileContentType;
//    private String myFileFileName;
    //========================================================================================================================================
    private boolean accreceivable;
    private boolean accpayable;
    private boolean recurring;
    private boolean registrationalert;
    private boolean gstreturnalert;
    private boolean debatoralert;
    private boolean creditoralert;
    private boolean dueMounthly;
    private boolean dueYearly;
    private Integer notaccReceivable;
    private Integer notaccPayable;
    private Integer notRegistration;
    private Integer notGSTReturn;
    private Integer notDebator;
    private Integer notCreditor;
    private Integer notDueMonthly;
    private Integer notDueYearly;
    private Integer accreceivabledue;
    private Integer accpayabledue;
    private Integer registrationdue;
    private Integer gstreturnalertdue;
    private String gstreturnalertduedate;
    private boolean accPayable;
    private boolean registrationAlert;
    private boolean accReceivable;
    private boolean gstReturnAlert;
    private String CoaCodeImport;
    private boolean comprehensiveScheme;
    private String panNo;
//    private State stateId;
    private Long stateId;
    private String stateName;
    private String fileName;
    private String sassOrdersId;


}
