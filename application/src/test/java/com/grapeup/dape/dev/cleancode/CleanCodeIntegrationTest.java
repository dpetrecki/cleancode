package com.grapeup.dape.dev.cleancode;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@AutoConfigureMockMvc
class CleanCodeIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldCallForProducts() throws Exception {
        mockMvc.perform(get("/products")
                        .queryParam("clientId", "1234")
                        .queryParam("deviceId", "ABC"))
                .andExpect(status().isOk())
                .andExpect(content().json("""
                        [
                          {
                            "name": "test product 1",
                            "services": [
                              {
                                "name": "test service 1"
                              },
                              {
                                "name": "test service 2"
                              }
                            ]
                          },
                          {
                            "name": "test product 2",
                            "services": [
                              {
                                "name": "test service 3"
                              },
                              {
                                "name": "test service 2"
                              }
                            ]
                          }
                        ]
                        """));
    }
}
