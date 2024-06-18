package com.github.krezovic.resttemplate_bug;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.web.client.RestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ResttemplateBugApplicationTests {
    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private RestClient.Builder restClientBuilder;

    @LocalServerPort
    private int port;

    @Test
    void contextLoads() {
        Assertions.assertDoesNotThrow(() -> restTemplate.patchForObject("/v1", "Hello World", Void.class));
    }

    @Test
    void rtTest() {
        var client = restClientBuilder.baseUrl(String.format("http://localhost:%d", port)).build();
        Assertions.assertDoesNotThrow(() -> client.patch().body("Hello world").retrieve().toBodilessEntity());
    }
}
