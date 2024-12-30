package xyz.adityajoshi.HabitForge.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.MalformedURLException;
import java.net.URL;

@SpringBootTest
@AutoConfigureMockMvc
public class HabitControllerIT {

    @Value("${local.server.port}")
    private int port;

    private URL base;

    private RestTemplate restTemplate;

    @BeforeEach
    public void setUp() throws MalformedURLException {
        this.base = new URL("http://localhost:"+port+"/habits/");
        restTemplate = new RestTemplate();
    }

    @Test
    public void simpleTest(){
        ResponseEntity<String> response = restTemplate.getForEntity(base.toString(),String.class);
        Assertions.assertEquals("It Works!!!", response.getBody());
    }
}
