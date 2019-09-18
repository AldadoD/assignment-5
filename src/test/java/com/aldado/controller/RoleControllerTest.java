package com.aldado.controller;

import junit.framework.TestCase;
import org.apache.tomcat.util.codec.binary.Base64;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.nio.charset.Charset;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RoleControllerTest {

    private static final String BASE_URL = "http://localhost:8080/busservice";

    @Autowired
    private TestRestTemplate restTemplate;
    String username, password;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void create() {
        HttpHeaders headers = new HttpHeaders();
        String auth = username + ":" + password;
        byte[] encodeAuth = Base64.encodeBase64(
            auth.getBytes(Charset.forName("US-ASCII")));
        String authHeader = "Basic" + new String( encodeAuth);

//        headers.add("AUTHORIZATION", "Basic 36b9fffe-b65d-4bc8-ab0b-179d81782e17");

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(BASE_URL + "/create/all", entity, String.class);
        System.out.println(response.getStatusCode());
        assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode());

    }

    @Test
    public void getAll() {
        ResponseEntity<String> result = restTemplate.withBasicAuth("user", "password")
                .getForEntity(BASE_URL + "/getall", String.class);
        System.out.println(result.getBody());
        TestCase.assertEquals(HttpStatus.OK, result.getStatusCode());
    }
}