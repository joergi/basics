package io.joergi.basics.validators;

import org.springframework.stereotype.Component;

import io.joergi.basics.exceptions.UsernameMustNotContainAtSignException;

@Component
public class UserValidator {
    
    public void usernameMustNotContainAtSign(String username) {
        
        if(username.contains("@")) {
            throw new UsernameMustNotContainAtSignException();
        }
    }

}
