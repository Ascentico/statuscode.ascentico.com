package com.ascentico.statuscode.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ascentico.statuscode.model.Healthcheck;
import com.ascentico.statuscode.repository.HealthcheckRepository;

import javax.transaction.Transactional;

@Service("healthcheckService")
@Transactional
public class HealthcheckServiceImpl implements HealthcheckService {

    @Autowired
    HealthcheckRepository healthcheckRepository;

    @Override
    public void saveHealthcheck(Healthcheck healthcheck) {
        healthcheckRepository.save(healthcheck);
    }

    @Override
    public boolean isHealthy() {
        return (healthcheckRepository.findDistinctByHealthcheckIdEquals(1L).getHealthcheckId() == 1L);
    }

}

