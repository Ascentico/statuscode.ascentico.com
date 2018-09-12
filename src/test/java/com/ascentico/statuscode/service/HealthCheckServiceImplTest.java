package com.ascentico.statuscode.service;

import com.ascentico.statuscode.model.HealthCheck;
import com.ascentico.statuscode.repository.HealthCheckRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

/**
 * The HealthCheckServiceImplTest class is a class that
 * tests all the implemented method in the HealthCheckService
 * interface.
 *
 * @author Andy McCall
 * @version 0.1
 * @since 2018-09-04
 */

public class HealthCheckServiceImplTest {

    @Mock
    private HealthCheckRepository mockHealthCheckRepository;

    @InjectMocks
    private HealthCheckService mockedHealthCheckService = new HealthCheckServiceImpl();

    private HealthCheck healthCheckOK = new HealthCheck();
    LocalDateTime localDateTime = LocalDateTime.now();


    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);

        healthCheckOK.setHealthCheckId(1L);
        healthCheckOK.setHealthCheckResponse("OK");
        healthCheckOK.setHealthCheckDateTime(localDateTime);

        when(mockHealthCheckRepository.getLastHealthCheck()).thenReturn(healthCheckOK);

    }

    /**
     * Tests HealthCheckServiceImpl.findDistinctByStatusCodeEquals() with a valid StatusCode
     */
    @Test
    public void StatusCodeServiceImpl_findDistinctByStatusCodeEquals_ValidStatusCode_Passes() {
        HealthCheck foundHealthCheckOK = mockedHealthCheckService.getLastHealthCheck();
    }

}