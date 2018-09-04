package com.ascentico.statuscode.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "sc_healthCheck")
public class HealthCheck {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "healthCheckId", columnDefinition = "serial")
    private Long healthCheckId;

    @Column(name = "healthCheckDateTime")
    private LocalDateTime healthCheckDateTime;

    @Column(name = "healthCheckResponse", length = 30)
    private String healthCheckResponse;

    public HealthCheck() {

    }

    public HealthCheck(String healthCheckResponse) {
        this.setHealthCheckResponse(healthCheckResponse);
    }

    public Long getHealthCheckId() {
        return healthCheckId;
    }

    public void setHealthCheckId(Long healthCheckId) {
        this.healthCheckId = healthCheckId;
    }

    public LocalDateTime getHealthCheckDateTime() {
        return healthCheckDateTime;
    }

    public void setHealthCheckDateTime(LocalDateTime healthCheckDateTime) {
        this.healthCheckDateTime = healthCheckDateTime;
    }

    public String getHealthCheckResponse() {
        return healthCheckResponse;
    }

    public void setHealthCheckResponse(String healthCheckResponse) {
        this.healthCheckResponse = healthCheckResponse;
    }

    @Override
    public String toString() {
        return "HealthCheck{" +
                "healthCheckId=" + healthCheckId +
                ", healthCheckDateTime=" + healthCheckDateTime +
                ", healthCheckResponse='" + healthCheckResponse + '\'' +
                '}';
    }
}
