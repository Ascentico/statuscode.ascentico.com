package com.ascentico.statuscode.controller;

import com.ascentico.statuscode.model.HealthCheck;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ascentico.statuscode.model.MaintenanceType;
import com.ascentico.statuscode.service.HealthCheckService;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicBoolean;

@RestController
public class HealthCheckController {

    private static final Logger logger =
            LoggerFactory.getLogger(HealthCheckController.class);

    private final AtomicBoolean maintenanceModeEnabled = new AtomicBoolean();

    HealthCheckService healthCheckService;
    HealthCheck lastHealthCheck = new HealthCheck();

    @Autowired
    public void setHealthCheckService(HealthCheckService healthCheckService) {
        this.healthCheckService = healthCheckService;
    }

    @RequestMapping(value = "/healthcheck", method = RequestMethod.GET)
    public ResponseEntity<HealthCheck> healthCheck(
            @RequestParam(value = "maintenance", required = false) final String maintenanceMode) throws Exception {
        toggleMaintenanceMode(maintenanceMode);

        logger.debug("Entering healthcheck");

        HealthCheck healthCheck = new HealthCheck();
        healthCheck.setHealthCheckDateTime(LocalDateTime.now());

        if (maintenanceModeEnabled.get()) {
            healthCheck.setHealthCheckResponse(MaintenanceType.MAINTENANCE.getDisplayName());
        } else if (isHealthy()) {
            healthCheck.setHealthCheckResponse(MaintenanceType.OK.getDisplayName());
        } else {
            healthCheck.setHealthCheckResponse(MaintenanceType.DOWN.getDisplayName());
        }

        if (lastHealthCheck.getHealthCheckResponse() != healthCheck.getHealthCheckResponse()) {
            healthCheckService.saveHealthCheck(healthCheck);
            lastHealthCheck.setHealthCheckResponse(healthCheck.getHealthCheckResponse());
            lastHealthCheck.setHealthCheckId(healthCheck.getHealthCheckId());
            lastHealthCheck.setHealthCheckDateTime(healthCheck.getHealthCheckDateTime());
        }


        return new ResponseEntity<>(lastHealthCheck, HttpStatus.OK);
    }

    private boolean isHealthy() {

        boolean allIsHealthy;

        try {
            allIsHealthy = healthCheckService.isHealthy();
        } catch (Exception e) {
            allIsHealthy = false;
        }

        return allIsHealthy;
    }

    private void toggleMaintenanceMode(final String maintenanceMode) throws Exception {
        if ("true".equalsIgnoreCase(maintenanceMode) || "false".equalsIgnoreCase(maintenanceMode)) {

            logger.info("Setting maintenanceMode to " + maintenanceMode);

            maintenanceModeEnabled.set(Boolean.valueOf(maintenanceMode));

        }
    }

}
