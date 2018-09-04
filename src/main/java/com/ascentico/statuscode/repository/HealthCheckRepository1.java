package com.ascentico.statuscode.repository;

import com.ascentico.statuscode.model.HealthCheck;
import org.springframework.data.repository.CrudRepository;

/**
 * The HealthCheckRepository class
 *
 * @author  Andy McCall
 * @version 0.1
 * @since   2018-07-02
 */

public interface HealthCheckRepository extends CrudRepository<HealthCheck, Long> {

    public HealthCheck findDistinctByHealthCheckIdEquals(Long healthCheckId);

}