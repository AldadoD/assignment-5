package com.aldado.service.people.impl;

import com.aldado.domain.people.Inspector;
import com.aldado.factory.people.InspectorFactory;
import com.aldado.repository.people.impl.InspectorRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

public class InspectorServiceImplTest {

    private InspectorServiceImpl service = null;
    private InspectorRepositoryImpl repository;
    private Inspector inspector;

    private Inspector getInspector(){
        return this.repository.getAll().iterator().next();
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
        Assert.assertNotNull(created);
        Assert.assertSame(created, inspector);

    }

    @Test
    public void update() {
        String newId = "Id updated";
        Inspector updated = new Inspector.Builder().copy(getInspector()).id(newId).build();
        System.out.println("\n" + "In update, updated = " + updated);
        Assert.assertSame(newId, updated.getId());

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
        Inspector read = this.repository.read(inspector.getId());
        System.out.println("\n" + "In Read, read = "+ inspector.getId());
        Assert.assertSame(inspector, read);
    }

    @Test
    public void d_getAll() {
        Collection<Inspector> inspectors = this.repository.getAll();
        System.out.println("In getAll, all = " + inspectors);
    }
}