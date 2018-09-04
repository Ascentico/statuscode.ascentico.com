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
    private StatusCodeService mockedStatusCodeService = new StatusCodeServiceImpl();

    private StatusCode statusCode226 = new StatusCode(226,
            "IM Used",
            "The server has fulfilled a request for the resource, and the response is a representation of the result of one or more instance-manipulations applied to the current instance.",
            "https://tools.ietf.org/html/rfc3229");

    private StatusCode statusCode208 = new StatusCode(208,
            "Already Reported",
            "The members of a DAV binding have already been enumerated in a preceding part of the (multistatus) response, and are not being included again.");


    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);

        when(mockStatusCodeRepository.findDistinctByStatusCodeEquals(226)).thenReturn(statusCode226);

        List<StatusCode> populatedStatusCodeList = new ArrayList<>();
        populatedStatusCodeList.add(statusCode226);
        populatedStatusCodeList.add(statusCode208);

        List<StatusCode> emptyStatusCodeList = new ArrayList<>();

        when(mockStatusCodeRepository.findAllByStatusCodeStartsWith(2)).thenReturn(populatedStatusCodeList);
        when(mockStatusCodeRepository.findAllByStatusCodeStartsWith(7)).thenReturn(emptyStatusCodeList);

    }

    /**
     * Tests StatusCodeServiceImpl.findDistinctByStatusCodeEquals() with a valid StatusCode
     */
    @Test
    public void StatusCodeServiceImpl_findDistinctByStatusCodeEquals_ValidStatusCode_Passes() {

        StatusCode foundStatusCode226 = mockedStatusCodeService.findDistinctByStatusCodeEquals(226);

        Assert.assertSame("StatusCode objects are not the same", statusCode226, foundStatusCode226);

    }

    /**
     * Tests StatusCodeServiceImpl.findDistinctByStatusCodeEquals() with an invalid StatusCode
     */
    @Test
    public void StatusCodeServiceImpl_findDistinctByStatusCodeEquals_InValidStatusCode_Passes() {

        StatusCode foundStatusCode288 = mockedStatusCodeService.findDistinctByStatusCodeEquals(288);

        Assert.assertNull("StatusCode object is not null", foundStatusCode288);

    }

    /**
     * Tests StatusCodeServiceImpl.findAllByCategoryMember() with an valid category
     */
    @Test
    public void StatusCodeServiceImpl_findAllByCategoryMember_ValidCategory_Passes() {

        List<StatusCode> foundStatusCodeList = mockedStatusCodeService.findAllByCategoryMember("200");

        Assert.assertEquals("foundStatusCodeList contains incorrect number of records", 2, foundStatusCodeList.size());

    }

    /**
     * Tests StatusCodeServiceImpl.findAllByCategoryMember() with an invalid category
     */
    @Test
    public void StatusCodeServiceImpl_findAllByCategoryMember_InValidCategory_Passes() {

        List<StatusCode> foundStatusCodeList = mockedStatusCodeService.findAllByCategoryMember("700");

        Assert.assertEquals("foundStatusCodeList contains incorrect number of records", 0, foundStatusCodeList.size());

    }

}