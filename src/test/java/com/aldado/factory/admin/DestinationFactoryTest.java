package com.aldado.factory.admin;

import com.aldado.domain.admin.Destination;
import com.aldado.factory.admin.DestinationFactory;
import org.junit.Assert;
import org.junit.Test;

public class DestinationFactoryTest {

    @Test
    public void getDestination() {

        String name = "City";
        String id = "";
        Destination dest = DestinationFactory.getDestination(name, id);
        System.out.println(dest);
        Assert.assertNotNull(dest.getId());
    }
}