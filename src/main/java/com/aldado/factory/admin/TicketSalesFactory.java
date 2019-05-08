package com.aldado.factory.admin;

import com.aldado.domain.admin.TicketSales;

public class TicketSalesFactory {

    public static TicketSales getTicketSales(String ticketPrice, String destination){
        return new TicketSales.Builder().destination(destination).ticketPrice(ticketPrice).build();
    }
}
