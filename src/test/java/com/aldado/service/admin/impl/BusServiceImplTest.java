package com.aldado.service.admin.impl;

import com.aldado.domain.admin.Bus;
import com.aldado.factory.admin.BusFactory;
import com.aldado.repository.admin.impl.BusRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service("BusServiceImpl")
public class BusServiceImplTest {
    @Autowired

    private BusServiceImpl service = null;
    private BusRepositoryImpl repository;
    private Bus bus;

    private Bus getBus(){
        return  this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = BusRepositoryImpl.getRepository();
        this.bus = BusFactory.getBus("", true);

        repository.create(this.bus.getId(), this.bus);
    }

    @Test
    public void create() {
        Bus bus = new Bus.Builder()
                .id("Bus id")
                .serviceDue(true)
                .build();

        Bus created = this.repository.create(bus.getId(), bus);
        System.out.println("\n" + "In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, bus);
    }

    @Test
    public void update() {
        String newId = "Id updated";
        Bus updated = new Bus.Builder().copy(getBus()).id(newId).build();
        System.out.println("\n" + "In update, updated = " + updated);
        Assert.assertSame(newId, updated.getId());

    }

    @Test
    public void delete() {
        Bus bus = getBus();
        System.out.println("\n" + "In Delete, delete = " + bus);
        this.repository.delete(this.bus.getId());
        getAll();
        Assert.assertNotNull(bus);
    }

    @Test
    public void read() {
        Bus bus = getBus();
        Bus read = this.repository.read(bus.getId());
        System.out.println("\n" + "In Read, read = "+ bus.getId());
        Assert.assertSame(bus, read);
    }

    @Test
    public void getAll() {
        Collection<Bus> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
    }
}