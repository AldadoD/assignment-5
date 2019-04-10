package com.aldado.factory;

import com.aldado.domain.Routes;
import org.junit.Assert;
import org.junit.Test;

public class RoutesFactoryTest {

    @Test
    public void getRoutes() {

        String name = "Southern Suburbs";
        Routes r = RoutesFactory.getRoutes(name);
        System.out.println(r);
        Assert.assertNotNull(r.getRouteId());
    }
}