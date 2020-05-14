package com.plazavea.tasks;

import com.plazavea.userinterfaces.HomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class OpenPage implements Task {

    private HomePage homePage;

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.browserOn(homePage));
    }

    public static OpenPage PlazaVeaWebSite() {
        return instrumented(OpenPage.class);
    }

}
