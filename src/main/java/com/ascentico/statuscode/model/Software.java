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

    @ApiModelProperty(value = "Name of the software")
    @Column(name = "softwareName")
    private String softwareName;

    public Software() {
    }

    public Software(String softwareName) {
        this.softwareName = softwareName;
    }

    public int getSoftwareId() {
        return softwareId;
    }

    public void setSoftwareId(int softwareId) {
        this.softwareId = softwareId;
    }

    public String getSoftwareName() {
        return softwareName;
    }

    public void setSoftwareName(String softwareName) {
        this.softwareName = softwareName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Software)) return false;
        Software software = (Software) o;
        return getSoftwareId() == software.getSoftwareId() &&
                Objects.equals(getSoftwareName(), software.getSoftwareName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSoftwareId(), getSoftwareName());
    }

    @Override
    public String toString() {
        return "Software{" +
                "softwareId=" + softwareId +
                ", softwareName='" + softwareName + '\'' +
                '}';
    }
}
