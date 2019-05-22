package com.aldado.service.people.impl;

import com.aldado.domain.people.Busdriver;
import com.aldado.factory.people.BusdriverFactory;
import com.aldado.repository.people.impl.BusdriverRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

public class BusdriverServiceImplTest {

    private BusdriverServiceImpl service = null;
    private BusdriverRepositoryImpl repository;
    private Busdriver busdriver;

    private Busdriver getBusdriver(){
        return  this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = BusdriverRepositoryImpl.getRepository();
        this.busdriver = BusdriverFactory.buildDriver("James", "Johnson", "");

        repository.create(this.busdriver.getDriverId(), this.busdriver);
    }

    @Test
    public void create() {
        Busdriver busdriver = new Busdriver.Builder()
                .driverId("")
                .driverFirstName("James")
                .driverLastName("Johnson")
                .build();

        Busdriver created = this.repository.create(busdriver.getDriverId(), busdriver);
        System.out.println("\n" + "In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, busdriver);


    }

    @Test
    public void update() {
        String newname = "Allan";
        Busdriver updated = new Busdriver.Builder().copy(getBusdriver()).driverFirstName(newname).build();
        System.out.println("\n" + "In update, updated = " + updated);
        Assert.assertSame(newname, updated.getDriverFirstName());

    }

    @Test
    public void delete() {
        Busdriver busdriver = getBusdriver();
        System.out.println("\n" + "In Delete, delete = " + busdriver);
        this.repository.delete(busdriver.getDriverId());
        d_getAll();
        Assert.assertNotNull(busdriver);
    }

    @Test
    public void read() {
        Busdriver busdriver = getBusdriver();
        Busdriver read = this.repository.read(busdriver.getDriverId());
        System.out.println("\n" + "In read, read = "+ busdriver.getDriverId());
        Assert.assertSame(busdriver, read);
    }

    @Test
    public void d_getAll() {
        Collection<Busdriver> busdrivers = this.repository.getAll();
        System.out.println("In getAll, all = " + busdrivers);
    }
}