package com.aldado.service.people.impl;

import com.aldado.domain.people.Identification;
import com.aldado.factory.people.IdentificationFactory;
import com.aldado.repository.people.impl.IdentificationRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

public class IdentificationServiceImplTest {

    private IdentificationServiceImpl service = null;
    private IdentificationRepositoryImpl repository;
    private Identification identification;

    private Identification getId(){
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
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
        Assert.assertNotNull(created);
        Assert.assertSame(created, identification);
    }

    @Test
    public void update() {
        String newId = "New Id";
        Identification updated = new Identification.Builder().copy(getId()).id(newId).build();
        System.out.println("\n" + "In update, updated = " + updated);
        Assert.assertSame(newId, updated.getId());

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
        Identification read = this.repository.read(identification.getId());
        System.out.println("\n" + "In Read, read = = " + identification.getId());
        Assert.assertSame(identification, read);
    }

    @Test
    public void d_getAll() {
        Collection<Identification> identifications = this.repository.getAll();
        System.out.println("In getAll, all = " +identifications);
    }
}