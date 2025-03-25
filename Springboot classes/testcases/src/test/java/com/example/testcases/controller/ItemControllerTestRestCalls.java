package com.example.testcases.controller;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ItemControllerTestRestCalls {

        @Autowired
        private TestRestTemplate restTemplate;

        @Test
        public void contextLoads() throws JSONException {
            String response = this.restTemplate.getForObject("/all-items-from-database", String.class );
            JSONAssert.assertEquals("[\n" +
                    "    {\n" +
                    "        \"id\": 10001,\n" +
                    "        \"name\": \"Dove\",\n" +
                    "        \"price\": 100,\n" +
                    "        \"quantity\": 20,\n" +
                    "        \"value\": 2000\n" +
                    "    },\n" +
                    "    {\n" +
                    "        \"id\": 10002,\n" +
                    "        \"name\": \"LUX\",\n" +
                    "        \"price\": 200,\n" +
                    "        \"quantity\": 15,\n" +
                    "        \"value\": 3000\n" +
                    "    },\n" +
                    "    {\n" +
                    "        \"id\": 10003,\n" +
                    "        \"name\": \"santoor\",\n" +
                    "        \"price\": 400,\n" +
                    "        \"quantity\": 35,\n" +
                    "        \"value\": 14000\n" +
                    "    }\n" +
                    "]", response , false);
        }

}
