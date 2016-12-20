package com.oriansolution.dwt.exception;

/**
 * Created by madhawa on 12/17/16.
 */
public class UserAndRoleNotFound extends DwtBaseException {
    public UserAndRoleNotFound(String message) {
        super(message);
    }

    public UserAndRoleNotFound(String message, Throwable cause) {
        super(message, cause);
    }
}
