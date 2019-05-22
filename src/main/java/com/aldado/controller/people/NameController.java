package com.aldado.controller.people;

import com.aldado.domain.people.Name;
import com.aldado.service.people.NameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/name")
public class NameController {
    @Autowired
    //@Qualifier("NameServiceImpl")
    private NameService service;

    @PostMapping("/create")
    @ResponseBody
    public Name create(String s, Name name) {
        return this.service.create(s, name);
    }

    @PostMapping("/update")
    @ResponseBody
    public Name update(String s, Name name) {
        return this.service.update(s, name);
    }

    @PostMapping("/delete/id")
    @ResponseBody
    public Name delete(String id) {
        return this.service.delete(id);
    }

    @PostMapping("/read/id")
    @ResponseBody
    public Name read(String id) {
        return this.service.read(id);
    }

    @PostMapping("/read/all")
    @ResponseBody
    public Collection<Name> getAll() {
        return this.service.getAll();
    }


}