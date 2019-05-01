package com.aldado.factory.people;

import com.aldado.domain.people.Commuter;

import com.aldado.factory.people.CommuterFactory;
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