package com.gorest.questions;

import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/*Clase que valida que el usuario se haya creado exitosamente*/
public class LastResponse implements Question<Boolean> {

    /*Constante de tipo Logger para agregar logs a informativos por consola*/
    public  static final Logger LOGGER = LoggerFactory.getLogger(LastResponse.class.getName());
    private String cod;
    private List<String> data;

    public LastResponse(List<String>data, String cod) {
        this.cod = cod;
        this.data= data;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        Boolean isSuccess = true;
        Response response = Serenity.sessionVariableCalled("response");

        /* se valida que el statuscode sea 201 para hacer las demas validaciones*/
        if(verifyResponse("Status_code",cod,response.jsonPath().get("_meta.code").toString())){
            isSuccess = isSuccess && verifyResponse("email",data.get(0),response.jsonPath().get("result.email"));
            isSuccess = isSuccess && verifyResponse("name",data.get(1),response.jsonPath().get("result.first_name"));
            isSuccess = isSuccess && verifyResponse("last_name",data.get(2),response.jsonPath().get("result.last_name"));
            isSuccess = isSuccess && verifyResponse("gender",data.get(3),response.jsonPath().get("result.gender"));
        }else{
            /*si al respuesta es diferente a 201 el usuario no fue creado exitosamente*/
            isSuccess = false;
        }

        return isSuccess;
    }

    private Boolean verifyResponse(String value, String expected, String obtained){
        LOGGER.info("Value : " + value );
        LOGGER.info("Value expected : " + expected);
        LOGGER.info("Value obtained : " + obtained);
        return obtained.equals(expected);
    }

    public static LastResponse is (List<String>data, String cod){
        return new LastResponse(data,cod);
    }

}
