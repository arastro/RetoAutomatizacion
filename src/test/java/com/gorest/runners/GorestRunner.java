package com.gorest.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;


/*
Runner configurado con los siguientes parametros:
features = ayuda a cucumber a localizar el archivo feature
tags = se usa para especificar que test ejecutar
glue = ayuda a cucumber a localizar el step definition
snippets = genera fragmentos de codigo con estilo que se decida
 */
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/com/gorest/features/createuser.feature",
        tags = {"@createAUser"},
        glue = "com.gorest.stepdefinitions",
        snippets = SnippetType.CAMELCASE
)
public class GorestRunner {
}
