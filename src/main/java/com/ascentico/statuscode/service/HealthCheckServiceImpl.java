package com.ascentico.statuscode.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ascentico.statuscode.model.HealthCheck;
import com.ascentico.statuscode.repository.HealthCheckRepository;

import javax.transaction.Transactional;

/**
 * The HealthCheckServiceImpl class implements the
 * HealthCheckService interface.
 *
 * @author  Andy McCall
 * @version 0.1
 * @since   2018-08-31
 */

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
    public HealthCheck getLastHealthCheck() {
        return healthCheckRepository.getLastHealthCheck();
    }

}

