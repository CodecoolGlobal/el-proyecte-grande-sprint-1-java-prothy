package com.codecool.javapeno.erp.controllers;

import com.codecool.javapeno.erp.entities.User;
import com.codecool.javapeno.erp.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Disabled
@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @MockBean
    private UserService service;

    @MockBean
    private User user;

    @Disabled
    @Test
    public void getUserById_shouldReturnUserModel() throws Exception {
        UUID uuid = UUID.fromString("2b593973-a87e-4653-b1cf-e337f34b3cb3");

        when(service.getUserById(uuid)).thenReturn(new User());

        this.mockMvc.perform(get("/api/user/" + uuid))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":null,\"createdDate\":null,\"updatedDate\":null,\"name\":null,\"phoneNumber\":null,\"email\":null,\"address\":null,\"status\":null,\"privilege\":null,\"salary\":null}"));
    }
}
