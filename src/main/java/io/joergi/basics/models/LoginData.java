package io.joergi.basics.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginData {

    private String usernameOrEmail;

    private String password;

}
