package com.ascentico.statuscode.steps;

import com.ascentico.statuscode.controller.StatusCodeController;
import com.ascentico.statuscode.model.StatusCode;
import com.ascentico.statuscode.service.StatusCodeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import cucumber.api.java.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class GetStatusCodeStepDefs {

    private MockMvc mockMvc;

    @Mock
    private StatusCodeService mockStatusCodeService;

    @InjectMocks
    private StatusCodeController mockedStatusCodeController;

    private StatusCode statusCode226 = new StatusCode(226,
            "IM Used",
            "The server has fulfilled a request for the resource, and the response is a representation of the result of one or more instance-manipulations applied to the current instance.",
            "https://tools.ietf.org/html/rfc3229");

    private Integer resultStatusCode;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        when(mockStatusCodeService.findDistinctByStatusCodeEquals(226)).thenReturn(statusCode226);
        mockMvc = MockMvcBuilders.standaloneSetup(mockedStatusCodeController).build();
    }

    @When("a user makes a HTTP GET for valid HTTP Status Code {int}")
    public void aUserMakesAHTTPGETForHTTPStatusCode(Integer requestedStatusCode) throws Exception {

        MvcResult result = mockMvc.perform(get("/api/v1/status/" + requestedStatusCode))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.statusCode", is(requestedStatusCode)))
                .andReturn();

        ObjectMapper mapper = new ObjectMapper();
        StatusCode statusCode = mapper.readValue(result.getResponse().getContentAsString(),
                StatusCode.class);

        resultStatusCode = statusCode.getStatusCode();
    }

    @When("a user makes a HTTP GET for invalid HTTP Status Code {int}")
    public void aUserMakesAHTTPGETForInvalidHTTPStatusCode(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("the user should see {int} in the response")
    public void theUserShouldSeeInTheResponse(Integer expectedStatusCode) {
        Assert.assertEquals("Status Code does not match!", expectedStatusCode, resultStatusCode);
    }

    @Then("the user should see a HTTP {int} response")
    public void theUserShouldSeeAHTTPResponse(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

}