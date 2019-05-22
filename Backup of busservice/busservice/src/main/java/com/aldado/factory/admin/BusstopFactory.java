package com.aldado.factory.admin;

import com.aldado.domain.admin.Busstop;

public class BusstopFactory {

    public static Busstop getBusstop(String code) {
        return new Busstop.Builder().code(code).build();
    }
}
