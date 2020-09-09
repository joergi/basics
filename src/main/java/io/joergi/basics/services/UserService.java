package io.joergi.basics.services;

import java.util.List;

import org.springframework.stereotype.Service;

import io.joergi.basics.models.User;
import io.joergi.basics.repositories.UserRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    
    // TODO refactor to UserValidator
    public boolean emailIsAlreadyRegistered(String email) {
        return userRepository.findUserByEmail(email) != null;
    }

    // TODO refactor to UserValidator
    public boolean usernameIsAlreadyInUse(String username){
        return userRepository.findUserByUsername(username) != null;
    }
}
