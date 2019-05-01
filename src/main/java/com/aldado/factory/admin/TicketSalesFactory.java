package com.aldado.factory.admin;

import com.aldado.domain.admin.TicketSales;

public class TicketSalesFactory {

    public static TicketSales getTicketSales(int ticketPrice, String destination){
        return new TicketSales.Builder().destination(destination).tickePrice(ticketPrice).build();
    }
}
