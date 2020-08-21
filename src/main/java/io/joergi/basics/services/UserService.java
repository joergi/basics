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
        return userRepository.findUserByEmail(email) != null;
    }

    public boolean usernameIsAlreadyInUse(String username){
        return userRepository.findUserByUsername(username) != null;

    }
}
