package com.ascentico.statuscode.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ppl_healthcheck")
public class Healthcheck {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "healthcheckId", columnDefinition = "serial")
    private Long healthcheckId;

    @Column(name = "healthcheckDateTime")
    private LocalDateTime healthcheckDateTime;

    @Column(name = "healthcheckResponse", length = 30)
    private String healthcheckResponse;

    public Healthcheck() {

    }

    public Healthcheck(String healthcheckResponse) {
        this.healthcheckResponse = healthcheckResponse;
    }

    public Long getHealthcheckId() {
        return healthcheckId;
    }

    public void setHealthcheckId(Long healthcheckId) {
        this.healthcheckId = healthcheckId;
    }

    public LocalDateTime getHealthcheckDateTime() {
        return healthcheckDateTime;
    }

    public void setHealthcheckDateTime(LocalDateTime healthcheckDateTime) {
        this.healthcheckDateTime = healthcheckDateTime;
    }

    public String getHealthcheckResponse() {
        return healthcheckResponse;
    }

    public void setHealthcheckResponse(String healthcheckResponse) {
        this.healthcheckResponse = healthcheckResponse;
    }

    @Override
    public String toString() {
        return "Healthcheck{" +
                "healthcheckId=" + healthcheckId +
                ", healthcheckDateTime=" + healthcheckDateTime +
                ", healthcheckResponse='" + healthcheckResponse + '\'' +
                '}';
    }
}
