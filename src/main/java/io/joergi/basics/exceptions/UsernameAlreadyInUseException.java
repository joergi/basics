package io.joergi.basics.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UsernameAlreadyInUseException extends RuntimeException{

    public UsernameAlreadyInUseException(String username) {
        super("username is already in use " + username);

    }
}
