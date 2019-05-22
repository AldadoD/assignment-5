package com.aldado.controller.admin;

import com.aldado.domain.admin.Routes;
import com.aldado.service.admin.RoutesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/routes")
public class RoutesController {
    @Autowired
    //@Qualifier("RoutesServiceImpl")
    private RoutesService service;

    @PostMapping("/create")
    @ResponseBody
    public Routes create(String s, Routes routes) {
        return this.service.create(s, routes);
    }

    @PostMapping("/update")
    @ResponseBody
    public Routes update(String s, Routes routes) {
        return this.service.update(s, routes);
    }

    @PostMapping("/delete/id")
    @ResponseBody
    public Routes delete(String id) {
        return this.service.delete(id);
    }

    @PostMapping("/read/id")
    @ResponseBody
    public Routes read(String id) {
        return this.service.read(id);
    }

    @PostMapping("/read/all")
    @ResponseBody
    public Collection<Routes> getAll() {
        return this.service.getAll();
    }


}
