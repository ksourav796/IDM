package com.hyva.idm.exceptions;

/**
 * Created by tnataraj on 1/20/18.
 */
public class NotFoundException extends RuntimeException {
    private int errorCode;
    public NotFoundException( String message) {
        super(message);
    }
    public NotFoundException(int code,String message) {
        super(message);
        this.errorCode = code;
    }

    /**
     * Sets new errorCode.
     *
     * @param errorCode New value of errorCode.
     */
    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    /**
     * Gets errorCode.
     *
     * @return Value of errorCode.
     */
    public int getErrorCode() {
        return errorCode;
    }
}
