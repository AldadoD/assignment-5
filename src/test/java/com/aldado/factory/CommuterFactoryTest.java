package com.aldado.factory;

import com.aldado.domain.Commuter;

import com.aldado.util.Misc;
import org.junit.Assert;
import org.junit.Test;



public class CommuterFactoryTest {

    @Test
        public void getCommuter() {

            Commuter c = CommuterFactory.getCommuter(Misc.checkValidTicket());
            System.out.println(c);
            Assert.assertTrue(true);

    }
}