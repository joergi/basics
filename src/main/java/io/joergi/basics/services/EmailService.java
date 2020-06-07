package io.joergi.basics.services;

import io.joergi.basics.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmailService {

    private UserRepository userRepository;

    public boolean emailIsRegistered(String email) {
        // TODO
        return false;
    }

}
