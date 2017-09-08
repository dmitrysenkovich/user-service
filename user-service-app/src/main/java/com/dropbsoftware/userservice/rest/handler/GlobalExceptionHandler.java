package com.dropbsoftware.userservice.rest.handler;

import com.dropbsoftware.userservice.exception.ApplicationException;
import com.dropbsoftware.userservice.exception.ApplicationStatus;
import com.dropbsoftware.userservice.exception.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(ApplicationException.class)
    @ResponseBody
    public ResponseEntity<ApplicationStatus> handleException(ApplicationException exception) {
        Status status = new Status();
        status.setErrorCode(exception.getCode());
        status.setErrorMessage(exception.getMessage());

        if (exception.getCause() != null) {
            status.setCausedMessage(exception.getCause().getMessage());
        }

        LOGGER.warn("Error occurred", exception);

        return new ResponseEntity(status, exception.getHttpStatus());
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public ResponseEntity<ApplicationStatus> handleException(RuntimeException exception) {
        return handleException(new ApplicationException(exception, ApplicationStatus.GENERIC_ERROR));
    }

    @Override
    protected ResponseEntity handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus httpStatus, WebRequest request) {
        return handleException(new ApplicationException(ex, ApplicationStatus.GENERIC_ERROR));
    }

    @Override
    protected ResponseEntity handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus httpStatus, WebRequest request) {
        return handleException(new ApplicationException(ex, ApplicationStatus.VALIDATION_ERROR));
    }
}
