package com.aldado.repository.people.impl;

import com.aldado.domain.people.Name;
import com.aldado.factory.people.NameFactory;
import com.aldado.repository.people.NameRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

public class NameRepositoryImplTest {
    private NameRepository repository;
    private Name name;

    private Name getName() {
        Collection<Name> names = this.repository.getAll();
        return names.iterator().next();
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
        d_getAll();
        Assert.assertSame(created, name);

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
        System.out.println("\n" + "In Read, read = "+ name.getFirstName());
        Name read = this.repository.read(inspector.getFirstName());
        d_getAll();
        Assert.assertSame(inspector, read);
    }

    @Test
    public void update() {
        String newName = "Name updated";
        Name name = new Name.Builder().copy(getName()).firstName(newName).build();
        System.out.println("\n" + "In update, about to be updated = " + this.name.getFirstName());
        Name updated = this.repository.update(name.getFirstName(), name);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newName, updated.getFirstName());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Collection<Name> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
    }
}