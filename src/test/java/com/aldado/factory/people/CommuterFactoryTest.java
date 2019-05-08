package com.aldado.factory.people;

import com.aldado.domain.people.Commuter;
import org.junit.Assert;
import org.junit.Test;



public class CommuterFactoryTest {

    @Test
        public void getCommuter() {

        String id = "";
        boolean hasTicket = equals(false);
        Commuter c = CommuterFactory.getCommuter(id, hasTicket);
        System.out.println(c);
        Assert.assertNotNull(c.getCommuterId());

    }
}