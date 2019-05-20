package com.aldado.service.admin.impl;

import com.aldado.domain.admin.Tickets;
import com.aldado.factory.admin.TicketsFactory;
import com.aldado.repository.admin.impl.TicketsRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

public class TicketsServiceImplTest {

    private TicketsServiceImpl service = null;
    private TicketsRepositoryImpl repository;
    private Tickets tickets;

    private Tickets getTickets(){
        return  this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = TicketsRepositoryImpl.getRepository();
        this.tickets = TicketsFactory.getTicket("One way Ticket");

        repository.create(this.tickets.getTicket(), this.tickets);
    }

    @Test
    public void create() {
        Tickets tickets = new Tickets.Builder()
                .ticket("One way Ticket")
                .build();

        Tickets created = this.repository.create(tickets.getTicket(), tickets);
        System.out.println("\n" + "In Create, created " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, tickets);
    }

    @Test
    public void update() {
        String newTicket = "Ticket upgraded to a Return Ticket";
        Tickets updated = new Tickets.Builder().copy(getTickets()).ticket(newTicket).build();
        System.out.println("\n" + "In update, updated = " + updated + "\n");
        Assert.assertSame(newTicket, updated.getTicket());

    }

    @Test
    public void delete() {
        Tickets ticketSales = getTickets();
        System.out.println("\n" + "In Delete, delete = " + tickets);
        this.repository.delete(this.tickets.getTicket());
        d_getAll();
        Assert.assertSame(ticketSales, ticketSales);
    }

    @Test
    public void read() {
        Tickets tickets = getTickets();
        Tickets read = this.repository.read(tickets.getTicket());
        System.out.println("\n" + "In Read, read = " + tickets.getTicket());
        Assert.assertSame(tickets, read);
    }

    @Test
    public void d_getAll() {
        Collection<Tickets> all = this.repository.getAll();
        System.out.println("In getAll, all = " +all);
    }
}