package com.ascentico.statuscode.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StatusCodeTest {

    private StatusCode statusCodeUnderTest;

    /**
     * Sets up objects needed for the tests.
     */
    @Before
    public void setUp() throws Exception {
        statusCodeUnderTest = new StatusCode();
        statusCodeUnderTest.setStatusCode(226);
        statusCodeUnderTest.setShortDescription("IM Used");
        statusCodeUnderTest.setLongDescription("The server has fulfilled a request for the resource, and the response is a representation of the result of one or more instance-manipulations applied to the current instance.");
        statusCodeUnderTest.setRfcUri("https://tools.ietf.org/html/rfc3229");
    }

    /**
     * Test the StatusCode Default Constructor.
     * @result The StatusCode object will be constructed with no errors,
     *         and all accessor methods return with no data.
     */
    @Test
    public void StatusCode_DefaultConstructor_Passes() {
        StatusCode statusCodeUnderTest1 = new StatusCode();
        Assert.assertEquals("StatusCode() has failed as statusCode is not 0!", 0, statusCodeUnderTest1.getStatusCode());
        Assert.assertNull("StatusCode() has failed as shortDescription contains data!", statusCodeUnderTest1.getShortDescription());
        Assert.assertNull("StatusCode() has failed as longDescription contains data!", statusCodeUnderTest1.getLongDescription());
        Assert.assertNull("StatusCode() has failed as rfcUri contains data!", statusCodeUnderTest1.getRfcUri());
    }

    /**
     * Test the StatusCode Constructor.
     * @result The StatusCode object will be constructed with no errors,
     *         and all accessor methods return the data passed into the
     *         constructor.
     */
    @Test
    public void StatusCode_Constructor1_Passes() {
        StatusCode statusCodeUnderTest1 = new StatusCode(226,
                                                         "IM Used",
                "The server has fulfilled a request for the resource, and the response is a representation of the result of one or more instance-manipulations applied to the current instance.",
                "https://tools.ietf.org/html/rfc3229");

        Assert.assertEquals("StatusCode() has failed as statusCode contains incorrect data!", 226, statusCodeUnderTest1.getStatusCode());
        Assert.assertEquals("StatusCode() has failed as shortDescription contains incorrect data", "IM Used", statusCodeUnderTest1.getShortDescription());
        Assert.assertEquals("StatusCode() has failed as longDescription contains incorrect data", "The server has fulfilled a request for the resource, and the response is a representation of the result of one or more instance-manipulations applied to the current instance.", statusCodeUnderTest1.getLongDescription());
        Assert.assertEquals("StatusCode() has failed as rfcUri contains incorrect data!", "https://tools.ietf.org/html/rfc3229", statusCodeUnderTest1.getRfcUri());
    }

    /**
     * Test the StatusCode Constructor.
     * @result The StatusCode object will be constructed with no errors,
     *         and all accessor methods return the data passed into the
     *         constructor.
     */
    @Test
    public void StatusCode_Constructor2_Passes() {
        StatusCode statusCodeUnderTest1 = new StatusCode(208,
                                                         "Already Reported",
                                                         "The members of a DAV binding have already been enumerated in a preceding part of the (multistatus) response, and are not being included again.");

        Assert.assertEquals("StatusCode() has failed as statusCode contains incorrect data!", 208, statusCodeUnderTest1.getStatusCode());
        Assert.assertEquals("StatusCode() has failed as shortDescription contains incorrect data", "Already Reported", statusCodeUnderTest1.getShortDescription());
        Assert.assertEquals("StatusCode() has failed as longDescription contains incorrect data", "The members of a DAV binding have already been enumerated in a preceding part of the (multistatus) response, and are not being included again.", statusCodeUnderTest1.getLongDescription());
        Assert.assertNull("StatusCode() has failed as rfcUri contains incorrect data!", statusCodeUnderTest1.getRfcUri());
    }

    @Test
    public void StatusCode_setgetStatusCode_Passes() {
        StatusCode statusCodeUnderTest1 = new StatusCode();
        statusCodeUnderTest1.setStatusCode(226);
        Assert.assertEquals("StatusCode.setgetStatusCode() has failed as statusCode contains incorrect data!", 226, statusCodeUnderTest1.getStatusCode());
    }

    @Test
    public void StatusCode_setgetShortDescription_Passes() {
        StatusCode statusCodeUnderTest1 = new StatusCode();
        statusCodeUnderTest1.setShortDescription("IM Used");
        Assert.assertEquals("StatusCode.setgetShortDescription() as failed as shortDescription contains incorrect data!", "IM Used", statusCodeUnderTest1.getShortDescription());
    }

    @Test
    public void StatusCode_setgetLongDescription_Passes() {
        StatusCode statusCodeUnderTest1 = new StatusCode();
        statusCodeUnderTest1.setLongDescription("The server has fulfilled a request for the resource, and the response is a representation of the result of one or more instance-manipulations applied to the current instance.");
        Assert.assertEquals("StatusCode().setgetLongDescription() has failed as longDescription contains incorrect data", "The server has fulfilled a request for the resource, and the response is a representation of the result of one or more instance-manipulations applied to the current instance.", statusCodeUnderTest1.getLongDescription());
    }

    @Test
    public void StatusCode_setgetRfcUri_Passes() {
        StatusCode statusCodeUnderTest1 = new StatusCode();
        statusCodeUnderTest1.setRfcUri("https://tools.ietf.org/html/rfc3229");
        Assert.assertEquals("StatusCode().setgetRfcUri has failed as rfcUri contains incorrect data!", "https://tools.ietf.org/html/rfc3229", statusCodeUnderTest1.getRfcUri());
    }

    @Test
    public void StatusCode_toString_Passes() {
        Assert.assertEquals( "StatusCode.toString() has failed",
                "StatusCode{statusCode=226, shortDescription='IM Used', longDescription='The server has fulfilled a request for the resource, and the response is a representation of the result of one or more instance-manipulations applied to the current instance.'}",
                statusCodeUnderTest.toString());
    }
}