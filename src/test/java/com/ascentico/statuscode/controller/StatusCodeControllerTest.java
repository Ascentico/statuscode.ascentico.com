package com.ascentico.statuscode.controller;

import com.ascentico.statuscode.Application;
import com.ascentico.statuscode.configuration.WebConfiguration;
import com.ascentico.statuscode.model.StatusCode;
import com.ascentico.statuscode.service.StatusCodeService;
import cucumber.api.java.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("test")
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Ignore
public class StatusCodeControllerTest {

    private MockMvc mockMvc;

    @Mock
    private StatusCodeService mockStatusCodeService;

    @InjectMocks
    private StatusCodeController mockedStatusCodeController;

    private StatusCode statusCode226 = new StatusCode(226,
            "IM Used",
            "The server has fulfilled a request for the resource, and the response is a representation of the result of one or more instance-manipulations applied to the current instance.",
            "https://tools.ietf.org/html/rfc3229");

    private List<StatusCode> statusCodeList = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        statusCodeList.add(statusCode226);
        when(mockStatusCodeService.findByStatusCodeEquals(226)).thenReturn(statusCodeList);
        mockMvc = MockMvcBuilders.standaloneSetup(mockedStatusCodeController).build();
    }

    @Test
    public void StatusCodeController_getStatusCode_Passes() throws Exception {

        MvcResult result = mockMvc.perform(get("/api/v1/status/" + 226))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.statusCode", is(220)))
                .andReturn();

        System.out.println("Hey hey hey! " + result.getResponse().toString());

    }

}