package com.aldado.factory.admin;

import com.aldado.domain.admin.Bus;
import com.aldado.util.Misc;

public class BusFactory {

    public static Bus getBus(String id, boolean serviceDue) {
        return new Bus.Builder().id(Misc.generateId()).serviceDue(serviceDue).build();
    }
}
