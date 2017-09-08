package com.dropbsoftware.userservice.exception;

public class Status {
    String errorMessage;
    String errorCode;
    String causedMessage;

    public Status() {
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getCausedMessage() {
        return this.causedMessage;
    }

    public void setCausedMessage(String causedMessage) {
        this.causedMessage = causedMessage;
    }
}
