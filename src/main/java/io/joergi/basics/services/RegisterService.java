package io.joergi.basics.services;

import io.joergi.basics.models.StatusCode;
import io.joergi.basics.models.User;
import io.joergi.basics.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class RegisterService {

    private EmailService emailService;

    private UserService userService;

    private UserRepository userRepository;

    public StatusCode registerUser(String username, String email, String password) {

        if (emailService.emailIsRegistered(email)) {
            // TODO check if StatusCode is the right thing
            return StatusCode.EMAIL_IS_ALREADY_IN_USE;
        }

        if (userService.usernameIsAlreadyInUse(username)) {
            return StatusCode.USERNAME_IS_ALREADY_IN_USE;
        }

        userRepository.save(new User(username, email, password));
        return StatusCode.SUCCESS;

    }

}
