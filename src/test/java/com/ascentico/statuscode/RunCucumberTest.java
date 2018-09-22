package com.ascentico.statuscode;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(snippets = SnippetType.CAMELCASE,
        plugin = {"pretty"},
        features = "src/test/resources/features/")
public class RunCucumberTest {
}
