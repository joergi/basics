package io.joergi.basics.repositories;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.event.annotation.AfterTestClass;

import io.joergi.basics.models.User;
import io.joergi.basics.utils.UserUtils;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    private User user;
    
    @BeforeEach
    public void init() {
        userRepository.deleteAll();
        user = UserUtils.createRandomUser();
        userRepository.save(user);
    }
    
    @Test
    void testFindUserByUsername_should_return_user() {
        assertNotNull(userRepository.findUserByUsername(user.getUsername()));
        
    }

    @Test
    void testFindUserByEmail_should_return_user() {
        assertNotNull(userRepository.findUserByEmail(user.getEmail()));
    }

    @Test
    void testFindUserByUsernameAndPassword_should_return_User() {
        assertNotNull(userRepository.findUserByUsernameAndPassword(user.getUsername(), user.getPassword()));
    }

    @Test
    void testFindUserByEmailAndPassword() {
        assertNotNull(userRepository.findUserByEmailAndPassword(user.getEmail(), user.getPassword()));
    }
    
    @AfterTestClass
    public void cleanUp(){
        userRepository.deleteAll();
    }

}
