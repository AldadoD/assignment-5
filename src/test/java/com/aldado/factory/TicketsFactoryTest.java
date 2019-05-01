package com.aldado.factory;

import com.aldado.domain.Tickets;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class TicketsFactoryTest {

    @Test
    public void getTickets() {

        String tickets = "";
        Tickets t = TicketsFactory.getTicket(tickets);
        System.out.println(t);
        Assert.assertNull(t.getTicket());

    }
}