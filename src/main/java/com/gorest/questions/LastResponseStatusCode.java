package com.gorest.questions;

import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


public class LastResponseStatusCode implements Question<Boolean> {

    public  static final Logger LOGGER = LoggerFactory.getLogger(LastResponseStatusCode.class.getName());
    private String cod;
    private List<String> data;

    public LastResponseStatusCode(List<String>data, String cod) {
        this.cod = cod;
        this.data= data;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        Boolean isSuccess = true;
        Response response = Serenity.sessionVariableCalled("response");

        isSuccess = isSuccess && verifyResponse("Status_code",cod,response.jsonPath().get("_meta.code"));
        isSuccess = isSuccess && verifyResponse("email",data.get(0),response.jsonPath().get("result.email"));
        isSuccess = isSuccess && verifyResponse("name",data.get(1),response.jsonPath().get("result.first_name"));
        isSuccess = isSuccess && verifyResponse("last_name",data.get(2),response.jsonPath().get("result.last_name"));
        isSuccess = isSuccess && verifyResponse("gender",data.get(3),response.jsonPath().get("result.gender"));

        return isSuccess;
    }

    private Boolean verifyResponse(String value, String expected, String obtained){
        LOGGER.info("Value : " + value );
        LOGGER.info("Value expected : " + expected);
        LOGGER.info("Value obtained : " + obtained);
        return obtained.equals(expected);
    }

    public static LastResponseStatusCode is (List<String>data, String cod){
        return new LastResponseStatusCode(data,cod);
    }

}
