package com.aldado.factory;


import com.aldado.domain.Identification;

public class IdentificationFactory {

    public static Identification getIdentity(String id) {
        return new Identification.Builder().id(id).build();
    }
}
