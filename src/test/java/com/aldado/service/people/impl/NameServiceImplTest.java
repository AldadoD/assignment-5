package com.aldado.service.people.impl;

import com.aldado.domain.people.Name;
import com.aldado.factory.people.NameFactory;
import com.aldado.repository.people.impl.NameRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

public class NameServiceImplTest {

    private NameServiceImpl service = null;
    private NameRepositoryImpl repository;
    private Name name;

    private Name getName(){
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = NameRepositoryImpl.getRepository();
        this.name = NameFactory.getName("Patrick", "Adams");

        repository.create(this.name.getFirstName(), this.name);
    }


    @Test
    public void create() {
        Name name = new Name.Builder()
                .firstName("Patrick")
                .lastName("Adams")
                .build();

        Name created = this.repository.create(name.getFirstName(), name);
        System.out.println("\n" + "In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, name);
    }

    @Test
    public void update() {
        String newName = "Name updated";
        Name updated = new Name.Builder().copy(getName()).firstName(newName).build();
        System.out.println("\n" + "In update, updated = " + updated);
        Assert.assertSame(newName, updated.getFirstName());

    }

    @Test
    public void delete() {
        Name name = getName();
        System.out.println("\n" + "In Delete, delete = " + name);
        this.repository.delete(this.name.getFirstName());
        d_getAll();
        Assert.assertNotNull(name);
    }

    @Test
    public void read() {
        Name inspector = getName();
        Name read = this.repository.read(inspector.getFirstName());
        System.out.println("\n" + "In Read, read = "+ name.getFirstName());
        Assert.assertSame(inspector, read);
    }

    @Test
    public void d_getAll() {
        Collection<Name> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
    }
}