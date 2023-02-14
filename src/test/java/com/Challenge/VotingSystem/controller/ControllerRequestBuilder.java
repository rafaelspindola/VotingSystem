package com.Challenge.VotingSystem.controller;

import com.Challenge.VotingSystem.service.MatterService.MatterService;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(MatterController.class)
public class ControllerRequestBuilder {

    private MatterController controller;
    private MatterService service;
    private final MockMvc mockMvc;

    ControllerRequestBuilder(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }


}
