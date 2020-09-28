package io.joergi.basics.services;

import io.joergi.basics.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class LoginService {

    private final UserRepository userRepository;

    public boolean loginByUsernameOrEmail(String usernameOrEmail, String password) {
        if (usernameIsNotAnEmail(usernameOrEmail)) {
            return loginByUsername(usernameOrEmail, password);
        }
        
        return loginByEmail(usernameOrEmail, password);
    }

    protected boolean usernameIsNotAnEmail(String usernameOrEmail) {
        return !usernameOrEmail.contains("@");
    }

    protected boolean loginByUsername(String username, String password) {
        return userRepository.findUserByUsernameAndPassword(username, password) != null;
    }

    protected boolean loginByEmail(String email, String password) {
        return userRepository.findUserByEmailAndPassword(email, password) != null;
    }

}
