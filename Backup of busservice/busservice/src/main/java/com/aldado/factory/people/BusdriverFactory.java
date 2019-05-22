package com.aldado.factory.people;

import com.aldado.domain.people.Busdriver;
import com.aldado.util.Misc;


public class BusdriverFactory {

    public static Busdriver buildDriver(String firstName, String lastName, String driverId) {
        return new Busdriver.Builder().driverFirstName(firstName).driverLastName(lastName).driverId(Misc.generateId()).build();
    }
}
