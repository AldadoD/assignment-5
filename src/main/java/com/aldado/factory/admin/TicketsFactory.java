package com.aldado.factory.admin;

import com.aldado.domain.admin.Tickets;

public class TicketsFactory {

    public static Tickets getTicket(String ticket) {
        return new Tickets.Builder().ticket(ticket).build();
    }
}
