package io.joergi.basics.controllers;


import io.joergi.basics.models.User;
import io.joergi.basics.repositories.UserRepository;
import io.joergi.basics.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void findAll_should_return_200_and_empty_list() throws Exception {
        var userList = new ArrayList<User>();
        userList.add(UserUtils.createRandomUser());
        given(userRepository.findAll()).willReturn(userList);
        mvc.perform(get("/users/")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}
