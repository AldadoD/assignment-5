package com.aldado.controller.people;


import com.aldado.domain.people.Identification;
import com.aldado.service.people.IdentificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/identification")
public class IdentificationController {
    @Autowired
    //@Qualifier("IdentificationServiceImpl")
    private IdentificationService service;

    @PostMapping("/create")
    @ResponseBody
    public Identification create(String s, Identification identification) {
        return this.service.create(s, identification);
    }

    @PostMapping("/update")
    @ResponseBody
    public Identification update(String s, Identification identification) {
        return this.service.update(s, identification);
    }

    @PostMapping("/delete/id")
    @ResponseBody
    public Identification delete(String id) {
        return this.service.delete(id);
    }

    @PostMapping("/read/id")
    @ResponseBody
    public Identification read(String id) {
        return this.service.read(id);
    }

    @PostMapping("/read/all")
    @ResponseBody
    public Collection<Identification> getAll() {
        return this.service.getAll();
    }
}
