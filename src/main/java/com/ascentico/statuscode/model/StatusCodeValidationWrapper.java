package com.ascentico.statuscode.model;

import io.swagger.annotations.ApiModel;

@ApiModel(value="StatusCodeValidationWrapper", description="Model that contains HTTP status code and a boolean if it is a valid HTTP status code")
public class StatusCodeValidationWrapper {

    private StatusCode statusCode;
    private Boolean valid;

    public StatusCodeValidationWrapper() {
        this.statusCode = new StatusCode();
        this.valid = false;
    }

    public StatusCodeValidationWrapper(StatusCode statusCode, Boolean valid) {
        this.statusCode = statusCode;
        this.valid = valid;
    }

    public StatusCode getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(StatusCode statusCode) {
        this.statusCode = statusCode;
    }

    public Boolean isValid() {
        return valid;
    }

    public void isValid(Boolean valid) {
        this.valid = valid;
    }

    @Override
    public String toString() {
        return "StatusCodeValidationWrapper{" +
                "statusCode=" + statusCode +
                ", valid=" + valid +
                '}';
    }
}
