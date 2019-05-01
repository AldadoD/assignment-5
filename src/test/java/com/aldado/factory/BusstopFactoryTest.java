package com.aldado.factory;

import com.aldado.domain.Busstop;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class BusstopFactoryTest {

    @Test
    public void getBusstop() {


        String code = "A5467";

        Busstop bs = BusstopFactory.getBusstop(code);
        System.out.println(bs);
        Assert.assertNotNull(bs.getCode());
    }

}