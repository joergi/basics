package io.joergi.basics.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import io.joergi.basics.repositories.UserRepository;

@ExtendWith(MockitoExtension.class)
class LoginServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private LoginService loginService;

    @Test
    void loginByUsernameOrEmail_should_never_call_loginByUsername_if_it_contains_AT_sign() {
        loginService.loginByUsernameOrEmail("xxx@xxxx", "xxxx");
        verify(userRepository, times(0)).findUserByUsernameAndPassword(any(), any());
        verify(userRepository, times(1)).findUserByEmailAndPassword(any(), any());
    }

    @Test
    void loginByUsernameOrEmail_should_never_call_loginByEmail_if_it_contains_no_AT_sign() {
        loginService.loginByUsernameOrEmail("xxx_xxxx", "xxxx");
        verify(userRepository, times(1)).findUserByUsernameAndPassword(any(), any());
        verify(userRepository, times(0)).findUserByEmailAndPassword(any(), any());
    }

    @Test
    void usernameIsNotAnEmail_should_return_true_for_username() {
        assertTrue(loginService.usernameIsNotAnEmail("abcd"));
    }
    
    @Test
    void usernameIsNotAnEmail_should_return_false_for_email() {
        assertFalse(loginService.usernameIsNotAnEmail("ab@cd"));
    }

}
