package com.aldado.factory;

import com.aldado.domain.Busdriver;
import com.aldado.domain.Inspector;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

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