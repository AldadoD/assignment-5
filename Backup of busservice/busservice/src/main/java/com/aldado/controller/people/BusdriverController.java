package com.aldado.controller.people;

import com.aldado.domain.people.Busdriver;
import com.aldado.service.people.BusdriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;


    @RestController
    @RequestMapping("/busdriver")
    public class BusdriverController {
        @Autowired
        @Qualifier("BusDriverServeImpl")
        private BusdriverService service;

        @PostMapping("/create")
        @ResponseBody
        public Busdriver create(String s, Busdriver busdriver) {
            return this.service.create(s, busdriver);
        }

        @PostMapping("/update")
        @ResponseBody
        public Busdriver update(String s, Busdriver busdriver) {
            return this.service.update(s, busdriver);
        }

        @PostMapping("/delete/id")
        @ResponseBody
        public Busdriver delete(String id) {
            return this.service.delete(id);
        }

        @PostMapping("/read/id")
        @ResponseBody
        public Busdriver read(String id) {
            return this.service.read(id);
        }

        @PostMapping("/read/all")
        @ResponseBody
        public Collection<Busdriver> getAll() {
            return this.service.getAll();
        }


    }
