package com.radha.rest.webservices.restfulwebservices.app.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus (code = HttpStatus.NOT_FOUND)
public class NoSuchUserException extends RuntimeException {
public NoSuchUserException (int userId) {
    super("No such user having the Id : "+userId);
}
}
