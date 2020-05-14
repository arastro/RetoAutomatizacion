package com.plazavea.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ProducPage  extends PageObject {

    public static final Target ADD_PRODUCT_BTN = Target.the("add product button").located(By.id("ProductCard__add-to-cart"));
    public static final Target CARD_BUTTON = Target.the("Card button").located(By.xpath("//div[@class='cart__cart']"));
    public static final Target CONTINUE_BUTTON = Target.the("Continue Button").located(By.xpath("//button[@class='button istertiary']"));

}
