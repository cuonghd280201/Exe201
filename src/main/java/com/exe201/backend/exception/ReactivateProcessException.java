package com.exe201.backend.exception;

public class ReactivateProcessException extends RuntimeException {
    private String filterMessage;

    public ReactivateProcessException(String message) {
        super();
        this.filterMessage = message;
    }

    public String getFilterMessage() {
        return filterMessage;
    }
}
