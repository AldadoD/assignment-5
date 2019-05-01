package com.aldado.factory.people;

import com.aldado.domain.people.Busdriver;
import com.aldado.factory.people.BusdriverFactory;
import org.junit.Assert;
        import org.junit.Test;

public class BusdriverFactoryTest {

    @Test
    public void getDriver() {

        String firstName = "John";
        String lastName = "Jacobs";
        String driverId = "";
        Busdriver r = BusdriverFactory.buildDriver(firstName, lastName, driverId);
        System.out.println(r);
        Assert.assertNotNull(r.getDriverId());
    }
}