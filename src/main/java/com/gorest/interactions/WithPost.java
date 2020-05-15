package com.gorest.interactions;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

import static com.gorest.utils.enums.RestService.BASE_URL;
import static com.gorest.utils.enums.RestService.CREATE_USER;

/*Clase que manda un REQUEST de tipo POST a la API de GOREST para crear un nuevo usuario*/
public class WithPost implements Interaction {
    private String body;
    private String token;

    public WithPost(String body, String token){
        this.body=body;
        this.token=token;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        RestAssured.baseURI = BASE_URL.toString();

        try{
            /*Request de tipo POST al servicio GOREST*/
            Response response = RestAssured.given().contentType(ContentType.JSON)
                    .queryParam("access-token",token)
                    .body(body)
                    .post(CREATE_USER.toString());

            /*La respuesta se guarda como una variable global de serenity para luego ser capturada en la question*/
            Serenity.setSessionVariable("response").to(response);

        }catch (Exception e){
            System.out.println(e);
        }

    }
}
