package com.aldado.controller.admin;


import com.aldado.domain.admin.Busstop;
import com.aldado.factory.admin.BusstopFactory;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@RunWith(SpringRunner.class)
public class BusstopControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/busstop";


    @Test
    public void testGetAllBusstops(){
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Ignore
    public void testGetBusstopById() {
        Busstop busstop = restTemplate.getForObject(baseURL + "/busstop/1", Busstop.class);
        System.out.println(busstop.getCode());
        assertNotNull(busstop);
    }

    @Ignore
    public void testCreateBusstop() {
        Busstop busstop = BusstopFactory.getBusstop("Busstop Code");

        ResponseEntity<Busstop> postResponse = restTemplate.postForEntity(baseURL + "/create", busstop, Busstop.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Ignore
    public void testUpdateBusstop() {
        int id = 1;
        Busstop busstop = restTemplate.getForObject(baseURL + "/busstop/" + id, Busstop.class);

        restTemplate.put(baseURL + "/busstops/" + id, busstop);
        Busstop updatedBusstop = restTemplate.getForObject(baseURL + "/Busstop/" + id, Busstop.class);
        assertNotNull(updatedBusstop);
    }

    @Ignore
    public void testDeleteBusstop() {
        int id = 2;
        Busstop busstop = restTemplate.getForObject(baseURL + "/busstops/" + id, Busstop.class);
        assertNotNull(busstop);
        restTemplate.delete(baseURL + "/busstops/" + id);
        try {
            busstop = restTemplate.getForObject(baseURL + "/busstops/" + id, Busstop.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}