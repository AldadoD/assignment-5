package com.aldado.controller.admin;

import com.aldado.domain.admin.Destination;
import com.aldado.factory.admin.DestinationFactory;
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

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@RunWith(SpringRunner.class)
public class DestinationControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/destination";


    @Test
    public void testGetAllDestinations(){
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Ignore
    public void testGetDestinationById() {
        Destination destination = restTemplate.getForObject(baseURL + "/destination/1", Destination.class);
        System.out.println(destination.getId());
        assertNotNull(destination);
    }

    @Ignore
    public void testCreateDestination() {
        Destination destination = DestinationFactory.getDestination("Name", "Id");

        ResponseEntity<Destination> postResponse = restTemplate.postForEntity(baseURL + "/create", destination, Destination.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Ignore
    public void testUpdateDestination() {
        int id = 1;
        Destination destination = restTemplate.getForObject(baseURL + "/destination/" + id, Destination.class);

        restTemplate.put(baseURL + "/destinations/" + id, destination);
        Destination updatedDestination = restTemplate.getForObject(baseURL + "/Destination/" + id, Destination.class);
        assertNotNull(updatedDestination);
    }

    @Ignore
    public void testDeleteDestination() {
        int id = 2;
        Destination destination = restTemplate.getForObject(baseURL + "/destinations/" + id, Destination.class);
        assertNotNull(destination);
        restTemplate.delete(baseURL + "/destinations/" + id);
        try {
            destination = restTemplate.getForObject(baseURL + "/destinations/" + id, Destination.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}