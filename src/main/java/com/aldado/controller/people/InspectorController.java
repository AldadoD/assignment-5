package com.aldado.controller.people;

import com.aldado.domain.people.Inspector;
import com.aldado.service.people.InspectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/inspector")
public class InspectorController {
    @Autowired
    //@Qualifier("InspectorServiceImpl")
    private InspectorService service;

    @PostMapping("/create")
    @ResponseBody
    public Inspector create(String s, Inspector inspector) {
        return this.service.create(s, inspector);
    }

    @PostMapping("/update")
    @ResponseBody
    public Inspector update(String s, Inspector inspector) {
        return this.service.update(s, inspector);
    }

    @PostMapping("/delete/id")
    @ResponseBody
    public Inspector delete(String id) {
        return this.service.delete(id);
    }

    @PostMapping("/read/id")
    @ResponseBody
    public Inspector read(String id) {
        return this.service.read(id);
    }

    @PostMapping("/read/all")
    @ResponseBody
    public Collection<Inspector> getAll() {
        return this.service.getAll();
    }


}
