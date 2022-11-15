package com.challenge.adp.exception;

public class CoinNotFoundException extends RuntimeException {
    private static final String MESSAGE = "Coin not found.";

    public CoinNotFoundException() {
        super(MESSAGE);
    }
}
