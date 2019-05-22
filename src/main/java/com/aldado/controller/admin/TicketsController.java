package com.aldado.controller.admin;

import com.aldado.domain.admin.Tickets;
import com.aldado.service.admin.TicketsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/tickets")
public class TicketsController {
    @Autowired
    //@Qualifier("TicketsServiceImpl")
    private TicketsService service;

    @PostMapping("/create")
    @ResponseBody
    public Tickets create(String s, Tickets tickets) {
        return this.service.create(s, tickets);
    }

    @PostMapping("/update")
    @ResponseBody
    public Tickets update(String s, Tickets tickets) {
        return this.service.update(s, tickets);
    }

    @PostMapping("/delete/id")
    @ResponseBody
    public Tickets delete(String id) {
        return this.service.delete(id);
    }

    @PostMapping("/read/id")
    @ResponseBody
    public Tickets read(String id) {
        return this.service.read(id);
    }

    @PostMapping("/read/all")
    @ResponseBody
    public Collection<Tickets> getAll() {
        return this.service.getAll();
    }


}
