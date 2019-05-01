package com.aldado.factory;

import com.aldado.domain.Bus;
import org.junit.Assert;
import org.junit.Test;

public class BusFactoryTest {

    @Test
    public void getBus() {

        String id = "";
        boolean validTicket = equals(false);
        Bus b = BusFactory.getBus(id, validTicket);
        System.out.println(b);
        Assert.assertNotNull(b.getId());
    }
}