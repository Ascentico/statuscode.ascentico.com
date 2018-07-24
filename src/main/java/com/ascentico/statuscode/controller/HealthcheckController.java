package com.ascentico.statuscode.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ascentico.statuscode.model.Healthcheck;
import com.ascentico.statuscode.model.MaintenanceType;
import com.ascentico.statuscode.service.HealthcheckService;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicBoolean;

@RestController
public class HealthcheckController {

    private static final Logger logger =
            LoggerFactory.getLogger(HealthcheckController.class);

    private final AtomicBoolean maintenanceModeEnabled = new AtomicBoolean();

    HealthcheckService healthcheckService;
    Healthcheck lastHealthcheck = new Healthcheck();

    @Autowired
    public void setHealthcheckService(HealthcheckService healthcheckService) {
        this.healthcheckService = healthcheckService;
    }

    @RequestMapping(value = "/healthcheck", method = RequestMethod.GET)
    public ResponseEntity<Healthcheck> healthcheck(
            @RequestParam(value = "maintenance", required = false) final String maintenanceMode) throws Exception {
        toggleMaintenanceMode(maintenanceMode);

        logger.debug("Entering healthcheck");

        Healthcheck healthcheck = new Healthcheck();
        healthcheck.setHealthcheckDateTime(LocalDateTime.now());

        if (maintenanceModeEnabled.get()) {
            healthcheck.setHealthcheckResponse(MaintenanceType.MAINTENANCE.getDisplayName());
        } else if (isHealthy()) {
            healthcheck.setHealthcheckResponse(MaintenanceType.OK.getDisplayName());
        } else {
            healthcheck.setHealthcheckResponse(MaintenanceType.DOWN.getDisplayName());
        }

        if (lastHealthcheck.getHealthcheckResponse() != healthcheck.getHealthcheckResponse()) {
            healthcheckService.saveHealthcheck(healthcheck);
            lastHealthcheck.setHealthcheckResponse(healthcheck.getHealthcheckResponse());
            lastHealthcheck.setHealthcheckId(healthcheck.getHealthcheckId());
            lastHealthcheck.setHealthcheckDateTime(healthcheck.getHealthcheckDateTime());
        }


        return new ResponseEntity<>(lastHealthcheck, HttpStatus.OK);
    }

    private boolean isHealthy() {

        boolean allIsHealthy;

        try {
            allIsHealthy = healthcheckService.isHealthy();
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
