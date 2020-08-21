package io.joergi.basics.services;

import io.joergi.basics.exceptions.EmailIsAlreadyInUseException;
import io.joergi.basics.exceptions.UsernameAlreadyInUseException;
import io.joergi.basics.models.User;
import io.joergi.basics.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class RegisterService {

    private UserService userService;

    private UserRepository userRepository;

    public void registerUser(User user) {

        if (userService.emailIsAlreadyRegistered(user.getEmail())) {
           throw new EmailIsAlreadyInUseException(user.getEmail());
        }

        if (userService.usernameIsAlreadyInUse(user.getUsername())) {
            throw new UsernameAlreadyInUseException(user.getUsername());
        }

        userRepository.save(user);
    }

}
