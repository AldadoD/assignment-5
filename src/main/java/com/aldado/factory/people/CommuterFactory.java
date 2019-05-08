package com.aldado.factory.people;

import com.aldado.domain.people.Commuter;
import com.aldado.util.Misc;


public class CommuterFactory {

    public static Commuter getCommuter(String commuterId, boolean checkValidTicket) {
        return new Commuter.Builder().hasTicket(Misc.checkValidTicket()).commuterId(Misc.generateId()).build();

    }
}
