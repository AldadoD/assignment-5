package com.aldado.repository.people.impl;

import com.aldado.domain.people.Busdriver;
import com.aldado.factory.people.BusdriverFactory;
import com.aldado.repository.people.BusdriverRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Collection;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BusdriverRepositoryImplTest {

    private BusdriverRepository repository;
    private Busdriver busdriver;

    private Busdriver getBusdriver() {
        Collection<Busdriver> busdriver = this.repository.getAll();
        return busdriver.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = BusdriverRepositoryImpl.getRepository();
        this.busdriver = BusdriverFactory.buildDriver("John", "Jacobs", "");

        repository.create(this.busdriver.getDriverId(), this.busdriver);
    }

    @Test
    public void create() {
        Busdriver busdriver = new Busdriver.Builder()
                .driverId("")
                .driverFirstName("John")
                .driverLastName("Jacobs")
                .build();

        Busdriver created = this.repository.create(busdriver.getDriverId(), busdriver);
        System.out.println("\n" + "In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, busdriver);

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
        System.out.println("\n" + "In read, read = "+ busdriver.getDriverId());
        Busdriver read = this.repository.read(busdriver.getDriverId());
//        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertSame(busdriver, read);
    }

    @Test
    public void update() {
        String newname = "Allan";
        Busdriver busdriver = new Busdriver.Builder().copy(getBusdriver()).driverFirstName(newname).build();
        System.out.println("\n" + "In update, about_to_updated = " + busdriver);
        Busdriver updated = this.repository.update(busdriver.getDriverId(), busdriver);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newname, updated.getDriverFirstName());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Collection<Busdriver> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
    }
}