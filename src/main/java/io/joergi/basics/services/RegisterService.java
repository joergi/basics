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

    private UserService userService;

    private UserRepository userRepository;

    public StatusCode registerUser(User user) {

        if (userService.emailIsAlreadyRegistered(user.getEmail())) {
            // TODO check if StatusCode is the right thing
            log.error("Registration: email %s is already in use", user.getEmail());
            return StatusCode.EMAIL_IS_ALREADY_IN_USE;
        }

        if (userService.usernameIsAlreadyInUse(user.getUsername())) {
            log.error("Registration: Username %s is already in use", user.getUsername());
            return StatusCode.USERNAME_IS_ALREADY_IN_USE;
        }

        userRepository.save(user);

        return StatusCode.SUCCESS;
    }

}
