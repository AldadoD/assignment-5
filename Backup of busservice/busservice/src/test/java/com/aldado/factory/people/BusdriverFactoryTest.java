package com.aldado.factory.people;

import com.aldado.domain.people.Busdriver;
import org.junit.Assert;
import org.junit.Test;

public class BusdriverFactoryTest {

    @Test
    public void getDriver() {

        String firstName = "John";
        String lastName = "Dampies";
        String driverId = "";
        Busdriver r = BusdriverFactory.buildDriver(firstName, lastName, driverId);
        System.out.println(r);
        Assert.assertNotNull(r.getDriverId());
    }
}