package com.invest.server.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class GreetingControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void greeting을_반환한다() throws Exception {
        String expectedValue = "Greeting! Server";

        mvc.perform(get("/greeting"))
                .andExpect(status().isOk())
                .andExpect(content().string(expectedValue));
    }
}