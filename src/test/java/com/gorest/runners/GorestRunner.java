package com.gorest.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/com/gorest/features/createuser.feature",
        tags = {"@createAUser"},
        glue = "com.gorest.stepdefinitions",
        snippets = SnippetType.CAMELCASE
)
public class GorestRunner {
}
