package com.dafon.trsearchback.controller;

import com.dafon.trsearchback.service.RegularUserService;

import com.google.gson.*;
import org.junit.jupiter.api.*;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
class RegularUserControllerTest {

    @Autowired
    private MockMvc mvc;

    @Mock
    private RegularUserService service;

    @Mock
    private RegularUserController controller;

    @Autowired
    private MockMvc mockMvc;

    // POST
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

    @Test
    @DisplayName("Should be return http status 200 with attributes")
    @WithMockUser
    void scenario_03() throws Exception {
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
        MvcResult result = mvc.perform(
                post("/api/v1/users")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andReturn();

        MockHttpServletResponse response = result.getResponse();
        String responseBody = response.getContentAsString();

        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(responseBody, JsonObject.class);

        // Assert
        Assertions.assertTrue(jsonObject.has("name"));
        Assertions.assertEquals("Marcos Moa", jsonObject.get("name").getAsString());
        Assertions.assertTrue(jsonObject.has("email"));
        Assertions.assertEquals("mamoa@gmail.com", jsonObject.get("email").getAsString());
        Assertions.assertTrue(jsonObject.has("documentation"));
        Assertions.assertEquals("FX-92989", jsonObject.get("documentation").getAsString());
        Assertions.assertTrue(jsonObject.has("gender"));
        Assertions.assertEquals("MASCULINE", jsonObject.get("gender").getAsString());
    }

    // GET
    @Test
    @DisplayName("Should be return http status 404 with wrong attribute")
    @WithMockUser
    void scenario_04() throws Exception {
        // Arrange
        String invalidEmail = "invalid@example.com";

        // Act
        MockHttpServletResponse response = mockMvc.perform(get("/{email}", invalidEmail)).andReturn().getResponse();

        // Assert
        Assertions.assertEquals(404, response.getStatus());
    }

    @Test
    @DisplayName("Should be return http status 200 with correct attribute")
    @WithMockUser
    void scenario_05() throws Exception {
        // Arrange
        String validEmail = "user11@example.com";

        // Act
        MockHttpServletResponse response = mockMvc.perform(get("/api/v1/users/{email}", validEmail)).andReturn().getResponse();

        // Assert
        Assertions.assertEquals(200, response.getStatus());
    }

    // PUT
    @Test
    @DisplayName("Should be return http status 200 with wrong attribute")
    @WithMockUser
    void scenario_06() throws Exception {
        //ARRANGE
        String user = """
                {
                	"name": "Maria Silv",
                	"email": "user11@example.com"
                }
                """;

        //ACT
        MockHttpServletResponse response = mvc.perform(
                put("/api/v1/users")
                        .content(user)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andReturn().getResponse();

        //ASSERT
        Assertions.assertEquals(200,response.getStatus());
    }

    // DELETE
    @Test
    @DisplayName("Should be return http status 204 with correct attribute")
    @WithMockUser
    void scenario_07() throws Exception {
        // Arrange
        String validEmail = "user11@example.com";

        // Act
        MockHttpServletResponse response = mockMvc.perform(delete("/api/v1/users/{email}", validEmail)).andReturn().getResponse();

        // Assert
        Assertions.assertEquals(204, response.getStatus());
    }

    @Test
    @DisplayName("Should be return http status 404 with wrong attribute")
    @WithMockUser
    void scenario_08() throws Exception {
        // Arrange
        String invalidEmail = "invalid@example.com";

        // Act
        MockHttpServletResponse response = mockMvc.perform(delete("/api/v1/users/{email}", invalidEmail)).andReturn().getResponse();

        // Assert
        Assertions.assertEquals(404, response.getStatus());
    }


}