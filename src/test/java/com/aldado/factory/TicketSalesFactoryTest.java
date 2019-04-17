package com.aldado.factory;

import com.aldado.domain.TicketSales;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class TicketSalesFactoryTest {

    @Test
    public void getTicketSales() {

        String destination = "Cape Town";
        int ticketPrice = 25;
        TicketSales t = TicketSalesFactory.getTicketSales(ticketPrice, destination );
        System.out.println(t);
        Assert.assertNotNull(t.getTicketPrice());
    }
}