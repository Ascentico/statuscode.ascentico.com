package com.ascentico.statuscode.service;

import com.ascentico.statuscode.model.HealthCheck;

/**
 * The HealthCheckService interface
 *
 * @author  Andy McCall
 * @version 0.1
 * @since   2018-07-03
 */

public interface HealthCheckService {

    public void saveHealthCheck(HealthCheck healthCheck);
    public boolean isHealthy();

}
