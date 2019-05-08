package com.aldado.repository.people.impl;

import com.aldado.domain.people.Identification;
import com.aldado.factory.people.IdentificationFactory;
import com.aldado.repository.people.IdentificationRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

public class IdentificationRepositoryImplTest {

    private IdentificationRepository repository;
    private Identification identification;

    private Identification getId(){

        Collection<Identification> identifications = this.repository.getAll();
        return identifications.iterator().next();
    }
    @Before
    public void setUp() throws Exception{

          this.repository = IdentificationRepositoryImpl.getRepository();
          this.identification = IdentificationFactory.getIdentity("");

          repository.create(this.identification.getId(), this.identification);

    }

    @Test
    public void create() {
        Identification identification = new Identification.Builder()
                .id("id")
                .build();

        Identification created = this.repository.create(identification.getId(), identification);
        System.out.println("\n" + "In Create, created " + created);
        d_getAll();
        Assert.assertSame(created, identification);
    }

    @Test
    public void update() {

        String newId = "New Id";
        Identification identification = new Identification.Builder().copy(getId()).id(newId).build();
        System.out.println("\n" + "In update, about to be updated = " + this.identification);
        Identification updated = this.repository.update(identification.getId(), identification);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newId, updated.getId());
        d_getAll();
    }

    @Test
    public void delete() {

        Identification identification = getId();
        System.out.println("\n" + "In Delete, delete = " + identification);
        this.repository.delete(this.identification.getId());
        d_getAll();
        Assert.assertNotNull(identification);

    }

    @Test
    public void read() {

        Identification identification = getId();
        System.out.println("\n" + "In Read, read = = " + identification.getId());
        Identification read = this.repository.read(identification.getId());
        d_getAll();
        Assert.assertSame(identification, read);
    }

    @Test
    public void d_getAll() {

        Collection<Identification> all = this.repository.getAll();
        System.out.println("In getAll, all = " +all);
    }
}