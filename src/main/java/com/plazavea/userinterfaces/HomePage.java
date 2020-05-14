package com.plazavea.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;


@DefaultUrl("https://www.plazavea.com.pe/")
public class HomePage extends PageObject {

    public static final Target SEARCH_INPUT = Target.the("Search button").located(By.id("search_box"));
    public static final Target SUGGEST_ITEM = Target.the("Suggest Item").located(By.xpath("//div[@class='Search__result']//div[@class='SuggestionItem'][1]//a[@class='SuggestionItem__productLink']"));

}
