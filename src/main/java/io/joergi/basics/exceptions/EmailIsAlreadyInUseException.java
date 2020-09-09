package io.joergi.basics.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ResponseStatus(value = HttpStatus.BAD_REQUEST, code = HttpStatus.BAD_REQUEST, reason = "email is already in use ")
public class EmailIsAlreadyInUseException extends RuntimeException {

    private static final long serialVersionUID = -682193325794846038L;

    public EmailIsAlreadyInUseException(String email) {
        super("email "+ email + " is already in use ");
        log.info("email is already in use " + email);
    }
}
