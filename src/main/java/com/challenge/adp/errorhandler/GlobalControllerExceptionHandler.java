package com.challenge.adp.errorhandler;

import com.challenge.adp.errorhandler.model.ErrorResponse;
import com.challenge.adp.exception.CoinNotFoundException;
import com.challenge.adp.exception.NotEnoughCoinsException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalControllerExceptionHandler {
    public static final String SUGGESTION = "Try again with a smaller bill.";

    public static final String SUGGESTION2 = "Try again with another ID.";

    @ExceptionHandler({NotEnoughCoinsException.class})
    @ResponseStatus(value = HttpStatus.PRECONDITION_FAILED)
    public ErrorResponse notEnoughCoinsExceptionHandler(NotEnoughCoinsException error) {

        return ErrorResponse.builder()
                .errorCause(error.getMessage())
                .suggestion(SUGGESTION)
                .status(HttpStatus.PRECONDITION_FAILED)
                .build();
    }

    @ExceptionHandler(CoinNotFoundException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorResponse coinNotFoundExceptionHandler(CoinNotFoundException error) {

        return ErrorResponse.builder()
                .errorCause(error.getMessage())
                .suggestion(SUGGESTION2)
                .status(HttpStatus.BAD_REQUEST)
                .build();
    }
}
