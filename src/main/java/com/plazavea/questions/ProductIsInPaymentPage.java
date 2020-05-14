package com.plazavea.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.List;

import static com.plazavea.userinterfaces.CartPage.PRODUCT_NAME;

public class ProductIsInPaymentPage  implements Question<Boolean> {

    private List<String> data;

    public ProductIsInPaymentPage(List<String> dataTransaccion){
        this.data=dataTransaccion;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return PRODUCT_NAME.resolveFor(actor).getText().equals(data.get(0));
    }
}
