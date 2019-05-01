package com.aldado.factory;

import com.aldado.domain.Commuter;
import com.aldado.util.Misc;


public class CommuterFactory {

    public static Commuter getCommuter(boolean checkValidTicket) {
        return new Commuter.Builder().hasTicket(Misc.checkValidTicket()).build();
    }
}
