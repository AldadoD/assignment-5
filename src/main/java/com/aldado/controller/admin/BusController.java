package com.aldado.controller.admin;

import com.aldado.domain.admin.Bus;
import com.aldado.service.admin.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/bus")
public class BusController {
    @Autowired
    //@Qualifier("BusServiceImpl")
    private BusService service;

    @PostMapping("/create")
    @ResponseBody
    public Bus create(String s, Bus bus) {
        return this.service.create(s, bus);
    }

    @PostMapping("/update")
    @ResponseBody
    public Bus update(String s, Bus bus) {
        return this.service.update(s, bus);
    }

    @PostMapping("/delete/id")
    @ResponseBody
    public Bus delete(String id) {
        return this.service.delete(id);
    }

    @PostMapping("/read/id")
    @ResponseBody
    public Bus read(String id) {
        return this.service.read(id);
    }

    @PostMapping("/read/all")
    @ResponseBody
    public Collection<Bus> getAll() {
        return this.service.getAll();
    }


}
