package com.wizeline.model;

public class ErrorBean {
    /**
     ** Attribute errorCode: Save error code id
	 */
    String errorCode;
    /**
     * Attribute message: Save error message
     */
    String message;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
