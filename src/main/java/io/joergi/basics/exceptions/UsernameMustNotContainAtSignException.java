package io.joergi.basics.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, code = HttpStatus.BAD_REQUEST, reason = "username must not contain at sign")
public class UsernameMustNotContainAtSignException extends RuntimeException{

    private static final long serialVersionUID = 5154526860315751760L;

    public UsernameMustNotContainAtSignException() {
        super("username must not contain at sign");
    }
}
