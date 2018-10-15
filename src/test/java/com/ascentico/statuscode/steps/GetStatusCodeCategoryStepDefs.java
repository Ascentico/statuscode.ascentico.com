package com.ascentico.statuscode.steps;

import com.ascentico.statuscode.controller.StatusCodeController;
import com.ascentico.statuscode.service.StatusCodeService;
import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class GetStatusCodeCategoryStepDefs {

    private MockMvc mockMvc;

    @Mock
    private StatusCodeService mockStatusCodeService;

    @InjectMocks
    private StatusCodeController mockedStatusCodeController;

    private Integer resultStatusCode;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        // Write code here to set up mock data
        mockMvc = MockMvcBuilders.standaloneSetup(mockedStatusCodeController).build();
    }

    @When("a user makes a HTTP get for the valid HTTP status code category {int}")
    public void aUserMakesAHTTPGetForTheValidHTTPStatusCodeCategory(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("the user should see {int} responses")
    public void theUserShouldSeeResponses(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("a user makes a HTTP get for the invalid status code category {int}")
    public void aUserMakesAHTTPGetForTheInvalidStatusCodeCategory(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("the user should see a HTTP {int} repsonse")
    public void theUserShouldSeeAHTTPRepsonse(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

}
