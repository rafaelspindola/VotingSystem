package com.Challenge.VotingSystem.controller;

import com.Challenge.VotingSystem.entity.Matter;
import com.Challenge.VotingSystem.service.MatterService.MatterService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
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

    // This is a function to reduce duplicated code that still needs to be implemented
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

    @DisplayName("This method is supposed to make a HTTP GET request and list all matters.")
    @Test
    void should_get_all_matters() throws Exception {
        Matter raise = new Matter(1L,"10% raise", "13-02-2023", "Rafael", null);
        Matter vacation = new Matter(null,"Extended vacation time", "13-02-2023", "Lucas", null);

        List<Matter> allMaters = Arrays.asList(raise,vacation);

        given(service.findAll()).willReturn(allMaters);

        mockMvc.perform(get("/api/v1/matters")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$[0].matter").exists())
                .andExpect(jsonPath("$[1].matter").exists());
    }

    @DisplayName("This method is supposed to make a HTTP GET specific request and list it's attributes.")
    @Test
    @Timeout(value = 150,unit = TimeUnit.MILLISECONDS) // the test fails if execution time is exceeds 150 milliseconds
    void should_get_a_specific_matter() throws Exception {
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

    @DisplayName("This test is supposed to make a HTTP GET specific request using @ParameterizedTest annotation ")
    @ParameterizedTest
    @ValueSource(longs = {1})
    void should_get_id_using_parameters(long id) {
        Matter matter = new Matter(1L,null,null,null,null);
        given(service.findById(id)).willReturn(Optional.of(matter));
            assertEquals(id, matter.getId());
    }


    @DisplayName("This method is supposed to make a HTTP POST request and save it in the DB.")
    @Test
    void should_create_a_matter() throws Exception {
        Matter matter = new Matter(1L, "10% raise", "13-02-2023", "Rafael", null);

        given(service.save(any())).willReturn(matter);

        mockMvc.perform(post("/api/v1/matters")
                .content(asJsonString(matter))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andDo(print());
    }

    @DisplayName("This method is supposed to make a HTTP DELETE specific request and erase data from the DB.")
    @ParameterizedTest
    @ValueSource(longs = {1})
    void should_delete_specific_matter(Long id) throws Exception {
        Matter matter = new Matter(1L, "10% raise", "13-02-2023", "Rafael", null);

        mockMvc.perform(delete("/api/v1/matters/{id}", id)
                .content(asJsonString(matter))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent())
                .andDo(print())
                .andExpect(jsonPath("$._id").doesNotExist());

    }
    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}