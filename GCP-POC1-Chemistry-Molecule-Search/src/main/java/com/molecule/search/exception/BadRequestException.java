package com.molecule.search.exception;

import org.springframework.web.bind.MissingServletRequestParameterException;


public class BadRequestException extends MissingServletRequestParameterException{

    public BadRequestException(String parameterName, String parameterType) {
        super(parameterName, parameterType);
    }

    public BadRequestException(String parameterName, String parameterType, boolean missingAfterConversion) {
        super(parameterName, parameterType, missingAfterConversion);
    }
}
