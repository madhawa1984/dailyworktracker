package com.oriansolution.dwt.utility;

/**
 * Created by madhawa on 12/11/16.
 */
public class DWTError {
    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    private String errorCode;
    private String errorMessage;
}
