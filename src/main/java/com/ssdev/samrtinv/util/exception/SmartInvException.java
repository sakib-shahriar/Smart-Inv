package com.ssdev.samrtinv.util.exception;

public class SmartInvException extends RuntimeException {
    public SmartInvException() {
    }

    public SmartInvException(String message) {
        super(message);
    }

    public SmartInvException(String message, Throwable cause) {
        super(message, cause);
    }

    public SmartInvException(Throwable cause) {
        super(cause);
    }

    public SmartInvException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
