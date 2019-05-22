package com.aldado.controller.people;

import com.aldado.domain.people.Identification;
import com.aldado.factory.people.IdentificationFactory;
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

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class IdentificationControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/identification";


    @Test
    public void testGetAllIdentifications(){
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Ignore
    public void testGetIdentificationById() {
        Identification identification = restTemplate.getForObject(baseURL + "/identification/1", Identification.class);
        System.out.println(identification.getId());
        assertNotNull(identification);
    }

    @Ignore
    public void testCreateIdentification() {
        Identification identification = IdentificationFactory.getIdentity("id");

        ResponseEntity<Identification> postResponse = restTemplate.postForEntity(baseURL + "/create", identification, Identification.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Ignore
    public void testUpdateIdentification() {
        int id = 1;
        Identification identification = restTemplate.getForObject(baseURL + "/identification/" + id, Identification.class);

        restTemplate.put(baseURL + "/identifications/" + id, identification);
        Identification updatedIdentification = restTemplate.getForObject(baseURL + "/Identification/" + id, Identification.class);
        assertNotNull(updatedIdentification);
    }

    @Ignore
    public void testDeleteIdentification() {
        int id = 2;
        Identification identification = restTemplate.getForObject(baseURL + "/identifications/" + id, Identification.class);
        assertNotNull(identification);
        restTemplate.delete(baseURL + "/identifications/" + id);
        try {
            identification = restTemplate.getForObject(baseURL + "/identifications/" + id, Identification.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}