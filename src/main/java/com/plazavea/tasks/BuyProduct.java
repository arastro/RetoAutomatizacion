package com.plazavea.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;

import static com.plazavea.userinterfaces.CartPage.PRODUCT_NAME;
import static com.plazavea.userinterfaces.HomePage.SEARCH_INPUT;
import static com.plazavea.userinterfaces.HomePage.SUGGEST_ITEM;
import static com.plazavea.userinterfaces.ProducPage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

/*Tarea que agrega un producto de la tienda al carrito recibiendo como parametro una lista de string*/
public class BuyProduct  implements Task {

    private List<String> data;

    public BuyProduct(List<String> dataTransaccion){
        this.data=dataTransaccion;
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(data.get(0)).into(SEARCH_INPUT),
                Click.on(SUGGEST_ITEM),
                WaitUntil.the(ADD_PRODUCT_BTN,isVisible()),
                Click.on(ADD_PRODUCT_BTN),
                Click.on(CARD_BUTTON),
                Click.on(CONTINUE_BUTTON),
                WaitUntil.the(PRODUCT_NAME,isVisible())
        );
    }

    public static BuyProduct inThePage(List<String> data){
        return instrumented(BuyProduct.class,data);
    }
}
