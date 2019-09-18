package com.aldado.controller.admin;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)

public class BusControllerTest {

    private static final String BASE_URL = "http://localhost:8080/busservice/lookup/bus";

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void createBus() {
        ResponseEntity result = restTemplate.withBasicAuth("admin", "admin")
                .postForEntity(BASE_URL + "/create/new bus", null, String.class);
        System.out.println(result.getBody());
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    public void getAll() {

        ResponseEntity<String> result = restTemplate.withBasicAuth("user", "password")
                .getForEntity(BASE_URL + "/getall", String.class);
        System.out.println(result.getBody());
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }
}

//public class BusControllerTest {
//    @Autowired
//    private TestRestTemplate restTemplate;
//    private String baseURL = "http://localhost:8080/bus";
//
//
//    @Test
//    public void testGetAllBuses(){
//        HttpHeaders headers = new HttpHeaders();
//
//        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
//        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
//                HttpMethod.GET, entity, String.class);
//        assertNotNull(response.getBody());
//    }
//
//    @Ignore
//    public void testGetBusById() {
//        Bus bus = restTemplate.getForObject(baseURL + "/bus/1", Bus.class);
//        System.out.println(bus.getId());
//        assertNotNull(bus);
//    }
//
//    @Ignore
//    public void testCreateBus() {
//        Bus bus = BusFactory.getBus("id", true);
//
//        ResponseEntity<Bus> postResponse = restTemplate.postForEntity(baseURL + "/create", bus, Bus.class);
//        assertNotNull(postResponse);
//        assertNotNull(postResponse.getBody());
//    }
//
//    @Ignore
//    public void testUpdateBus() {
//        int id = 1;
//        Bus bus = restTemplate.getForObject(baseURL + "/bus/" + id, Bus.class);
//
//        restTemplate.put(baseURL + "/buses/" + id, bus);
//        Bus updatedBus = restTemplate.getForObject(baseURL + "/Bus/" + id, Bus.class);
//        assertNotNull(updatedBus);
//    }
//
//    @Ignore
//    public void testDeleteBus() {
//        int id = 2;
//        Bus bus = restTemplate.getForObject(baseURL + "/buses/" + id, Bus.class);
//        assertNotNull(bus);
//        restTemplate.delete(baseURL + "/buses/" + id);
//        try {
//            bus = restTemplate.getForObject(baseURL + "/buses/" + id, Bus.class);
//        } catch (final HttpClientErrorException e) {
//            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
//        }
//    }
//}