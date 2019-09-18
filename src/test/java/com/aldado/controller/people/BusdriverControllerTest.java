package com.aldado.controller.people;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertEquals;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)

public class BusdriverControllerTest {

    private static final String BASE_URL = "http://localhost:8080/busservice/lookup/busdriver";

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void createBusdriver() {
        ResponseEntity result = restTemplate.withBasicAuth("admin", "admin")
                .postForEntity(BASE_URL + "/create/new busdriver", null, String.class);
        System.out.println(result.getBody());
//        assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    public void getAll() {

        ResponseEntity<String> result = restTemplate.withBasicAuth("user", "password")
                .getForEntity(BASE_URL + "/getall", String.class);
        System.out.println(result.getBody());
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }
}

//
//public class BusdriverControllerTest {
//    @Autowired
//    private TestRestTemplate restTemplate;
//    private String baseURL = "http://localhost:8080/busdriver";
//
//
//    @Test
//    public void testGetAllBusdrivers(){
//        HttpHeaders headers = new HttpHeaders();
//
//        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
//        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
//                HttpMethod.GET, entity, String.class);
//        assertNotNull(response.getBody());
//    }
//
//    @Ignore
//    public void testGetBusdriverById() {
//        Busdriver busdriver = restTemplate.getForObject(baseURL + "/busdriver/1", Busdriver.class);
//        System.out.println(busdriver.getDriverId());
//        assertNotNull(busdriver);
//    }
//
//    @Ignore
//    public void testCreateBusdriver() {
//        Busdriver busdriver = BusdriverFactory.buildDriver("First Name", "Last Name", "Driver Id");
//
//        ResponseEntity<Busdriver> postResponse = restTemplate.postForEntity(baseURL + "/create", busdriver, Busdriver.class);
//        assertNotNull(postResponse);
//        assertNotNull(postResponse.getBody());
//    }
//
//    @Ignore
//    public void testUpdateBusdriver() {
//        int id = 1;
//        Busdriver busdriver = restTemplate.getForObject(baseURL + "/busdriver/" + id, Busdriver.class);
//
//        restTemplate.put(baseURL + "/busdrivers/" + id, busdriver);
//        Busdriver updatedBus = restTemplate.getForObject(baseURL + "/Busdriver/" + id, Busdriver.class);
//        assertNotNull(updatedBus);
//    }
//
//    @Ignore
//    public void testDeleteBusdriver() {
//        int id = 2;
//        Busdriver busdriver = restTemplate.getForObject(baseURL + "/busdrivers/" + id, Busdriver.class);
//        assertNotNull(busdriver);
//        restTemplate.delete(baseURL + "/busdrivers/" + id);
//        try {
//            busdriver = restTemplate.getForObject(baseURL + "/buses/" + id, Busdriver.class);
//        } catch (final HttpClientErrorException e) {
//            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
//        }
//    }
//}