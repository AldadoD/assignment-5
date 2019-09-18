package com.aldado.controller;

import com.aldado.controller.admin.BusControllerTest;
import com.aldado.controller.people.BusdriverControllerTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        BusControllerTest.class,
        BusdriverControllerTest.class,
        RoleControllerTest.class

})
public class TestAll {

}
