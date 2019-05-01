package com.aldado.factory;

import com.aldado.domain.Bus;
import com.aldado.util.Misc;

public class BusFactory {

    public static Bus getBus(String id, boolean serviceDue) {
        return new Bus.Builder().id(Misc.generateId()).serviceDue(serviceDue).build();
    }
}
