package com.aldado.factory.people;

import com.aldado.domain.people.Name;
import com.aldado.factory.people.NameFactory;
import org.junit.Assert;
import org.junit.Test;

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