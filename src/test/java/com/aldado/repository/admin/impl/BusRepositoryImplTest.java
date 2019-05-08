package com.aldado.repository.admin.impl;

import com.aldado.domain.admin.Bus;
import com.aldado.factory.admin.BusFactory;
import com.aldado.repository.admin.BusRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

public class BusRepositoryImplTest {

    private BusRepository repository;
    private Bus bus;


    private Bus getBus() {

    Collection<Bus> buses = this.repository.getAll();
        return buses.iterator().next();
}
    @Before
    public void setUp() throws Exception {
        this.repository = BusRepositoryImpl.getRepository();
        this.bus = BusFactory.getBus("Id Number", true);

        repository.create(this.bus.getId(), this.bus);
    }

    @Test
    public void create() {
        Bus bus = new Bus.Builder()
                .id("id")
                .serviceDue(true)
                .build();

        Bus created = this.repository.create(bus.getId(), bus);
        System.out.println("\n" + "In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, bus);

    }


    @Test
    public void delete() {

        Bus bus = getBus();
        System.out.println("\n" + "In Delete, delete = " + bus);
        this.repository.delete(this.bus.getId());
        d_getAll();
        Assert.assertNotNull(bus);
    }



    @Test
    public void read() {
        Bus bus = getBus();
        System.out.println("\n" + "In Read, read = "+ bus.getId());
        Bus read = this.repository.read(bus.getId());
        d_getAll();
        Assert.assertSame(bus, read);
    }

    @Test
    public void update() {
        String newId = "Id updated";
        Bus bus = new Bus.Builder().copy(getBus()).id(newId).build();
        System.out.println("\n" + "In update, about to be updated = " + this.bus.getId());
        Bus updated = this.repository.update(bus.getId(), bus);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newId, updated.getId());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Collection<Bus> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
    }
}
