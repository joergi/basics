package io.joergi.basics.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.joergi.basics.repositories.UserRepository;
import io.joergi.basics.services.LoginService;
import io.joergi.basics.services.RegisterService;
import io.joergi.basics.services.UserService;
import io.joergi.basics.utils.UserUtils;
import io.joergi.basics.validators.UserValidator;

@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mvc;
    
    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private UserRepository userRepository;

    @MockBean
    private RegisterService registerService;

    @MockBean 
    private UserService userService;

    @MockBean
    private LoginService loginService;
    
    @MockBean
    private UserValidator UserValidator;

    @Test
    public void findAll_should_return_200_and_empty_list() throws Exception {
        mvc.perform(get("/users/")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
    
    @Test
    public void create_should_return_is_Created() throws Exception {
        mvc.perform(post("/users/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(UserUtils.createRandomUser()))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    // TODO fix this test
//    @Test
//    public void create_should_return_Bad_Request_for_AtSign() throws Exception {
//        var user = UserUtils.createRandomUser();
//        user.setUsername("ab@cd");
//
//        mvc.perform(post("/users/register")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(objectMapper.writeValueAsString(user))
//                .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isCreated());
//    }
    
    @Test
    public void login_with_username() throws Exception {
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("usernameOrEmail", "testUser");
        map.add("password", "password");
        
        mvc.perform(post("/users/login")
                .contentType(MediaType.APPLICATION_JSON)
                .params(map)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        
        
        
    }
    
    

}
