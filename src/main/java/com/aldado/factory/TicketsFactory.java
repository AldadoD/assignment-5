package com.aldado.factory;

import com.aldado.domain.Tickets;

public class TicketsFactory {

    public static Tickets getTickets(String ticket) {
        return new Tickets.Builder().ticket(ticket).build();
    }
}
