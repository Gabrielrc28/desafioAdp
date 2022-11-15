package com.challenge.adp.exception;

public class NotEnoughCoinsException extends RuntimeException {
    private static final String MESSAGE = "Unfortunately we do not have enough coins to change.";

    public NotEnoughCoinsException() {
        super(MESSAGE);
    }
}
