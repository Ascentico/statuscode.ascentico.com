package com.ascentico.statuscode.service;

import com.ascentico.statuscode.model.StatusCode;
import com.ascentico.statuscode.repository.StatusCodeRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

/**
 * The StatusCodeServiceImplTest class is a class that
 * tests all the implemented method in the StatusCodeService
 * interface.
 *
 * @author Andy McCall
 * @version 0.1
 * @since 2018-09-04
 */

public class StatusCodeServiceImplTest {

    @Mock
    private StatusCodeRepository mockStatusCodeRepository;

    @InjectMocks
    private StatusCodeService statusCodeService = new StatusCodeServiceImpl();

    private StatusCode statusCode1 = new StatusCode(226,
            "IM Used",
            "The server has fulfilled a request for the resource, and the response is a representation of the result of one or more instance-manipulations applied to the current instance.",
            "https://tools.ietf.org/html/rfc3229");

    private StatusCode statusCode2 = new StatusCode(208,
            "Already Reported",
            "The members of a DAV binding have already been enumerated in a preceding part of the (multistatus) response, and are not being included again.");


    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);

        when(mockStatusCodeRepository.findDistinctByStatusCodeEquals(226)).thenReturn(statusCode1);

        List<StatusCode> statusCodeList1 = new ArrayList<>();
        statusCodeList1.add(statusCode1);
        statusCodeList1.add(statusCode2);
        System.out.println(statusCodeList1.size());

        List<StatusCode> statusCodeList2 = new ArrayList<>();

        when(mockStatusCodeRepository.findAllByStatusCodeStartsWith(2)).thenReturn(statusCodeList1);
        when(mockStatusCodeRepository.findAllByStatusCodeStartsWith(7)).thenReturn(statusCodeList2);

    }

    /**
     * Tests StatusCodeServiceImpl.findDistinctByStatusCodeEquals() with a valid StatusCode
     */
    @Test
    public void StatusCodeServiceImpl_findDistinctByStatusCodeEquals_ValidStatusCode_Passes() throws Exception {

        StatusCode statusCode = statusCodeService.findDistinctByStatusCodeEquals(226);

        Assert.assertEquals("StatusCodeServiceImpl.findDistinctByStatusCodeEquals() has failed as statusCode contains incorrect data!", 226, statusCode.getStatusCode());
        Assert.assertEquals("StatusCodeServiceImpl.findDistinctByStatusCodeEquals() has failed as shortDescription contains incorrect data", "IM Used", statusCode.getShortDescription());
        Assert.assertEquals("StatusCodeServiceImpl.findDistinctByStatusCodeEquals() has failed as longDescription contains incorrect data", "The server has fulfilled a request for the resource, and the response is a representation of the result of one or more instance-manipulations applied to the current instance.", statusCode.getLongDescription());
        Assert.assertEquals("StatusCodeServiceImpl.findDistinctByStatusCodeEquals() has failed as rfcUri contains incorrect data!", "https://tools.ietf.org/html/rfc3229", statusCode.getRfcUri());

    }

    /**
     * Tests StatusCodeServiceImpl.findDistinctByStatusCodeEquals() with an invalid StatusCode
     */
    @Test
    public void StatusCodeServiceImpl_findDistinctByStatusCodeEquals_InValidStatusCode_Passes() throws Exception {

        StatusCode statusCode = statusCodeService.findDistinctByStatusCodeEquals(288);

        Assert.assertNull("StatusCodeServiceImpl.findDistinctByStatusCodeEquals() has failed as statusCode contains incorrect data!", statusCode);

    }

    /**
     * Tests StatusCodeServiceImpl.findAllByCategoryMember() with an valid category
     */
    @Test
    public void StatusCodeServiceImpl_findAllByCategoryMember_ValidCategory_Passes() throws Exception {

        List<StatusCode> statusCodeList = statusCodeService.findAllByCategoryMember(Integer.toString(200));

        Assert.assertEquals("StatusCodeServiceImpl.findAllByCategoryMember() has failed as statusCodeList contains incorrect number of records!", 2, statusCodeList.size());

    }

    /**
     * Tests StatusCodeServiceImpl.findAllByCategoryMember() with an invalid category
     */
    @Test
    public void StatusCodeServiceImpl_findAllByCategoryMember_InValidCategory_Passes() throws Exception {

        List<StatusCode> statusCodeList = statusCodeService.findAllByCategoryMember(Integer.toString(700));

        Assert.assertEquals("StatusCodeServiceImpl.findAllByCategoryMember() has failed as statusCodeList contains incorrect number of records!", 0, statusCodeList.size());

    }

}