package com.aldado.factory;

import com.aldado.domain.Busdriver;
import org.junit.Assert;
import org.junit.Test;

public class BusdriverFactoryTest {

    @Test
    public void getDriver() {

        String firstName = "John";
        String lastName = "Jacobs";
        String driverId = "";
        Busdriver r = BusdriverFactory.getDriver(firstName, lastName, driverId);
        System.out.println(r);
        Assert.assertNotNull(r.getDriverId());
    }
}