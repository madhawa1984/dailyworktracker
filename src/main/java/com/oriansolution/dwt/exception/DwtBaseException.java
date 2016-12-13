package com.oriansolution.dwt.exception;

/**
 * Created by madhawa on 12/11/16.
 */
public class DwtBaseException extends Exception {
    private final static String GENERIC_ERROR="Generic Error Occured on the DWT system.";
    public DwtBaseException(final String message) {
        super(new StringBuilder().append(GENERIC_ERROR).append(message).toString());
    }
    public DwtBaseException(final String message,Throwable cause) {
        super(new StringBuilder().append(GENERIC_ERROR).append(message).toString(),cause);
    }
}
