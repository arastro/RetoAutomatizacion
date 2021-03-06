package com.plazavea.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/*Clase que verifica que si el poducto que se encuentra en el carrito es el esperado*/
import static com.plazavea.userinterfaces.CartPage.PRODUCT_NAME;

public class ProductIsInPaymentPage  implements Question<Boolean> {

    /*Constante de tipo Logger para agregar logs a informativos por consola*/
    public  static final Logger LOGGER = LoggerFactory.getLogger(ProductIsInPaymentPage.class.getName());
    private List<String> data;

    public ProductIsInPaymentPage(List<String> dataTransaccion){
        this.data=dataTransaccion;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        LOGGER.info("Value : Product");
        LOGGER.info("Value expected : " + data.get(0) );
        LOGGER.info("Value obtained : " + PRODUCT_NAME.resolveFor(actor).getText());
        return PRODUCT_NAME.resolveFor(actor).getText().equals(data.get(0));
    }
}
