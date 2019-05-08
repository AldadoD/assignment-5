package com.aldado.repository.admin.impl;

import com.aldado.domain.admin.Busstop;
import com.aldado.factory.admin.BusstopFactory;
import com.aldado.repository.admin.BusstopRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

public class BusstopRepositoryImplTest {

    private BusstopRepository repository;
    private Busstop busstop;

    private Busstop getBusstop(){

        Collection<Busstop> busstops = this.repository.getAll();
        return busstops.iterator().next();
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
        d_getAll();
        Assert.assertSame(created, busstop);
    }


    @Test
    public void update() {
        String newCode = "Code updated";
        Busstop busstop = new Busstop.Builder().copy(getBusstop()).code(newCode).build();
        System.out.println("\n" + "In update, Code about to be updated = " + this.getBusstop());
        Busstop updated = this.repository.update(busstop.getCode(), busstop);
        System.out.println("In update, Code updated = " + updated);
        Assert.assertSame(newCode, updated.getCode());
        d_getAll();

    }

    @Test
    public void read() {
        Busstop busstop = getBusstop();
        System.out.println("\n" + "In Read, read = "+ busstop.getCode());
        Busstop read = this.repository.read(busstop.getCode());
        d_getAll();
        Assert.assertSame(busstop, read);
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
    public void d_getAll() {
        Collection<Busstop> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
    }
}