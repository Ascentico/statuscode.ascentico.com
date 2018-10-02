package com.ascentico.statuscode;

import com.ascentico.statuscode.controller.StatusCodeController;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApplicationTest {

    @Autowired
    private StatusCodeController statusCodeController;

    @Test
    public void Application_contextLoads_Passes() throws Exception {
        Assert.assertNotNull("Application has failed as context is null!",statusCodeController);
    }

}