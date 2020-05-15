package com.gorest.stepdefinitions;


import com.gorest.exceptions.FailedVerifyNewUser;
import com.gorest.questions.LastResponse;
import com.gorest.tasks.CreateUserRest;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abiities.CallAnApi;

import java.util.List;

import static com.gorest.exceptions.FailedVerifyNewUser.FAYLED_VERIFY_NEW_USER;
import static com.gorest.utils.constant.VALUE;
import static com.gorest.utils.enums.RestService.BASE_URL;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class GorestStepDefinition {

    /*Antes de ejecutas los pasos se crea el escenario y el actor*/
    @Before
    public void prepareStage(){
        OnStage.setTheStage(new OnlineCast());
        theActorCalled("Ivan").whoCan(CallAnApi.at(BASE_URL.toString()));
    }

    @When("I try to create an user")
    public void iTryToCreateAnUser(List<String>  data) {
        theActorInTheSpotlight().attemptsTo(CreateUserRest.with(data));
    }

    @Then("I should see the user created")
    public void iShouldSeeTheUserCreated(List<String>  data) {
        theActorInTheSpotlight().should(seeThat(LastResponse.is(data, VALUE)).orComplainWith(FailedVerifyNewUser.class,FAYLED_VERIFY_NEW_USER));
    }

}
