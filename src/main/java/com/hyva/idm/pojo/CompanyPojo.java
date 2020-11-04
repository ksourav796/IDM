package com.hyva.idm.pojo;


import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;

/**
 * Created by tnataraj on 1/15/18.
 */
public class CompanyPojo {
    @NotNull()
    private String companyName;

    @Email
    private String emailId;
    @NotNull
    private String keyWord;
    @NotNull
    private String companyType;
    @NotNull
    private String saasToken;

    /**
     * Gets companyType.
     *
     * @return Value of companyType.
     */
    public String getCompanyType() {
        return companyType;
    }

    /**
     * Sets new saasToken.
     *
     * @param saasToken New value of saasToken.
     */
    public void setSaasToken(String saasToken) {
        this.saasToken = saasToken;
    }

    /**
     * Sets new companyType.
     *
     * @param companyType New value of companyType.
     */
    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    /**
     * Gets emailId.
     *
     * @return Value of emailId.
     */
    public String getEmailId() {
        return emailId;
    }

    /**
     * Sets new keyWord.
     *
     * @param keyWord New value of keyWord.
     */
    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    /**
     * Sets new companyName.
     *
     * @param companyName New value of companyName.
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * Gets companyName.
     *
     * @return Value of companyName.
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * Sets new emailId.
     *
     * @param emailId New value of emailId.
     */
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    /**
     * Gets keyWord.
     *
     * @return Value of keyWord.
     */
    public String getKeyWord() {
        return keyWord;
    }

    /**
     * Gets saasToken.
     *
     * @return Value of saasToken.
     */
    public String getSaasToken() {
        return saasToken;
    }
}
