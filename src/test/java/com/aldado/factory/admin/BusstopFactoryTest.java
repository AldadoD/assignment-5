package com.aldado.factory.admin;

import com.aldado.domain.admin.Busstop;
import com.aldado.factory.admin.BusstopFactory;
import org.junit.Assert;
import org.junit.Test;

public class BusstopFactoryTest {

    @Test
    public void getBusstop() {


        String code = "A5467";

        Busstop bs = BusstopFactory.getBusstop(code);
        System.out.println(bs);
        Assert.assertNotNull(bs.getCode());
    }

}