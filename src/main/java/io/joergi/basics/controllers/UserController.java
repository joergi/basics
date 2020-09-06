package io.joergi.basics.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.joergi.basics.models.User;
import io.joergi.basics.services.LoginService;
import io.joergi.basics.services.RegisterService;
import io.joergi.basics.services.UserService;
import io.joergi.basics.validators.UserValidator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/users")
@AllArgsConstructor
public class UserController {

    private RegisterService registerService;

    private UserService userService;
    
    private UserValidator userValidator;

    private LoginService loginService;

    @GetMapping(value = "/")
    public List<User> findAll(){
        log.info("findall is called");
        return userService.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/register")
    public void registerUser(@RequestBody User user){
        userValidator.usernameMustNotContainAtSign(user.getUsername());
        registerService.registerUser(user);
    }

    @PostMapping(value = "/login")
    public boolean login( @RequestParam final MultiValueMap<String, String> requestBody) {
        String usernameOrEmail = requestBody.getFirst("usernameOrEmail");
        String password = requestBody.getFirst("passwword");
        log.info(usernameOrEmail + " - "  + password);
        return loginService.loginByUsernameOrEmail(usernameOrEmail, password);
    }
    
    
}
