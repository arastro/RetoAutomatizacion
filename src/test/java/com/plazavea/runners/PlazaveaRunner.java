package com.plazavea.runners;


import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/com/plazavea/features/buy_product.feature",
        tags = {"@buyAproduct"},
        glue = "com.plazavea.stepdefinitions",
        snippets = SnippetType.CAMELCASE
)
public class PlazaveaRunner {
}
