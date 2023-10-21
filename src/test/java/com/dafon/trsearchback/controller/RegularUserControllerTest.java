package com.dafon.trsearchback.controller;

import com.dafon.trsearchback.dto.DatasRegularUserDto;
import com.dafon.trsearchback.model.Gender;
import com.dafon.trsearchback.model.RegularUser;
import com.dafon.trsearchback.service.RegularUserService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
class RegularUserControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private RegularUserService service;

    @Test
    @DisplayName("Should be return http status 400 with errors")
    void scenario_01() throws Exception {
        // Arrange
        String json = "{}";

        // Act
        MockHttpServletResponse response = mvc.perform(
                post("/api/v1/users")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andReturn().getResponse();
        // Assert
        Assertions.assertEquals(400, response.getStatus());
    }

    @Test
    @DisplayName("Should be return http status 200 with not errors")
    @WithMockUser
    void scenario_02() throws Exception {
        // Arrange
        String json = """
                {
                	"name": "Marcos Moa",
                	"cellphone": "+1212121212",
                	"password": "senha123",
                	"email": "mamoa@gmail.com",
                	"documentation": "FX-92989",
                	"photo": "foto5.png",
                	"birthday": "1985-07-20",
                	"gender": "MASCULINE"
                }
                """;

        // Act
        MockHttpServletResponse response = mvc.perform(
                post("/api/v1/users")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andReturn().getResponse();
        // Assert
        Assertions.assertEquals(201, response.getStatus());
    }

}