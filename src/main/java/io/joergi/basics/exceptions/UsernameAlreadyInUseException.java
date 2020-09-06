package io.joergi.basics.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, code = HttpStatus.BAD_REQUEST, reason = "username is already in use")
public class UsernameAlreadyInUseException extends RuntimeException{

    private static final long serialVersionUID = -3752463160949998576L;

    public UsernameAlreadyInUseException(String username) {
        super("username is already in use " + username);

    }
}
