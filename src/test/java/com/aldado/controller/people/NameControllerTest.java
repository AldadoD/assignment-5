package com.aldado.controller.people;

import com.aldado.domain.people.Name;
import com.aldado.factory.people.NameFactory;
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
public class NameControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/name";


    @Test
    public void testGetAllNames(){
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Ignore
    public void testGetNameById() {
        Name name = restTemplate.getForObject(baseURL + "/name/1", Name.class);
        System.out.println(name.getFirstName());
        assertNotNull(name);
    }

    @Ignore
    public void testCreateName() {
        Name name = NameFactory.getName("First Name", "Last Name");

        ResponseEntity<Name> postResponse = restTemplate.postForEntity(baseURL + "/create", name, Name.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Ignore
    public void testUpdateName() {
        int id = 1;
        Name name = restTemplate.getForObject(baseURL + "/name/" + id, Name.class);

        restTemplate.put(baseURL + "/names/" + id, name);
        Name updatedName = restTemplate.getForObject(baseURL + "/Name/" + id, Name.class);
        assertNotNull(updatedName);
    }

    @Ignore
    public void testDeleteName() {
        int id = 2;
        Name name = restTemplate.getForObject(baseURL + "/names/" + id, Name.class);
        assertNotNull(name);
        restTemplate.delete(baseURL + "/names/" + id);
        try {
            name = restTemplate.getForObject(baseURL + "/names/" + id, Name.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}