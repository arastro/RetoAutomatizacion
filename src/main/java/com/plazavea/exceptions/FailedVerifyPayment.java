package com.plazavea.exceptions;

/*Clase utilizada como excepcion por si lq prueba no es exitosa*/
public class FailedVerifyPayment extends AssertionError {

    public static final String FAYLED_VERIFY_PAYMENT = "The verify of the payment was not successfull";

    public FailedVerifyPayment(String message){
        super(message);
    }

    public FailedVerifyPayment(String message,Throwable cause){
        super(message,cause);
    }
}
