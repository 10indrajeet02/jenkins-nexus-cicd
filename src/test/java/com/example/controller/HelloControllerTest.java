package com.example.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
public class HelloControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testHealthEndpoint() throws Exception {
        mockMvc.perform(get("/api/health"))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"status\": \"UP\", \"message\": \"Application is healthy\"}"));
    }

    @Test
    public void testHelloEndpoint() throws Exception {
        mockMvc.perform(get("/api/hello/World"))
                .andExpect(status().isOk());
    }

    @Test
    public void testVersionEndpoint() throws Exception {
        mockMvc.perform(get("/api/version"))
                .andExpect(status().isOk());
    }
}
