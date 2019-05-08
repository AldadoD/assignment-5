package com.aldado.repository.admin.impl;

import com.aldado.domain.admin.TicketSales;
import com.aldado.factory.admin.TicketSalesFactory;
import com.aldado.repository.admin.TicketSalesRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

public class TicketSalesRepositoryImplTest {

    private TicketSalesRepository repository;
    private TicketSales ticketSales;

    private TicketSales getTicketSales() {

        Collection<TicketSales> ticketSales = this.repository.getAll();
        return ticketSales.iterator().next();

    }

    @Before
    public void setUp() throws Exception {
        this.repository = TicketSalesRepositoryImpl.getRepository();
        this.ticketSales = TicketSalesFactory.getTicketSales("R22.00", "Destination");

        repository.create(this.ticketSales.getTicketPrice(), this.ticketSales);

    }

    @Test
    public void d_getAll() {

        Collection<TicketSales> all = this.repository.getAll();
        System.out.println("In getAll, all = " +all);
    }

    @Test
    public void create() {

        TicketSales ticketSales = new TicketSales.Builder()
                .ticketPrice("R25.00")
                .destination("Name")
                .build();

        TicketSales created = this.repository.create(ticketSales.getTicketPrice(), ticketSales);
        System.out.println("\n" + "In Create, created " + created);
        d_getAll();
        Assert.assertSame(created, ticketSales);
    }

    @Test
    public void update() {

        String newPrice = "Price updated";
        TicketSales ticketSales = new TicketSales.Builder().copy(getTicketSales()).ticketPrice(newPrice).build();
        System.out.println("\n" + "In update, about to be updated = " + this.ticketSales.getTicketPrice());
        TicketSales updated = this.repository.update(ticketSales.getTicketPrice(), ticketSales);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newPrice, updated.getTicketPrice());
        d_getAll();
    }

    @Test
    public void delete() {

        TicketSales ticketSales = getTicketSales();
        System.out.println("\n" + "In Delete, delete = " + ticketSales);
        this.repository.delete(this.ticketSales.getTicketPrice());
        d_getAll();
        Assert.assertSame(ticketSales, ticketSales);
    }

    @Test
    public void read() {

        TicketSales ticketSales = getTicketSales();
        System.out.println("\n" + "In Read, read = " + ticketSales.getTicketPrice());
        TicketSales read = this.repository.read(ticketSales.getTicketPrice());
        d_getAll();
        Assert.assertSame(ticketSales, read);
    }
}