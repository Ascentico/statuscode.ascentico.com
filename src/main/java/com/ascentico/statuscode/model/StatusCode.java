package com.ascentico.statuscode.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@ApiModel(value="StatusCode", description="Model that contains HTTP status code details")
@Entity
@Table(name = "sc_status_code")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StatusCode {

    @ApiModelProperty(value = "HTTP status code primary key")
    @Id
    @Column(name = "statusCodeId", columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private int statusCodeId;

    @ApiModelProperty(value = "HTTP status code value")
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

    @ManyToOne
    @JoinColumn(name="statusCodeTypeId")
    private StatusCodeType statusCodeType;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="sc_software_status_code", joinColumns={@JoinColumn(name="statusCodeId", referencedColumnName="statusCodeId")}
            , inverseJoinColumns={@JoinColumn(name="softwareId", referencedColumnName="softwareId")})
    private Set<Software> software;

    public StatusCode() {

    }

    public StatusCode(int statusCode, String shortDescription, String longDescription) {
        this.setStatusCode(statusCode);
        this.setShortDescription(shortDescription);
        this.setLongDescription(longDescription);
    }

    public StatusCode(int statusCode, String shortDescription, String longDescription, String rfcUri) {
        this.setStatusCode(statusCode);
        this.setShortDescription(shortDescription);
        this.setLongDescription(longDescription);
        this.setRfcUri(rfcUri);
    }

    public StatusCode(String shortDescription, String longDescription, String rfcUri, StatusCodeType statusCodeType) {
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
        this.rfcUri = rfcUri;
        this.statusCodeType = statusCodeType;
    }

    public StatusCode(String shortDescription, String longDescription, String rfcUri, StatusCodeType statusCodeType, Set<Software> software) {
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
        this.rfcUri = rfcUri;
        this.statusCodeType = statusCodeType;
        this.software = software;
    }

    public int getStatusCodeId() {
        return statusCodeId;
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

    public StatusCodeType getStatusCodeType() {
        return statusCodeType;
    }

    public void setStatusCodeType(StatusCodeType statusCodeType) {
        this.statusCodeType = statusCodeType;
    }


    public Set<Software> getSoftware() {
        return software;
    }

    public void setSoftware(Set<Software> software) {
        this.software = software;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StatusCode)) return false;
        StatusCode that = (StatusCode) o;
        return getStatusCodeId() == that.getStatusCodeId() &&
                getStatusCode() == that.getStatusCode() &&
                Objects.equals(getShortDescription(), that.getShortDescription()) &&
                Objects.equals(getLongDescription(), that.getLongDescription()) &&
                Objects.equals(getRfcUri(), that.getRfcUri()) &&
                Objects.equals(getStatusCodeType(), that.getStatusCodeType()) &&
                Objects.equals(getSoftware(), that.getSoftware());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStatusCodeId(), getStatusCode(), getShortDescription(), getLongDescription(), getRfcUri(), getStatusCodeType(), getSoftware());
    }

    @Override
    public String toString() {
        return "StatusCode{" +
                "statusCodeId=" + statusCodeId +
                ", statusCode=" + statusCode +
                ", shortDescription='" + shortDescription + '\'' +
                ", longDescription='" + longDescription + '\'' +
                ", rfcUri='" + rfcUri + '\'' +
                ", statusCodeType=" + statusCodeType +
                ", software=" + software +
                '}';
    }
}
