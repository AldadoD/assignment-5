package com.aldado.controller.people;

import com.aldado.domain.people.Commuter;
import com.aldado.service.people.CommuterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/commuter")
public class CommuterController {
    @Autowired
    //@Qualifier("CommuterServiceImpl")
    private CommuterService service;

    @PostMapping("/create")
    @ResponseBody
    public Commuter create(String s, Commuter commuter) {
        return this.service.create(s, commuter);
    }

    @PostMapping("/update")
    @ResponseBody
    public Commuter update(String s, Commuter commuter) {
        return this.service.update(s, commuter);
    }

    @PostMapping("/delete/id")
    @ResponseBody
    public Commuter delete(String id) {
        return this.service.delete(id);
    }

    @PostMapping("/read/id")
    @ResponseBody
    public Commuter read(String id) {
        return this.service.read(id);
    }

    @PostMapping("/read/all")
    @ResponseBody
    public Collection<Commuter> getAll() {
        return this.service.getAll();
    }
}
