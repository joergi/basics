package io.joergi.basics.validators;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.joergi.basics.exceptions.UsernameMustNotContainAtSignException;

class UserValidatorTest {

    UserValidator userValidator = new UserValidator();
    
    @Test
    void test() {
        Assertions.assertThrows(UsernameMustNotContainAtSignException.class, () -> {
            userValidator.usernameMustNotContainAtSign("abc@def");
            });
    }

}
