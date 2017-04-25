package com.hornetdevelopment.sample.controller.validation;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by steve on 4/24/17.
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidUUIDException extends RuntimeException {
    public InvalidUUIDException(Throwable cause) {
        super(cause);
    }
}
