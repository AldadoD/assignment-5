package com.aldado.factory.people;


import com.aldado.domain.people.Identification;
import com.aldado.util.Misc;

public class IdentificationFactory {

    public static Identification getIdentity(String id) {
        return new Identification.Builder().id(Misc.generateId()).build();
    }
}
