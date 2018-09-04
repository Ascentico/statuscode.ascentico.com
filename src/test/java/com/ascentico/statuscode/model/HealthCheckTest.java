package com.ascentico.statuscode.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

public class HealthCheckTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void HealthCheck_DefaultConstructor_Passes() throws Exception {
        HealthCheck healthCheckUnderTest = new HealthCheck();
        Assert.assertNull("HealthCheck() has failed as HealthCheckResponse contains data!", healthCheckUnderTest.getHealthCheckResponse());
    }

    @Test
    public void HealthCheck_Constructor_Passes() throws Exception {
        HealthCheck healthCheckUnderTest = new HealthCheck("OK");
        Assert.assertEquals("HealthCheck() has failed as healthCheckResponse contains incorrect data!", "OK", healthCheckUnderTest.getHealthCheckResponse());
    }

    @Test
    public void HealthCheck_setgetHealthCheckId_Passes() throws Exception {
        HealthCheck healthCheckUnderTest = new HealthCheck();
        healthCheckUnderTest.setHealthCheckId(99L);
        Assert.assertEquals("HealthCheck.setHealthCheckId has failed!", 99, (long) healthCheckUnderTest.getHealthCheckId());
    }

    @Test
    public void HealthCheck_setgetHealthCheckResponse_Passes() throws Exception {
        HealthCheck healthCheckUnderTest = new HealthCheck();
        healthCheckUnderTest.setHealthCheckResponse("OK");
        Assert.assertEquals("HealthCheck().setgetHealthCheckResponse has failed!", "OK" , healthCheckUnderTest.getHealthCheckResponse());
    }

    @Test
    public void HealthCheck_setgetHealthCheckDateTime_Passes() throws Exception {
        HealthCheck healthCheckUnderTest = new HealthCheck();
        LocalDateTime localDateTime = LocalDateTime.now();
        healthCheckUnderTest.setHealthCheckDateTime(localDateTime);

        Assert.assertEquals("HealthCheck().setHealthCheckDateTime has failed!", localDateTime, healthCheckUnderTest.getHealthCheckDateTime());

    }

    @Test
    public void HealthCheck_toString_Passes() throws Exception {

        HealthCheck healthCheckUnderTest = new HealthCheck();
        healthCheckUnderTest.setHealthCheckId(1L);
        healthCheckUnderTest.setHealthCheckResponse("OK");
        LocalDateTime localDateTime = LocalDateTime.now();
        healthCheckUnderTest.setHealthCheckDateTime(localDateTime);

        String expectedString = "HealthCheck{healthCheckId=1, healthCheckDateTime=" + localDateTime + ", healthCheckResponse='OK'}";

        Assert.assertEquals("HealthCheck.toString() has failed",expectedString, healthCheckUnderTest.toString());
    }

}