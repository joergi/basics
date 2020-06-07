package io.joergi.basics.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserController {


    @PostMapping(value = "/register")
    public void registerUser(String username, String password) {

    }

    @PostMapping(value = "/login")
    public void login(String username, String password) {

    }

}
