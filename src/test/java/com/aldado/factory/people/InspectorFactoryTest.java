package com.aldado.factory.people;

import com.aldado.domain.people.Inspector;
import com.aldado.factory.admin.InspectorFactory;
import org.junit.Assert;
import org.junit.Test;

public class InspectorFactoryTest {

    @Test
    public void getInspector() {

        String firstName = "Andrew";
        String lastName = "Peters";
        String id = "";
        boolean validTicket = equals(false);
        Inspector i = InspectorFactory.getInspector(firstName, lastName, id, validTicket);
        System.out.println(i);
        Assert.assertNotNull(i.getId());
    }
}