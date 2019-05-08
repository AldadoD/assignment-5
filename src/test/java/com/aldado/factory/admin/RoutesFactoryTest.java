package com.aldado.factory.admin;

import com.aldado.domain.admin.Routes;
import org.junit.Assert;
import org.junit.Test;

public class RoutesFactoryTest {

    @Test
    public void getRoutes() {

        String name = "Southern Suburbs";
        String id= "route id";
        Routes r = RoutesFactory.getRoutes(name, id);
        System.out.println(r);
        Assert.assertNotNull(r.getRouteId());
    }
}