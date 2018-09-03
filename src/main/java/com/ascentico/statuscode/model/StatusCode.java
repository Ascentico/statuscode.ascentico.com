package com.ascentico.statuscode.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@ApiModel(value="StatusCode", description="Model that contains HTTP status code details")
@Entity
@Table(name = "sc_statusCode")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StatusCode {

    @ApiModelProperty(value = "HTTP status code value")
    @Id
    @Column(name = "statusCode")
    private int statusCode;

    @ApiModelProperty(value = "Short description of the HTTP status code")
    @Column(name = "shortDescription")
    private String shortDescription;

    @ApiModelProperty(value = "Long description of the HTTP status code")
    @Column(name = "longDescription", length = 1000)
    private String longDescription;

    @ApiModelProperty(value = "Link to the HTTP status code RFC, if available")
    @Column(name = "rfcUri", length = 1000)
    private String rfcUri;

    public StatusCode() {

    }

    public StatusCode(int statusCode, String shortDescription, String longDescription, String rfcUri) {
        this.setStatusCode(statusCode);
        this.setShortDescription(shortDescription);
        this.setLongDescription(longDescription);
        this.setRfcUri(rfcUri);
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
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

    public String getRfcUri() {
        return rfcUri;
    }

    public void setRfcUri(String rfcUri) {
        this.rfcUri = rfcUri;
    }

    @Override
    public String toString() {
        return "StatusCode{" +
                "statusCode=" + statusCode +
                ", shortDescription='" + shortDescription + '\'' +
                ", longDescription='" + longDescription + '\'' +
                '}';
    }
}
