package com.ascentico.statuscode.service;

import com.ascentico.statuscode.model.Healthcheck;

/**
 * The HealthcheckService interface
 *
 * @author  Andy McCall
 * @version 0.1
 * @since   2018-07-03
 */

public interface HealthcheckService {

    public void saveHealthcheck(Healthcheck healthcheck);
    public boolean isHealthy();

}
