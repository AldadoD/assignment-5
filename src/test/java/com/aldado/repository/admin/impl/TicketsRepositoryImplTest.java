package com.aldado.repository.admin.impl;

import com.aldado.domain.admin.Tickets;
import com.aldado.factory.admin.TicketsFactory;
import com.aldado.repository.admin.TicketsRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

public class TicketsRepositoryImplTest {

    private TicketsRepository repository;
    private Tickets tickets;

    private Tickets getTickets() {

        Collection<Tickets> tickets = this.repository.getAll();
        return tickets.iterator().next();

    }

    @Before
    public void setUp() throws Exception {
        this.repository = TicketsRepositoryImpl.getRepository();
        this.tickets = TicketsFactory.getTicket("One Way Ticket");

        repository.create(this.tickets.getTicket(), this.tickets);

    }

    @Test
    public void d_getAll() {

        Collection<Tickets> all = this.repository.getAll();
        System.out.println("In getAll, all = " +all);
    }

    @Test
    public void create() {
        Tickets tickets = new Tickets.Builder()
                .ticket("One way Ticket")
                .build();

        Tickets created = this.repository.create(tickets.getTicket(), tickets);
        System.out.println("\n" + "In Create, created " + created);
        d_getAll();
        Assert.assertSame(created, tickets);
    }

    @Test
    public void update() {

        String newTicket = "Ticket updated to Return";
        Tickets tickets1 = new Tickets.Builder().copy(getTickets()).ticket(newTicket).build();
        System.out.println("\n" + "In update, about to be updated = " + this.tickets.getTicket());
        Tickets updated = this.repository.update(tickets.getTicket(), tickets1);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newTicket, updated.getTicket());
        d_getAll();

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
        System.out.println("\n" + "In Read, read = " + tickets.getTicket());
        Tickets read = this.repository.read(tickets.getTicket());
        d_getAll();
        Assert.assertSame(tickets, read);
    }
}