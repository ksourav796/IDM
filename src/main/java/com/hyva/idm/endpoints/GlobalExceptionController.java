package com.hyva.idm.endpoints;

import com.hyva.idm.exceptions.BadRequestException;
import com.hyva.idm.pojo.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Created by tnataraj on 1/15/18.
 */
@ControllerAdvice
@RequestMapping(produces = "application/vnd.error+json")
public class GlobalExceptionController extends ResponseEntityExceptionHandler {


    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ExceptionResponse> badRequestException(BadRequestException ex) {
        HttpStatus status = HttpStatus.valueOf(ex.getErrorCode());
        ExceptionResponse response = new ExceptionResponse();
        response.setErrorCode(HttpStatus.BAD_REQUEST.value());
        response.setErrorMessage(ex.getMessage());
        return new ResponseEntity<ExceptionResponse>(response, status);
    }




}
