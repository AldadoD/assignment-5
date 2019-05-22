package com.aldado.service.admin.impl;

import com.aldado.domain.admin.Routes;
import com.aldado.factory.admin.RoutesFactory;
import com.aldado.repository.admin.impl.RoutesRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

public class RoutesServiceImplTest {

    private RoutesServiceImpl service = null;
    private RoutesRepositoryImpl repository;
    private Routes routes;

    private Routes getRoutes(){
        return  this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = RoutesRepositoryImpl.getRepository();
        this.routes = RoutesFactory.getRoutes("Route Name", "Route Id");

        repository.create(this.routes.getRouteId(), this.routes);
    }

    @Test
    public void create() {
        Routes routes = new Routes.Builder()
                .routeId("Route id")
                .routeName("Route Name")
                .build();

        Routes created = this.repository.create(routes.getRouteId(), routes);
        System.out.println("\n" + "In Create, created " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, routes);
    }

    @Test
    public void update() {
        String newId = "Id updated";
        Routes updated = new Routes.Builder().copy(getRoutes()).routeId(newId).build();
        System.out.println("\n" +"In update, updated = " + updated);
        Assert.assertSame(newId, updated.getRouteId());

    }

    @Test
    public void delete() {
        Routes routes = getRoutes();
        System.out.println("\n" + "In Delete, delete = " + routes);
        this.repository.delete(this.routes.getRouteId());
        d_getAll();
        Assert.assertNotNull(routes);
    }

    @Test
    public void read() {
        Routes routes = getRoutes();
        Routes read = this.repository.read(routes.getRouteId());
        System.out.println("\n" + "In Read, read = " + routes.getRouteId());
        Assert.assertSame(routes, read);
    }

    @Test
    public void d_getAll() {
        Collection<Routes> all = this.repository.getAll();
        System.out.println("In getAll, all = " +all);
    }
}