package com.aldado.controller.admin;

import com.aldado.domain.admin.Tickets;
import com.aldado.factory.admin.TicketsFactory;
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
public class TicketsControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/tickets";


    @Test
    public void testGetAllTicketss(){
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Ignore
    public void testGetTicketsById() {
        Tickets tickets = restTemplate.getForObject(baseURL + "/tickets/1", Tickets.class);
        System.out.println(tickets.getTicket());
        assertNotNull(tickets);
    }

    @Ignore
    public void testCreateTickets() {
        Tickets tickets = TicketsFactory.getTicket("Ticket");

        ResponseEntity<Tickets> postResponse = restTemplate.postForEntity(baseURL + "/create", tickets, Tickets.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Ignore
    public void testUpdateTickets() {
        int id = 1;
        Tickets tickets = restTemplate.getForObject(baseURL + "/tickets/" + id, Tickets.class);

        restTemplate.put(baseURL + "/ticketss/" + id, tickets);
        Tickets updatedTickets = restTemplate.getForObject(baseURL + "/Tickets/" + id, Tickets.class);
        assertNotNull(updatedTickets);
    }

    @Ignore
    public void testDeleteTickets() {
        int id = 2;
        Tickets tickets = restTemplate.getForObject(baseURL + "/ticketss/" + id, Tickets.class);
        assertNotNull(tickets);
        restTemplate.delete(baseURL + "/ticketss/" + id);
        try {
            tickets = restTemplate.getForObject(baseURL + "/ticketss/" + id, Tickets.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}