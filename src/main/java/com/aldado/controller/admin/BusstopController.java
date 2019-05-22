package com.aldado.controller.admin;

import com.aldado.domain.admin.Busstop;
import com.aldado.service.admin.BusstopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/busstop")
public class BusstopController {
    @Autowired
    //@Qualifier("BusstopServiceImpl")
    private BusstopService service;

    @PostMapping("/create")
    @ResponseBody
    public Busstop create(String s, Busstop busstop) {
        return this.service.create(s, busstop);
    }

    @PostMapping("/update")
    @ResponseBody
    public Busstop update(String s, Busstop busstop) {
        return this.service.update(s, busstop);
    }

    @PostMapping("/delete/id")
    @ResponseBody
    public Busstop delete(String id) {
        return this.service.delete(id);
    }

    @PostMapping("/read/id")
    @ResponseBody
    public Busstop read(String id) {
        return this.service.read(id);
    }

    @PostMapping("/read/all")
    @ResponseBody
    public Collection<Busstop> getAll() {
        return this.service.getAll();
    }


}




