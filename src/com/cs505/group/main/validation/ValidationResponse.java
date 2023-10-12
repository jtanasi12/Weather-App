package com.cs505.group.main.validation;

import java.util.List;

/**
 * author: Maurice Johnson
 *
 * This is a POJO that will contain attributes for
 * the response of the various validation strategies we are creating
 */
public class ValidationResponse {

    private boolean valid;
    private String message;
    private List<String> errors;

    public ValidationResponse() {
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    @Override
    public String toString() {
        return "ValidationResponse{" +
                "valid=" + valid +
                ", message='" + message + '\'' +
                ", errors=" + errors +
                '}';
    }
}
