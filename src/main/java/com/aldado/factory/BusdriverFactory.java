package com.aldado.factory;

import com.aldado.domain.Busdriver;
import com.aldado.util.Misc;


public class BusdriverFactory {

    public static Busdriver getDriver(String firstName, String lastName, String driverId) {
        return new Busdriver.Builder().driverFirstName(firstName).driverLastName(lastName).driverId(Misc.generateId()).build();
    }
}
