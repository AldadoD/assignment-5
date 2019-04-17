package com.aldado.factory;

import com.aldado.domain.Commuter;


public class CommuterFactory {

    public static Commuter getCommuter(boolean hasTicket) {
        return new Commuter.Builder().hasTicket(hasTicket).build();
    }
}
