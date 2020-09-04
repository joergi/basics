package io.joergi.basics.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ResponseStatus(value = HttpStatus.BAD_REQUEST, code = HttpStatus.BAD_REQUEST, reason = "email is already in use ")
public class EmailIsAlreadyInUseException extends RuntimeException {

    public EmailIsAlreadyInUseException(String email) {
        super("email is already in use " + email);
        log.info("email is already in use " + email);
    }
}
