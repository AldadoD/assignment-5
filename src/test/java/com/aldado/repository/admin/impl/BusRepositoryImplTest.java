package com.aldado.repository.admin.impl;

import com.aldado.domain.admin.Bus;
import com.aldado.repository.admin.BusRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

public class BusRepositoryImplTest {
    private BusRepository repository;
    private Bus bus;

    private Bus getBus(String s, String aTrue, String aFalse) {
        Set<Bus> bus = this.repository.getAll();
        return bus.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = BusRepositoryImpl.getRepository();
        this.bus = getBus("", "True", "False");
    }

//    private Bus getBus(String s, String aTrue, String aFalse) {
//        return null;
//    }

    @Test
    public void create() {
        Bus created = this.repository.create(this.bus);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.bus);

    }


    @Test
    public void delete() {
        Bus bus = getBus("", "True", "False");
        this.repository.delete(bus.getId());
        d_getAll();
    }



    @Test
    public void read() {
        Bus bus = getBus("", "True", "False");
        System.out.println("In read, driverId = "+ bus.getId());
        Bus read = this.repository.read(bus.getId());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertSame(bus, read);
    }

    @Test
    public void update() {
        String newId = "New Bus Id";
        Bus bus = new Bus.Builder().copy(getBus("", "True", "False")).id(newId).build();
//        Bus bus = new Bus.Builder().copy(getBus()).Id(newId).build();
        System.out.println("In update, about_to_updated = " + bus);
        Bus updated = this.repository.update(bus);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newId, updated.getId());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<Bus> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
    }
}
