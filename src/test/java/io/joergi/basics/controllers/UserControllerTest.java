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

import com.fasterxml.jackson.databind.ObjectMapper;

import io.joergi.basics.repositories.UserRepository;
import io.joergi.basics.services.LoginService;
import io.joergi.basics.services.RegisterService;
import io.joergi.basics.services.UserService;
import io.joergi.basics.utils.UserUtils;

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

    @MockBean UserService userService;

    @MockBean
    private LoginService loginService;

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
    
    

}
