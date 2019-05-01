package com.aldado.repository.people.impl;

import com.aldado.domain.Busdriver;
import com.aldado.factory.BusdriverFactory;
import com.aldado.repository.people.BusdriverRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BusdriverRepositoryImplTest {

    private BusdriverRepository repository;
    private Busdriver busdriver;

    private Busdriver getBusdriver() {
        Set<Busdriver> busdriver = this.repository.getAll();
        return busdriver.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = BusdriverRepositoryImpl.getRepository();
        this.busdriver = BusdriverFactory.buildDriver("John", "Jacobs", "");
    }

    @Test
    public void create() {
        Busdriver created = this.repository.create(this.busdriver);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.busdriver);

    }


    @Test
    public void delete() {
        Busdriver savedCourse = getBusdriver();
        this.repository.delete(savedCourse.getDriverId());
        d_getAll();
    }

    @Test
    public void read() {
        Busdriver busdriver = getBusdriver();
        System.out.println("In read, driverId = "+ busdriver.getDriverId());
        Busdriver read = this.repository.read(busdriver.getDriverId());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertNotSame(busdriver, read);
    }

    @Test
    public void update() {
        String newname = "New Driver Name";
        Busdriver busdriver = new Busdriver.Builder().copy(getBusdriver()).driverFirstName(newname).build();
        System.out.println("In update, about_to_updated = " + busdriver);
        Busdriver updated = this.repository.update(busdriver);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newname, updated.getDriverFirstName());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<Busdriver> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
    }
}