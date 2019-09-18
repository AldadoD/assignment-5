package com.aldado.factory.admin;

import com.aldado.domain.admin.Bus;

public class BusFactory {

    public static Bus getBus(String id, boolean serviceDue) {
        return new Bus.Builder().id("id").serviceDue(serviceDue).build();
    }
}
