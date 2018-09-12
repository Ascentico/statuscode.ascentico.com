package com.ascentico.statuscode.model;

import io.swagger.annotations.ApiModel;

@ApiModel(value="StatusCodeValidationWrapper", description="Model that contains HTTP status code and a boolean if it is a valid HTTP status code")
public class StatusCodeValidationWrapper {

    private Integer statusCode;
    private Boolean valid;

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public Boolean getValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
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
