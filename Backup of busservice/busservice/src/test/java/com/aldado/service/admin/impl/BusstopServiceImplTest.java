package com.aldado.service.admin.impl;

import com.aldado.domain.admin.Busstop;
import com.aldado.factory.admin.BusstopFactory;
import com.aldado.repository.admin.impl.BusstopRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

public class BusstopServiceImplTest {

    private BusstopServiceImpl service = null;
    private BusstopRepositoryImpl repository;
    private Busstop busstop;

    private Busstop getBusstop(){
        return  this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = BusstopRepositoryImpl.getRepository();
        this.busstop = BusstopFactory.getBusstop("Bus stop code");

        repository.create(this.busstop.getCode(), this.busstop);
    }

    @Test
    public void create() {
        Busstop busstop = new Busstop.Builder()
                .code("Bus stop code")
                .build();

        Busstop created = this.repository.create(busstop.getCode(), busstop);
        System.out.println("\n" + "In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, busstop);
    }

    @Test
    public void update() {
        String newCode = "Code updated";
        Busstop updated = new Busstop.Builder().copy(getBusstop()).code(newCode).build();
        System.out.println("\n" + "In update, Code updated = " + updated);


    }

    @Test
    public void delete() {
        Busstop busstop = getBusstop();
        System.out.println("\n" + "In Delete, delete = " + busstop);
        this.repository.delete(this.busstop.getCode());
        d_getAll();
        Assert.assertSame(busstop, this.busstop);
    }

    @Test
    public void read() {
        Busstop busstop = getBusstop();
        Busstop read = this.repository.read(busstop.getCode());
        System.out.println("\n" + "In Read, read = "+ busstop.getCode());
        Assert.assertSame(busstop, read);
    }

    @Test
    public void d_getAll() {
        Collection<Busstop> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
    }
}