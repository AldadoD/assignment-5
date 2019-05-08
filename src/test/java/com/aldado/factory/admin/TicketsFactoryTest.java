package com.aldado.factory.admin;

import com.aldado.domain.admin.Tickets;
import org.junit.Assert;
import org.junit.Test;

public class TicketsFactoryTest {

    @Test
    public void getTickets() {

        String ticket = "One Way Ticket";
        Tickets t = TicketsFactory.getTicket(ticket);
        System.out.println(t);
        Assert.assertNotNull(t.getTicket());

    }
}