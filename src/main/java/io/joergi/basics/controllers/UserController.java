package io.joergi.basics.controllers;

import io.joergi.basics.models.StatusCode;
import io.joergi.basics.models.User;
import io.joergi.basics.services.LoginService;
import io.joergi.basics.services.RegisterService;
import io.joergi.basics.services.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/users")
@AllArgsConstructor
public class UserController {

    private RegisterService registerService;

    private UserService userService;

    private LoginService loginService;

    @GetMapping(value = "/")
    public List<User> findAll(){
        log.info("findall is called");
        return userService.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/register")
    public void registerUser(@RequestBody User user) {
        StatusCode status = registerService.registerUser(user);
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
