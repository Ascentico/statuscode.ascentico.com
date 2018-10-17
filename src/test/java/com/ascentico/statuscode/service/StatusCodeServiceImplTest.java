package com.ascentico.statuscode.service;

import com.ascentico.statuscode.model.StatusCode;
import com.ascentico.statuscode.repository.StatusCodeRepository;
import cucumber.api.java.en.When;
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

    private final StatusCode statusCode226 = new StatusCode(226,
            "IM Used",
            "The server has fulfilled a request for the resource, and the response is a representation of the result of one or more instance-manipulations applied to the current instance.",
            "https://tools.ietf.org/html/rfc3229");

    private final StatusCode statusCode208 = new StatusCode(208,
            "Already Reported",
            "The members of a DAV binding have already been enumerated in a preceding part of the (multistatus) response, and are not being included again.");

    private List<StatusCode> statusCodeList = new ArrayList<>();

    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);

        statusCodeList.add(statusCode226);

        when(mockStatusCodeRepository.findByStatusCodeEquals(226)).thenReturn(statusCodeList);

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
    public void StatusCodeServiceImpl_findByStatusCodeEquals_ValidStatusCode_Passes() {

        List<StatusCode> foundStatusCode226 = mockedStatusCodeService.findByStatusCodeEquals(226);

        Assert.assertSame("StatusCode objects are not the same", statusCodeList, foundStatusCode226);

    }

    /**
     * Tests StatusCodeServiceImpl.findDistinctByStatusCodeEquals() with an invalid StatusCode
     */
    @Test
    public void StatusCodeServiceImpl_findByStatusCodeEquals_InValidStatusCode_Passes() {

        List<StatusCode> foundStatusCode288 = mockedStatusCodeService.findByStatusCodeEquals(288);
        List<StatusCode> emptyList = new ArrayList<>();

        Assert.assertEquals("StatusCodeList contains StatusCodes!", emptyList, foundStatusCode288);

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