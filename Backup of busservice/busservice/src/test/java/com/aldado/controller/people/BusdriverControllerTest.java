package com.aldado.controller.people;

import com.aldado.domain.people.Busdriver;
import com.aldado.factory.people.BusdriverFactory;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class BusdriverControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/busdriver";


    @Test
    public void testGetAllBusdrivers(){
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Ignore
    public void testGetBusdriverById() {
        Busdriver busdriver = restTemplate.getForObject(baseURL + "/busdriver/1", Busdriver.class);
        System.out.println(busdriver.getDriverId());
        assertNotNull(busdriver);
    }

    @Ignore
    public void testCreateBusdriver() {
        Busdriver busdriver = BusdriverFactory.buildDriver("First Name", "Last Name", "Driver Id");

        ResponseEntity<Busdriver> postResponse = restTemplate.postForEntity(baseURL + "/create", busdriver, Busdriver.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Ignore
    public void testUpdateBusdriver() {
        int id = 1;
        Busdriver busdriver = restTemplate.getForObject(baseURL + "/busdriver/" + id, Busdriver.class);

        restTemplate.put(baseURL + "/busdrivers/" + id, busdriver);
        Busdriver updatedBus = restTemplate.getForObject(baseURL + "/Busdriver/" + id, Busdriver.class);
        assertNotNull(updatedBus);
    }

    @Ignore
    public void testDeleteBusdriver() {
        int id = 2;
        Busdriver busdriver = restTemplate.getForObject(baseURL + "/busdrivers/" + id, Busdriver.class);
        assertNotNull(busdriver);
        restTemplate.delete(baseURL + "/busdrivers/" + id);
        try {
            busdriver = restTemplate.getForObject(baseURL + "/buses/" + id, Busdriver.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}