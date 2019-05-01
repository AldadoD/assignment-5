package com.aldado.factory;

import com.aldado.domain.Busstop;

public class BusstopFactory {

    public static Busstop getBusstop(String code) {
        return new Busstop.Builder().code(code).build();
    }
}
