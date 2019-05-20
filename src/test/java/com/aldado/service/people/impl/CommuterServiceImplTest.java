package com.aldado.service.people.impl;

import com.aldado.domain.people.Commuter;
import com.aldado.factory.people.CommuterFactory;
import com.aldado.repository.people.impl.CommuterRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

public class CommuterServiceImplTest {

    private CommuterServiceImpl service = null;
    private CommuterRepositoryImpl repository;
    private Commuter commuter;

    private Commuter getCommuter(){
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = CommuterRepositoryImpl.getRepository();
        this.commuter = CommuterFactory.getCommuter("Commuter id", true);

        repository.create(this.commuter.getCommuterId(), this.commuter);
    }

    @Test
    public void create() {
        Commuter commuter = new Commuter.Builder()
                .commuterId("Commuter Id")
                .hasTicket(true)
                .build();

        Commuter created = this.repository.create(commuter.getCommuterId(), commuter);
        System.out.println("\n" + "In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, commuter);
    }

    @Test
    public void update() {
        String newId = "Id updated";
        Commuter updated = new Commuter.Builder().copy(getCommuter()).commuterId(newId).build();
        System.out.println("\n" + "In update, updated = " + updated);
        Assert.assertSame(newId, updated.getCommuterId());

    }

    @Test
    public void delete() {
        Commuter commuter = getCommuter();
        System.out.println("\n" + "In Delete, delete = " + commuter);
        this.repository.delete(this.commuter.getCommuterId());
        d_getAll();
        Assert.assertNotNull(commuter);
    }

    @Test
    public void read() {
        Commuter commuter = getCommuter();
        Commuter read = this.repository.read(commuter.getCommuterId());
        System.out.println("\n" + "In Read, read = "+ commuter.getCommuterId());
        Assert.assertSame(commuter, read);
    }

    @Test
    public void d_getAll() {
        Collection<Commuter> commuters = this.repository.getAll();
        System.out.println("In getAll, all = " + commuters);
    }
}