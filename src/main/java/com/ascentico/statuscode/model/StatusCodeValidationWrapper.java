package com.ascentico.statuscode.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;

@ApiModel(value="StatusCodeValidationWrapper", description="Model that contains HTTP status code and a boolean if it is a valid HTTP status code")
public class StatusCodeValidationWrapper {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private StatusCode statusCode;
    private Boolean valid;

    public StatusCodeValidationWrapper() {
        this.statusCode = new StatusCode();
        this.valid = false;
    }

    public StatusCodeValidationWrapper(StatusCode statusCode) {
        this.setStatusCode(statusCode);
    }

    public StatusCode getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(StatusCode statusCode) {
        if (statusCode != null) {
            this.statusCode = statusCode;
            this.valid = true;
        } else {
            this.valid = false;
        }
    }

    public Boolean isValid() {
        return valid;
    }

    @Override
    public String toString() {
        return "StatusCodeValidationWrapper{" +
                "statusCode=" + statusCode +
                ", valid=" + valid +
                '}';
    }
}
