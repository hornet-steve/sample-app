package com.hornetdevelopment.sample.service.validation;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by steve on 4/24/17.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class GreetingNotFoundException extends RuntimeException {
}
