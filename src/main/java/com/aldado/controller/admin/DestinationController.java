package com.aldado.controller.admin;

import com.aldado.domain.admin.Destination;
import com.aldado.service.admin.DestinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/destination")
public class DestinationController {
    @Autowired
    //@Qualifier("DestinationServiceImpl")
    private DestinationService service;

    @PostMapping("/create")
    @ResponseBody
    public Destination create(String s, Destination destination) {
        return this.service.create(s, destination);
    }

    @PostMapping("/update")
    @ResponseBody
    public Destination update(String s, Destination destination) {
        return this.service.update(s, destination);
    }

    @PostMapping("/delete/id")
    @ResponseBody
    public Destination delete(String id) {
        return this.service.delete(id);
    }

    @PostMapping("/read/id")
    @ResponseBody
    public Destination read(String id) {
        return this.service.read(id);
    }

    @PostMapping("/read/all")
    @ResponseBody
    public Collection<Destination> getAll() {
        return this.service.getAll();
    }


}
