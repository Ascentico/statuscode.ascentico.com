package com.ascentico.statuscode.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@ApiModel(value="StatusCodeType", description="Model that contains type of HTTP status code")
@Entity
@Table(name = "sc_status_code_type")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StatusCodeType {

    @ApiModelProperty(value = "HTTP status code type primary key")
    @Id
    @Column(name = "statusCodeTypeId", columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private int statusCodeTypeId;

    @ApiModelProperty(value = "Description of the HTTP status code type")
    @Column(name = "shortDescription")
    private String shortDescription;

    @ApiModelProperty(value = "Long description of the HTTP status code type")
    @Column(name = "longDescription", length = 1000)
    private String longDescription;

    public StatusCodeType() {
    }

    public StatusCodeType(int statusCodeTypeId, String shortDescription, String longDescription) {
        this.statusCodeTypeId = statusCodeTypeId;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
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
        return "StatusCodeType{" +
                "statusCodeTypeId=" + statusCodeTypeId +
                ", shortDescription='" + shortDescription + '\'' +
                ", longDescription='" + longDescription + '\'' +
                '}';
    }
}
