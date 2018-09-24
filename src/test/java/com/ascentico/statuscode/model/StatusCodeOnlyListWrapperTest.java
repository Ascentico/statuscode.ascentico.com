package com.ascentico.statuscode.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class StatusCodeOnlyListWrapperTest {

    StatusCodeOnlyListWrapper statusCodeOnlyListWrapperUnderTest;

    @Before
    public void setUp() throws Exception {

        List<Integer> statusCodeList = new ArrayList<>();
        statusCodeList.add(100);
        statusCodeList.add(101);
        statusCodeList.add(102);
        statusCodeList.add(103);

        statusCodeOnlyListWrapperUnderTest = new StatusCodeOnlyListWrapper();
        statusCodeOnlyListWrapperUnderTest.setStatusCodes(statusCodeList);

    }

    @Test
    public void StatusCodeOnlyListWrapper_setgetStatusCodes_Passes() {

        List<Integer> statusCodeList = new ArrayList<>();
        statusCodeList.add(100);
        statusCodeList.add(101);
        statusCodeList.add(102);
        statusCodeList.add(103);

        StatusCodeOnlyListWrapper statusCodeOnlyListWrapperUnderTest = new StatusCodeOnlyListWrapper();
        statusCodeOnlyListWrapperUnderTest.setStatusCodes(statusCodeList);

        Assert.assertEquals("StatusCodeOnlyListWrapper.setgetStatusCodes() has failed!",statusCodeList,statusCodeOnlyListWrapperUnderTest.getStatusCodes());

    }

    @Test
    public void StatusCodeOnlyListWrapper_toString_Passes() {
        Assert.assertEquals( "StatusCodeOnlyListWrapper.toString() has failed!",
                "StatusCodeOnlyListWrapper{statusCodeList=[100, 101, 102, 103]}",
                statusCodeOnlyListWrapperUnderTest.toString());
    }

}