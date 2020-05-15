package com.gorest.interactions;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

import static com.gorest.utils.enums.RestService.BASE_URL;
import static com.gorest.utils.enums.RestService.CREATE_USER;

public class WithPost implements Interaction {
    private String body;

    public WithPost(String body){
        this.body=body;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        RestAssured.baseURI = BASE_URL.toString();
        try{

            Response response = RestAssured.given().contentType(ContentType.JSON)
                    .queryParam("access-token","FXXZ3Kxb8cA8NbjRpqvsxChkmQNk0vYsflfv")
                    .body(body)
                    .post(CREATE_USER.toString());

            Serenity.setSessionVariable("response").to(response);

        }catch (Exception e){
            System.out.println(e);
        }

    }
}
