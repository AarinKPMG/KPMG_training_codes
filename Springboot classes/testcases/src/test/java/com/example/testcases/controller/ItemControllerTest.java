package com.example.testcases.controller;

import com.example.testcases.business.ItemBusinessService;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.util.AssertionErrors.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ItemController.class)
public class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc ;

    @MockitoBean
    private ItemBusinessService itemBusinessService ;

    @Test
    public void dummyItem_basic() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/dummy-item")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":10004, \"name\":\"lifeBoy\", \"price\":20, \"quantity\":350}\n"))
                .andReturn();

        String actualResponse = result.getResponse().getContentAsString();
        System.out.println("Actual Response: " + actualResponse);

        // Additional assertion using assertEquals
        String expectedResponse = "{\"id\":10004, \"name\":\"lifeBoy\", \"price\":20, \"quantity\":350}\n";
        assertEquals(expectedResponse, actualResponse, "The JSON response does not match the expected value.");
    }

}
