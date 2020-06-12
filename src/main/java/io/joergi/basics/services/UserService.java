package io.joergi.basics.services;

import io.joergi.basics.models.User;
import io.joergi.basics.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public boolean emailIsAlreadyRegistered(String email) {
        var user = userRepository.findUserByEmail(email);
        log.info("user is " + user);
        return (user == null);
    }

    public boolean usernameIsAlreadyInUse(String username){
        var user = userRepository.findUserByUsername(username);
        log.info("user is " + user);
        return (user == null) ;
    }
}
