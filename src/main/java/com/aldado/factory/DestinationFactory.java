package com.aldado.factory;

import com.aldado.domain.Destination;
import com.aldado.util.Misc;

public class DestinationFactory {

    public static Destination getDestination(String name, String id) {
        return new Destination.Builder().name(name).id(Misc.generateId()).build();
    }
}
