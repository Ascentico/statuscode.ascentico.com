package com.ascentico.statuscode.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;

import java.util.ArrayList;
import java.util.List;

@ApiModel(value="StatusCodeValidationWrapper", description="Model that contains HTTP status code and a boolean if it is a valid HTTP status code")
public class StatusCodeValidationWrapper {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<StatusCode> statusCodeList;
    private Boolean valid;

    public StatusCodeValidationWrapper() {
        this.statusCodeList = new ArrayList<>();
        this.valid = false;
    }

    public StatusCodeValidationWrapper(List<StatusCode> statusCodeList) {
        this.setStatusCodeList(statusCodeList);
    }

    public List<StatusCode> getStatusCodeList() {
        return statusCodeList;
    }

    public void setStatusCodeList(List<StatusCode> statusCodeList) {
        if (statusCodeList != null) {
            this.statusCodeList = statusCodeList;
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
                "statusCodeList=" + statusCodeList +
                ", valid=" + valid +
                '}';
    }
}
