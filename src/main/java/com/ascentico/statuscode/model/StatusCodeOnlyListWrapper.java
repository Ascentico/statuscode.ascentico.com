package com.ascentico.statuscode.model;

import io.swagger.annotations.ApiModel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@ApiModel(value="StatusCodeOnlyListWrapper", description="Model that contains a list of HTTP status codes used for bulk lookups")
public class StatusCodeOnlyListWrapper implements Iterable<Integer> {

    private List<Integer> statusCodeList = new ArrayList<Integer>();

    public List<Integer> getStatusCodes() {
        return statusCodeList;
    }

    public void setStatusCodes(List<Integer> statusCodeList) {
        this.statusCodeList = statusCodeList;
    }

    @Override
    public Iterator<Integer> iterator() {
        return statusCodeList.iterator();
    }

    @Override
    public String toString() {
        return "StatusCodeOnlyListWrapper{" +
                "statusCodeList=" + statusCodeList +
                '}';
    }
}