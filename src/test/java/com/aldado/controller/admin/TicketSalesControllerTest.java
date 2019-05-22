package com.aldado.controller.admin;


import com.aldado.domain.admin.TicketSales;
import com.aldado.factory.admin.TicketSalesFactory;
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
public class TicketSalesControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/ticketSales";


    @Test
    public void testGetAllTicketSaless(){
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Ignore
    public void testGetTicketSalesById() {
        TicketSales ticketSales = restTemplate.getForObject(baseURL + "/ticketSales/1", TicketSales.class);
        System.out.println(ticketSales.getTicketPrice());
        assertNotNull(ticketSales);
    }

    @Ignore
    public void testCreateTicketSales() {
        TicketSales ticketSales = TicketSalesFactory.getTicketSales("Ticket Price", "Destination");

        ResponseEntity<TicketSales> postResponse = restTemplate.postForEntity(baseURL + "/create", ticketSales, TicketSales.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Ignore
    public void testUpdateTicketSales() {
        int id = 1;
        TicketSales ticketSales = restTemplate.getForObject(baseURL + "/ticketSales/" + id, TicketSales.class);

        restTemplate.put(baseURL + "/ticketSaless/" + id, ticketSales);
        TicketSales updatedTicketSales = restTemplate.getForObject(baseURL + "/TicketSales/" + id, TicketSales.class);
        assertNotNull(updatedTicketSales);
    }

    @Ignore
    public void testDeleteTicketSales() {
        int id = 2;
        TicketSales ticketSales = restTemplate.getForObject(baseURL + "/ticketSaless/" + id, TicketSales.class);
        assertNotNull(ticketSales);
        restTemplate.delete(baseURL + "/ticketSaless/" + id);
        try {
            ticketSales = restTemplate.getForObject(baseURL + "/ticketSaless/" + id, TicketSales.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}