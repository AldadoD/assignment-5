package com.aldado.repository.people.impl;

import com.aldado.domain.people.Commuter;
import com.aldado.factory.people.CommuterFactory;
import com.aldado.repository.people.CommuterRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

public class CommuterRepositoryImplTest {
    private CommuterRepository repository;
    private Commuter commuter;

    private Commuter getCommuter() {
        Collection<Commuter> busdriver = this.repository.getAll();
        return busdriver.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = CommuterRepositoryImpl.getRepository();
        this.commuter = CommuterFactory.getCommuter("Commuter Id", true);

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
        d_getAll();
        Assert.assertSame(created, commuter);

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
        System.out.println("\n" + "In Read, read = "+ commuter.getCommuterId());
        Commuter read = this.repository.read(commuter.getCommuterId());
        d_getAll();
        Assert.assertSame(commuter, read);
    }

    @Test
    public void update() {
        String newId = "Id updated";
        Commuter commuter = new Commuter.Builder().copy(getCommuter()).commuterId(newId).build();
        System.out.println("\n" + "In update, about to be updated = " + this.commuter.getCommuterId());
        Commuter updated = this.repository.update(commuter.getCommuterId(), commuter);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newId, updated.getCommuterId());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Collection<Commuter> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
    }
}