package com.aldado.factory;

import com.aldado.domain.TicketSales;

public class TicketSalesFactory {

    public static TicketSales getTicketSales(int ticketPrice, String destination){
        return new TicketSales.Builder().destination(destination).tickePrice(ticketPrice).build();
    }
}
