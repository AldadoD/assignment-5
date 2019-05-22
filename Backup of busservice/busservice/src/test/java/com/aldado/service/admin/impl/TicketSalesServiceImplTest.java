package com.aldado.service.admin.impl;

import com.aldado.domain.admin.TicketSales;
import com.aldado.factory.admin.TicketSalesFactory;
import com.aldado.repository.admin.impl.TicketSalesRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

public class TicketSalesServiceImplTest {

    private TicketSalesServiceImpl service = null;
    private TicketSalesRepositoryImpl repository;
    private TicketSales ticketSales;

    private TicketSales getTicketSales(){
        return  this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = TicketSalesRepositoryImpl.getRepository();
        this.ticketSales = TicketSalesFactory.getTicketSales("R25.00", "Destination");

        repository.create(this.ticketSales.getTicketPrice(), this.ticketSales);
    }

    @Test
    public void create() {
        TicketSales ticketSales = new TicketSales.Builder()
                .ticketPrice("R25.00")
                .destination("Name")
                .build();

        TicketSales created = this.repository.create(ticketSales.getTicketPrice(), ticketSales);
        System.out.println("\n" + "In Create, created " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, ticketSales);
    }

    @Test
    public void update() {
        String newPrice = "Price updated";
        TicketSales updated = new TicketSales.Builder().copy(getTicketSales()).ticketPrice(newPrice).build();
        System.out.println("\n" + "In update, updated = " + updated);
        Assert.assertSame(newPrice, updated.getTicketPrice());

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
        TicketSales read = this.repository.read(ticketSales.getTicketPrice());
        System.out.println("\n" + "In Read, read = " + ticketSales.getTicketPrice());
        Assert.assertSame(ticketSales, read);
    }

    @Test
    public void d_getAll() {
        Collection<TicketSales> all = this.repository.getAll();
        System.out.println("In getAll, all = " +all);
    }
}