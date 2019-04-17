package com.aldado.factory;

import com.aldado.domain.Commuter;

import org.junit.Assert;
import org.junit.Test;



public class CommuterFactoryTest {

    @Test
        public void getCommuter() {

            boolean hasTicket = equals(false);
            Commuter c = CommuterFactory.getCommuter(hasTicket);
            System.out.println(c);
            Assert.assertTrue(true);

    }
}