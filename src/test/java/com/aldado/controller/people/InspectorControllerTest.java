package com.aldado.controller.people;

import com.aldado.domain.people.Inspector;
import com.aldado.factory.people.InspectorFactory;
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
public class InspectorControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/inspector";


    @Test
    public void testGetAllInspectors(){
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Ignore
    public void testGetInspectorById() {
        Inspector inspector = restTemplate.getForObject(baseURL + "/inspector/1", Inspector.class);
        System.out.println(inspector.getId());
        assertNotNull(inspector);
    }

    @Ignore
    public void testCreateInspector() {
        Inspector inspector = InspectorFactory.getInspector("First Name", "Last Name", "Id", true);

        ResponseEntity<Inspector> postResponse = restTemplate.postForEntity(baseURL + "/create", inspector, Inspector.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Ignore
    public void testUpdateInspector() {
        int id = 1;
        Inspector inspector = restTemplate.getForObject(baseURL + "/inspector/" + id, Inspector.class);

        restTemplate.put(baseURL + "/inspectors/" + id, inspector);
        Inspector updatedInspector = restTemplate.getForObject(baseURL + "/Inspector/" + id, Inspector.class);
        assertNotNull(updatedInspector);
    }

    @Ignore
    public void testDeleteInspector() {
        int id = 2;
        Inspector inspector = restTemplate.getForObject(baseURL + "/inspectors/" + id, Inspector.class);
        assertNotNull(inspector);
        restTemplate.delete(baseURL + "/inspectors/" + id);
        try {
            inspector = restTemplate.getForObject(baseURL + "/inspectors/" + id, Inspector.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}