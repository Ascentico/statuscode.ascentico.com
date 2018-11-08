package com.ascentico.statuscode.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.Objects;

@ApiModel(value="Software", description="Model that contains software that uses unofficial HTTP status codes")
@Entity
@Table(name = "sc_software")
public class Software {

    @ApiModelProperty(value = "Software type primary key")
    @Id
    @Column(name = "softwareId", columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private int softwareId;

    @ApiModelProperty(value = "Short description of the software")
    @Column(name = "shortDescription")
    private String shortDescription;

    @ApiModelProperty(value = "Long description of the software")
    @Column(name = "longDescription", length = 1000)
    private String longDescription;

    public Software() {
    }

    public Software(String shortDescription, String longDescription) {
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
    }

    public int getSoftwareId() {
        return softwareId;
    }

    public void setSoftwareId(int softwareId) {
        this.softwareId = softwareId;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Software)) return false;
        Software software = (Software) o;
        return getSoftwareId() == software.getSoftwareId() &&
                Objects.equals(getShortDescription(), software.getShortDescription()) &&
                Objects.equals(getLongDescription(), software.getLongDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSoftwareId(), getShortDescription(), getLongDescription());
    }

    @Override
    public String toString() {
        return "Software{" +
                "softwareId=" + softwareId +
                ", shortDescription='" + shortDescription + '\'' +
                ", longDescription='" + longDescription + '\'' +
                '}';
    }
}
