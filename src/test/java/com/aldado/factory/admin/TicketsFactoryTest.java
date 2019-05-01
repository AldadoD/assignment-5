package com.aldado.factory.admin;

import com.aldado.domain.admin.Tickets;
import com.aldado.factory.admin.TicketsFactory;
import org.junit.Assert;
import org.junit.Test;

public class TicketsFactoryTest {

    @Test
    public void getTickets() {

        String tickets = "";
        Tickets t = TicketsFactory.getTicket(tickets);
        System.out.println(t);
        Assert.assertNull(t.getTicket());

    }
}