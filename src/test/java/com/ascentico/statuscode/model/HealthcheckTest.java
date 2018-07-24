package com.ascentico.statuscode.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

public class HealthcheckTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void Ping_DefaultConstructor_Passes() throws Exception {
        Healthcheck healthcheckUnderTest = new Healthcheck();
        Assert.assertNull("Healthcheck() has failed as pingResponse contains data!", healthcheckUnderTest.getHealthcheckResponse());
    }

    @Test
    public void Ping_Constructor_Passes() throws Exception {
        Healthcheck healthcheckUnderTest = new Healthcheck("OK");
        Assert.assertEquals("Healthcheck() has failed as healthcheckResponse contains incorrect data!", "OK", healthcheckUnderTest.getHealthcheckResponse());
    }

    @Test
    public void Ping_setgetPingId_Passes() throws Exception {
        Healthcheck healthcheckUnderTest = new Healthcheck();
        healthcheckUnderTest.setHealthcheckId(99L);
        Assert.assertEquals("Healthcheck.setHealthcheckId has failed!", 99, (long)healthcheckUnderTest.getHealthcheckId());
    }

    @Test
    public void Ping_setgetPingResponse_Passes() throws Exception {
        Healthcheck healthcheckUnderTest = new Healthcheck();
        healthcheckUnderTest.setHealthcheckResponse("OK");
        Assert.assertEquals("Healthcheck().setgetPingResponse has failed!", "OK" , healthcheckUnderTest.getHealthcheckResponse());
    }

    @Test
    public void Ping_setgetPingDateTime_Passes() throws Exception {
        Healthcheck healthcheckUnderTest = new Healthcheck();
        LocalDateTime localDateTime = LocalDateTime.now();
        healthcheckUnderTest.setHealthcheckDateTime(localDateTime);

        Assert.assertEquals("Healthcheck().setHealthcheckDateTime has failed!", localDateTime, healthcheckUnderTest.getHealthcheckDateTime());

    }

}