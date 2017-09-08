package com.dropbsoftware.userservice.exception;

import org.springframework.http.HttpStatus;

public enum ApplicationStatus {
    GENERIC_ERROR("Unexpected application error"),
    VALIDATION_ERROR(HttpStatus.BAD_REQUEST, "validation error");

    HttpStatus httpStatus;
    String errorMessage;

    ApplicationStatus(String errorMessage) {
        this(HttpStatus.INTERNAL_SERVER_ERROR, errorMessage);
    }

    ApplicationStatus(HttpStatus httpStatus, String errorMessage) {
        this.httpStatus = httpStatus;
        this.errorMessage = errorMessage;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public String getCode() {
        return "USER-SERVICE-" + this.ordinal();
    }
}
