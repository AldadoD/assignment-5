package com.aldado.controller.people;

import com.aldado.domain.people.Commuter;
import com.aldado.factory.people.CommuterFactory;
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
public class CommuterControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/commuter";


    @Test
    public void testGetAllCommuters(){
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Ignore
    public void testGetCommuterById() {
        Commuter commuter = restTemplate.getForObject(baseURL + "/commuter/1", Commuter.class);
        System.out.println(commuter.getCommuterId());
        assertNotNull(commuter);
    }

    @Ignore
    public void testCreateCommuter() {
        Commuter commuter = CommuterFactory.getCommuter("id", true);

        ResponseEntity<Commuter> postResponse = restTemplate.postForEntity(baseURL + "/create", commuter, Commuter.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Ignore
    public void testUpdateCommuter() {
        int id = 1;
        Commuter commuter = restTemplate.getForObject(baseURL + "/commuter/" + id, Commuter.class);

        restTemplate.put(baseURL + "/commuters/" + id, commuter);
        Commuter updatedCommuter = restTemplate.getForObject(baseURL + "/Commuter/" + id, Commuter.class);
        assertNotNull(updatedCommuter);
    }

    @Ignore
    public void testDeleteCommuter() {
        int id = 2;
        Commuter commuter = restTemplate.getForObject(baseURL + "/commuters/" + id, Commuter.class);
        assertNotNull(commuter);
        restTemplate.delete(baseURL + "/buses/" + id);
        try {
            commuter = restTemplate.getForObject(baseURL + "/commuters/" + id, Commuter.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}