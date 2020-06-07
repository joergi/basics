package io.joergi.basics.controllers;

import io.joergi.basics.models.StatusCode;
import io.joergi.basics.services.LoginService;
import io.joergi.basics.services.RegisterService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
@AllArgsConstructor
public class UserController {

    private RegisterService registerService;

    private LoginService loginService;

    @PostMapping(value = "/register")
    public void registerUser(String username, String email, String password) {
        StatusCode status = registerService.registerUser(username, email, password);
    }

    @PostMapping(value = "/login")
    public boolean login(String usernameOrEmail, String password) {
        if (!usernameOrEmail.contains("@") || !usernameOrEmail.contains(".")) {
            if (loginService.loginBUsername(usernameOrEmail, password)) {
                return true;
            }
        }

        return loginService.loginByEmail(usernameOrEmail, password);
    }
}
