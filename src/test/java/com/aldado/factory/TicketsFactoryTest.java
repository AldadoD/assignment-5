package com.aldado.factory;

import com.aldado.domain.Tickets;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class TicketsFactoryTest {

    @Test
    public void getTickets() {

        String tickets = "";
        Tickets t = TicketsFactory.getTickets(tickets);
        System.out.println(t);
        Assert.assertNotNull(t.getTicket());

    }
}