package com.cryptal.ark.arkcreditservice.common.exp;

public class CreditException extends RuntimeException{

    public CreditException(String message) {
        super(message);
    }

    public CreditException(String message, Throwable cause) {
        super(message, cause);
    }
}
