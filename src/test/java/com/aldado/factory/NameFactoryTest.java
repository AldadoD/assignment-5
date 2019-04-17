package com.aldado.factory;

import com.aldado.domain.Name;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class NameFactoryTest {

    @Test
    public void getName() {

        String firstName = "";
        String lastName = "";

        Name n = NameFactory.getName(firstName, lastName);
        System.out.println(n);
        Assert.assertNotNull(n.getFirstName());
    }
}