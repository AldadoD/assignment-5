package com.aldado.controller.admin;

import com.aldado.domain.admin.Routes;
import com.aldado.factory.admin.RoutesFactory;
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
public class RoutesControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/routes";


    @Test
    public void testGetAllRoutess(){
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Ignore
    public void testGetRoutesById() {
        Routes routes = restTemplate.getForObject(baseURL + "/routes/1", Routes.class);
        System.out.println(routes.getRouteId());
        assertNotNull(routes);
    }

    @Ignore
    public void testCreateRoutes() {
        Routes routes = RoutesFactory.getRoutes("Route Name", "Route ID");

        ResponseEntity<Routes> postResponse = restTemplate.postForEntity(baseURL + "/create", routes, Routes.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Ignore
    public void testUpdateRoutes() {
        int id = 1;
        Routes routes = restTemplate.getForObject(baseURL + "/routes/" + id, Routes.class);

        restTemplate.put(baseURL + "/routess/" + id, routes);
        Routes updatedRoutes = restTemplate.getForObject(baseURL + "/Routes/" + id, Routes.class);
        assertNotNull(updatedRoutes);
    }

    @Ignore
    public void testDeleteRoutes() {
        int id = 2;
        Routes routes = restTemplate.getForObject(baseURL + "/routess/" + id, Routes.class);
        assertNotNull(routes);
        restTemplate.delete(baseURL + "/routess/" + id);
        try {
            routes = restTemplate.getForObject(baseURL + "/routess/" + id, Routes.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}