package io.joergi.basics.services;

import io.joergi.basics.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private UserRepository userRepository;

    public boolean loginByEmail(String email, String password) {
        return userRepository.findUserByEmailAndPassword(email, password) != null;
    }


    public boolean loginBUsername(String username, String password) {
        return userRepository.findUserByUsernameAndPassword(username, password) != null;
    }
}
