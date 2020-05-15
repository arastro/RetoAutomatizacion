package com.plazavea.stepdefinitions;

import com.plazavea.exceptions.FailedVerifyPayment;
import com.plazavea.questions.ProductIsInPaymentPage;
import com.plazavea.tasks.BuyProduct;
import com.plazavea.tasks.OpenPage;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import java.util.List;

import static com.plazavea.exceptions.FailedVerifyPayment.FAYLED_VERIFY_PAYMENT;
import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class PlazaveaStepDefinition {

    //Metodo que se ejecuta para crear un scenario y un actor
    @Before
    public void InitialConfiguration() {
        setTheStage(new OnlineCast());
        OnStage.theActorCalled("The client");
    }

    @Given("That Ivan is located on the Plazavea website")
    public void thatIvanIsLocatedOnThePlazaveaWebsite() {
        theActorInTheSpotlight().wasAbleTo(OpenPage.PlazaVeaWebSite());
    }

    @When("He try to buy a product")
    public void heTryToBuyAProduct(List<String> data) {
        theActorInTheSpotlight().attemptsTo(BuyProduct.inThePage(data));
    }

    @Then("He Verify that the product was added in the payment page")
    public void heVerifyThatTheProductWasAddedInThePaymentPage(List<String> data) {
        theActorInTheSpotlight().should(seeThat(new ProductIsInPaymentPage(data)).orComplainWith(FailedVerifyPayment.class,FAYLED_VERIFY_PAYMENT));
    }

}
