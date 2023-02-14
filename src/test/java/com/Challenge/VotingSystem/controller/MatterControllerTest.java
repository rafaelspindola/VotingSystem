package com.Challenge.VotingSystem.controller;

import com.Challenge.VotingSystem.entity.Matter;
import com.Challenge.VotingSystem.service.MatterService.MatterService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.Id;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MatterController.class)
@DisplayName("JUnit 5 Matter Controller Test")
class MatterControllerTest {

//    private ControllerRequestBuilder requestBuilder;

    @MockBean
    private MatterService service;

    @Autowired
    private MockMvc mockMvc;

//    @BeforeEach
//    void configureSystemUnderTest() {
//        service = mock(MatterService.class);
//
//        MockMvc mockMvc = MockMvcBuilders
//                .standaloneSetup(new MatterController(service))
//                .setHandlerExceptionResolvers(WebTestConfig.exceptionResolver())
//                .setLocaleResolver(fixedLocaleResolver())
//                .setViewResolvers(jspViewResolver())
//                .build();
//        requestBuilder = new ControllerRequestBuilder(mockMvc);
//    }


    @Test
    void shouldGetAllMattersAsJsonArray() throws Exception {
        Matter raise = new Matter(1L,"10% raise", "13-02-2023", "Rafael", null);
        Matter vacation = new Matter(null,"Extended vacation time", "13-02-2023", "Lucas", null);

        List<Matter> allMaters = Arrays.asList(raise,vacation);

        given(service.findAll()).willReturn(allMaters);

        mockMvc.perform(get("/api/v1/matters")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$[0].matter", equalTo())
                .andExpect(jsonPath("$[1].matter").exists());
    }

    @Test
    void findById() throws Exception {
        Matter raise = new Matter(1L,"10% raise", "13-02-2023", "Rafael", null);
        Matter vacation = new Matter(2L,"Extended vacation time", "13-02-2023", "Lucas", null);

        given(service.findById(1L)).willReturn(Optional.of(raise));

        mockMvc.perform(get("/api/v1/matters/{id}", 1L)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.matter").value("10% raise"))
                .andExpect(jsonPath("$.date").value("13-02-2023"))
                .andExpect(jsonPath("$.author").value("Rafael"))
                .andExpect(jsonPath("$._id").value("1"));

        given(service.findById(2L)).willReturn(Optional.of(vacation));

        mockMvc.perform(get("/api/v1/matters/{id}", 2L)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.matter").value("Extended vacation time"))
                .andExpect(jsonPath("$.date").value("13-02-2023"))
                .andExpect(jsonPath("$.author").value("Lucas"))
                .andExpect(jsonPath("$._id").value("2"));
    }


    @Test
    void createMatter() throws Exception {
        Matter matter = new Matter(null, "10% raise", "13-02-2023", "Rafael", null);

        given(service.save(any())).willReturn(matter);

        mockMvc.perform(post("/api/v1/matters")
                .content(asJsonString(matter))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.matter").exists());
    }


//
//    @Test
//    void delete() {
//    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}