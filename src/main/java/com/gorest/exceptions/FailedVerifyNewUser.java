package com.gorest.exceptions;

public class FailedVerifyNewUser extends AssertionError {

    /*Clase utilizada como excepcion por si lq prueba no es exitosa*/
    public static final String FAYLED_VERIFY_NEW_USER = "The verify of the new user was not successfull";

    public FailedVerifyNewUser(String message){
        super(message);
    }

    public FailedVerifyNewUser(String message, Throwable cause){
        super(message,cause);
    }
}
