package com.aldado.factory.admin;

import com.aldado.domain.admin.TicketSales;
import org.junit.Assert;
import org.junit.Test;

public class TicketSalesFactoryTest {

    @Test
    public void getTicketSales() {

        String destination = "Cape Town";
        String ticketPrice = "R25.00";
        TicketSales t = TicketSalesFactory.getTicketSales(ticketPrice, destination );
        System.out.println(t);
        Assert.assertNotNull(t.getTicketPrice());
    }
}