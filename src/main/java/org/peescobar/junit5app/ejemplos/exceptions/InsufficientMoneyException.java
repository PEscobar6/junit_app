package org.peescobar.junit5app.ejemplos.exceptions;

public class InsufficientMoneyException extends RuntimeException{
    public InsufficientMoneyException(String message) {
        super(message);
    }
}
