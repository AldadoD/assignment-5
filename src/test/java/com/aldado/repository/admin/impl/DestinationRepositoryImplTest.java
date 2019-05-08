package com.aldado.repository.admin.impl;

import com.aldado.domain.admin.Destination;
import com.aldado.factory.admin.DestinationFactory;
import com.aldado.repository.admin.DestinationRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

public class DestinationRepositoryImplTest {

    private DestinationRepository repository;
    private Destination destination;

    private Destination getDestination(){

        Collection<Destination> destinations = this.repository.getAll();
        return destinations.iterator().next();
    }
    @Before
    public void setUp() throws Exception{
        this.repository = DestinationRepositoryImpl.getRepository();
        this.destination = DestinationFactory.getDestination("Destination", "Destination Id");

        repository.create(this.destination.getId(), this.destination);
    }



    @Test
    public void create() {
        Destination destination = new Destination.Builder()
                .id("id")
                .name("Name")
                .build();

        Destination created = this.repository.create(destination.getId(), destination);
        System.out.println("\n" + "In Create, created " + created);
        d_getAll();
        Assert.assertSame(created, destination);
    }

    @Test
    public void update() {

        String newId = "New Destination Id";
        Destination destination = new Destination.Builder().copy(getDestination()).id(newId).build();
        System.out.println("\n" + "In update, about to be updated = " + this.destination);
        Destination updated = this.repository.update(destination.getId(), destination);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newId, updated.getId());
        d_getAll();
    }

    @Test
    public void delete() {

        Destination destination = getDestination();
        System.out.println("\n" + "In Delete, delete = " + destination);
        this.repository.delete(this.destination.getId());
        d_getAll();
        Assert.assertNotNull(destination);

    }

    @Test
    public void read() {

        Destination destination = getDestination();
        System.out.println("\n" + "In Read, read = = " + destination.getId());
        Destination read = this.repository.read(destination.getId());
        d_getAll();
        Assert.assertSame(destination, read);
    }

    @Test
    public void d_getAll() {

        Collection<Destination> all = this.repository.getAll();
        System.out.println("In getAll, all = " +all);
    }
}