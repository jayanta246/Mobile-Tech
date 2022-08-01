package com.molecule.search.exception;

import java.util.NoSuchElementException;

public class ResourceNotFoundException extends NoSuchElementException {
    public ResourceNotFoundException() {
    }

    public ResourceNotFoundException(String s, Throwable cause) {
        super(s, cause);
    }

    public ResourceNotFoundException(String s) {
        super(s);
    }
}
