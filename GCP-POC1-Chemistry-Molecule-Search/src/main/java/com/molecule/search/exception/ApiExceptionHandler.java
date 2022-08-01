package com.molecule.search.exception;

import io.swagger.annotations.Api;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;


import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = ApiRequestException.class)
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<Object> handleApiRequestException(ApiRequestException ex){
        HttpStatus okRequest=HttpStatus.OK;
        ApiException apiException=new ApiException(
                ex.getMessage(),
                okRequest,
                ZonedDateTime.now(ZoneId.of("Z")));
        return new ResponseEntity<>(apiException, okRequest);
    }

    @ExceptionHandler(value = BadRequestException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object>handleBadRequest(BadRequestException badRequestException){
        HttpStatus badRequest=HttpStatus.BAD_REQUEST;
        ApiException apiException=new ApiException(
                badRequestException.getMessage(),
                badRequest,
                ZonedDateTime.now(ZoneId.of("Z")));

        return new ResponseEntity<>(apiException,badRequest);
    }

    @ExceptionHandler(value = ResourceNotFoundException.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public ResponseEntity<Object>handleNoDataFoundException(ResourceNotFoundException resourceNotFoundException){
        HttpStatus notFound=HttpStatus.NOT_FOUND;
        ApiException apiException=new ApiException(
                resourceNotFoundException.getMessage(),
                notFound,
                ZonedDateTime.now(ZoneId.of("Z")));
        return new ResponseEntity<>(apiException,notFound);
    }

    @ExceptionHandler(value = DefaultException.class)
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Object>handleGlobalException(Exception exception, WebRequest request){
        HttpStatus internalServerError=HttpStatus.INTERNAL_SERVER_ERROR;
        ApiException apiException=new ApiException(
                exception.getMessage(),
                internalServerError,ZonedDateTime.now(ZoneId.of("Z")));
        return new ResponseEntity<>(apiException,internalServerError);
    }
}
