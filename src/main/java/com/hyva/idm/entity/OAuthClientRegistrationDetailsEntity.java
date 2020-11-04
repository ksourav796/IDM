package com.hyva.idm.entity;

/**
 * Created by tnataraj on 1/6/18.
 */
public class OAuthClientRegistrationDetailsEntity {

    private String applicationName;
    private String redirect_URL;
    private String grantType;


    /**
     * Sets new applicationName.
     *
     * @param applicationName New value of applicationName.
     */
    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    /**
     * Gets grantType.
     *
     * @return Value of grantType.
     */
    public String getGrantType() {
        return grantType;
    }

    /**
     * Gets redirect_URL.
     *
     * @return Value of redirect_URL.
     */
    public String getRedirect_URL() {
        return redirect_URL;
    }

    /**
     * Sets new grantType.
     *
     * @param grantType New value of grantType.
     */
    public void setGrantType(String grantType) {
        this.grantType = grantType;
    }

    /**
     * Gets applicationName.
     *
     * @return Value of applicationName.
     */
    public String getApplicationName() {
        return applicationName;
    }

    /**
     * Sets new redirect_URL.
     *
     * @param redirect_URL New value of redirect_URL.
     */
    public void setRedirect_URL(String redirect_URL) {
        this.redirect_URL = redirect_URL;
    }
}
