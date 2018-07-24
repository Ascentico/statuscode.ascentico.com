package com.ascentico.statuscode.model;

public class StatusDetail {

    private int statusCode;
    private String shortDescription;
    private String longDescription;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getSpacedStatusCode() {
        return String.valueOf(statusCode).replaceAll(".(?=.)", "$0 ");
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    @Override
    public String toString() {
        return "StatusDetail{" +
                "statusCode=" + statusCode +
                ", shortDescription='" + shortDescription + '\'' +
                ", longDescription='" + longDescription + '\'' +
                '}';
    }
}
