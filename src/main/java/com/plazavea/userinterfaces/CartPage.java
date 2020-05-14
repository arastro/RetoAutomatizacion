package com.plazavea.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CartPage extends PageObject {
    public static final Target PRODUCT_NAME = Target.the("Product Name").located(By.xpath("//td[@class='product-name']/a"));
}
