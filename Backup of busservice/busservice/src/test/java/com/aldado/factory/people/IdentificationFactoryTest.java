package com.aldado.factory.people;

import com.aldado.domain.people.Identification;
import com.aldado.factory.people.IdentificationFactory;
import org.junit.Assert;
import org.junit.Test;

public class IdentificationFactoryTest {

    @Test
    public void getIdentity() {

        String id = "";
        Identification i = IdentificationFactory.getIdentity(id);
        System.out.println(i);
        Assert.assertNotNull(i.getId());
    }
}