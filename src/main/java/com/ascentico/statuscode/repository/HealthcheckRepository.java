package com.ascentico.statuscode.repository;

import org.springframework.data.repository.CrudRepository;
import com.ascentico.statuscode.model.Healthcheck;

/**
 * The HealthcheckRepository class
 *
 * @author  Andy McCall
 * @version 0.1
 * @since   2018-07-02
 */
public interface HealthcheckRepository extends CrudRepository<Healthcheck, Long> {

    public Healthcheck findDistinctByHealthcheckIdEquals(Long healthcheckId);

}