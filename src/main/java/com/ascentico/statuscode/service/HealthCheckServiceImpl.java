package com.ascentico.statuscode.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ascentico.statuscode.model.HealthCheck;
import com.ascentico.statuscode.repository.HealthCheckRepository;

import javax.transaction.Transactional;

@Service("healthCheckService")
@Transactional
public class HealthCheckServiceImpl implements HealthCheckService {

    @Autowired
    HealthCheckRepository healthCheckRepository;

    @Override
    public void saveHealthCheck(HealthCheck healthCheck) {
        healthCheckRepository.save(healthCheck);
    }

    @Override
    public boolean isHealthy() {
        return (healthCheckRepository.findDistinctByHealthCheckIdEquals(1L).getHealthCheckId() == 1L);
    }

}

