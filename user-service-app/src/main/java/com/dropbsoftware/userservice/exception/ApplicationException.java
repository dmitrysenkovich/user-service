package com.dropbsoftware.userservice.exception;

import org.springframework.http.HttpStatus;

public class ApplicationException extends RuntimeException {

    private final ApplicationStatus applicationStatus;

    public ApplicationException(ApplicationStatus applicationStatus) {
        this(null, applicationStatus);
    }

    public ApplicationException(Throwable cause, ApplicationStatus applicationStatus) {
        super(cause);
        this.applicationStatus = applicationStatus;
    }

    public HttpStatus getHttpStatus() {
        return applicationStatus.getHttpStatus();
    }

    public String getCode() {
        return applicationStatus.getCode();
    }
}
