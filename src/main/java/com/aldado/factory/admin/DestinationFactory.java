package com.aldado.factory.admin;

import com.aldado.domain.admin.Destination;
import com.aldado.util.Misc;

public class DestinationFactory {

    public static Destination getDestination(String name, String id) {
        return new Destination.Builder().name(name).id(Misc.generateId()).build();
    }
}
