package com.aldado.repository.people.impl;

import com.aldado.domain.people.Inspector;
import com.aldado.factory.people.InspectorFactory;
import com.aldado.repository.people.InspectorRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

public class InspectorRepositoryImplTest {
    private InspectorRepository repository;
    private Inspector inspector;

    private Inspector getInspector() {
        Collection<Inspector> inspector = this.repository.getAll();
        return inspector.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = InspectorRepositoryImpl.getRepository();
        this.inspector = InspectorFactory.getInspector("Inspector Name", "Inspector Surname", "Inspector Id", true);

        repository.create(this.inspector.getId(), this.inspector);
    }

    @Test
    public void create() {
        Inspector inspector = new Inspector.Builder()
                .inspectorFirstName("Inspector Name")
                .inspectorLastName("Inspector Surname")
                .id("Inspector Id")
                .validTicket(true)
                .build();

        Inspector created = this.repository.create(inspector.getId(), inspector);
        System.out.println("\n" + "In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, inspector);

    }

    @Test
    public void delete() {

        Inspector inspector = getInspector();
        System.out.println("\n" + "In Delete, delete = " + inspector);
        this.repository.delete(this.inspector.getId());
        d_getAll();
        Assert.assertNotNull(inspector);
    }



    @Test
    public void read() {
        Inspector inspector = getInspector();
        System.out.println("\n" + "In Read, read = "+ inspector.getId());
        Inspector read = this.repository.read(inspector.getId());
        d_getAll();
        Assert.assertSame(inspector, read);
    }

    @Test
    public void update() {
        String newId = "Id updated";
        Inspector inspector = new Inspector.Builder().copy(getInspector()).id(newId).build();
        System.out.println("\n" + "In update, about to be updated = " + this.inspector.getId());
        Inspector updated = this.repository.update(inspector.getId(), inspector);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newId, updated.getId());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Collection<Inspector> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
    }
}