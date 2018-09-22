package com.ascentico.statuscode.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StatusCodeValidationWrapperTest {

    StatusCode statusCode;

    /**
     * Sets up objects needed for the tests.
     */
    @Before
    public void setUp() throws Exception {
        statusCode = new StatusCode();
        statusCode.setStatusCode(226);
        statusCode.setShortDescription("IM Used");
        statusCode.setLongDescription("The server has fulfilled a request for the resource, and the response is a representation of the result of one or more instance-manipulations applied to the current instance.");
        statusCode.setRfcUri("https://tools.ietf.org/html/rfc3229");
    }

    /**
     * Test the StatusCodeValidationWrapper Default Constructor.
     * @result The StatusCodeValidationWrapper object will be constructed with no errors,
     *         and all accessor methods return with no data.
     */
    @Test
    public void StatusCodeValidationWrapper_DefaultConstructor_Passes() {
        StatusCodeValidationWrapper statusCodeValidationWrapperUnderTest =
                new StatusCodeValidationWrapper();
        Assert.assertEquals("StatusCodeValidationWrapper() has failed as statusCode is not null!",
                new StatusCode(),
                statusCodeValidationWrapperUnderTest.getStatusCode());
        Assert.assertFalse("StatusCodeValidationWrapper() has failed as valid is not false!",
                statusCodeValidationWrapperUnderTest.isValid());
     }

    @Test
    public void StatusCodeValidationWrapper_Constuctor1_Passes() {

        StatusCodeValidationWrapper statusCodeValidationWrapperUnderTest =
                new StatusCodeValidationWrapper(statusCode, true);

        Assert.assertEquals("StatusCodeValidationWrapper() has failed as statusCode contains incorrect data!", statusCode, statusCodeValidationWrapperUnderTest.getStatusCode());
        Assert.assertTrue("StatusCodeValidationWrapper() has failed as valid is not true!",
                statusCodeValidationWrapperUnderTest.isValid());
    }

    @Test
    public void StatusCodeValidationWrapper_setgetStatusCode_Passes() {
        StatusCodeValidationWrapper statusCodeValidationWrapperUnderTest =
                new StatusCodeValidationWrapper();

        statusCodeValidationWrapperUnderTest.setStatusCode(statusCode);
        statusCodeValidationWrapperUnderTest.isValid(true);

        Assert.assertEquals("StatusCodeValidationWrapper() has failed as statusCode contains incorrect data!", statusCode, statusCodeValidationWrapperUnderTest.getStatusCode());
        Assert.assertTrue("StatusCodeValidationWrapper() has failed as valid is not true!",
                statusCodeValidationWrapperUnderTest.isValid());
    }

    @Test
    public void StatusCodeValidationWrapper_isValid_Passes() {
        StatusCodeValidationWrapper statusCodeValidationWrapperUnderTest =
                new StatusCodeValidationWrapper();

        statusCodeValidationWrapperUnderTest.isValid(false);

        Assert.assertFalse("StatusCodeValidationWrapper() has failed as valid is not true!",
                statusCodeValidationWrapperUnderTest.isValid());
    }

    @Test
    public void StatusCodeValidationWrapper_toString_Passes() {
        StatusCodeValidationWrapper statusCodeValidationWrapperUnderTest =
                new StatusCodeValidationWrapper(statusCode, true);
        Assert.assertEquals( "StatusCodeValidationWrapper.toString() has failed",
                "StatusCodeValidationWrapper{statusCode=StatusCode{statusCode=226, shortDescription='IM Used', longDescription='The server has fulfilled a request for the resource, and the response is a representation of the result of one or more instance-manipulations applied to the current instance.'}, valid=true}",
                statusCodeValidationWrapperUnderTest.toString());
    }
}