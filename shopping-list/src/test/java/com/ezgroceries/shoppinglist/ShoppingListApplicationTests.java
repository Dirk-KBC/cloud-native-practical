package com.ezgroceries.shoppinglist;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ShoppingListController.class)
//@SpringBootTest
class ShoppingListApplicationTests {

    private ShoppingListController controller;
    @Autowired
    private MockMvc mvc;

    @BeforeEach
    public void setUp() throws Exception {
        controller = new ShoppingListController();
    }

    @Test
    void contextLoads() {
    }

    @Test
    //@Disabled
    @DisplayName("Test Controller - add cocktails")
    public void testPost() throws Exception {
        // To be tested:
        // * Response status
        // * Content type
        // * JSON response body attributes
        mvc.perform( MockMvcRequestBuilders
                .post("/shopping-lists")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(new ShoppingListResource("test_shoppinglistName")))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.uuid").exists());
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
