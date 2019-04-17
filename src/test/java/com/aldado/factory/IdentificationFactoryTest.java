package com.aldado.factory;

import com.aldado.domain.Identification;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class IdentificationFactoryTest {

    @Test
    public void getIdentity() {

        String id = "";
        Identification i = IdentificationFactory.getIdentity(id);
        System.out.println(i);
        Assert.assertNotNull(i.getId());
    }
}