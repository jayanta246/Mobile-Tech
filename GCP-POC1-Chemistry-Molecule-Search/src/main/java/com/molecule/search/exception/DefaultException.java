package com.molecule.search.exception;

public class DefaultException extends Exception {
    public DefaultException() {
    }

    public DefaultException(String message) {
        super(message);
    }

    public DefaultException(String message, Throwable cause) {
        super(message, cause);
    }
}
