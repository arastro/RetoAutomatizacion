package com.gorest.interactions;

import net.serenitybdd.screenplay.Tasks;

/*Clase donde se guardan todos los metodos del servicio GOREST*/
public class ConsumeService {
    private ConsumeService(){}

    public static  WithPost withPost(String body, String token){
        return Tasks.instrumented(WithPost.class,body, token);
    }
}
