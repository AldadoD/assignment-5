package com.aldado.controller.people;

import com.aldado.domain.ResponseObj;
import com.aldado.domain.people.Busdriver;
import com.aldado.factory.ResponseObjFactory;
import com.aldado.factory.people.BusdriverFactory;
import com.aldado.service.people.impl.BusdriverServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;


@RestController
    @RequestMapping("/busdriver")

    public class BusdriverController {

        @Autowired
        BusdriverServiceImpl busdriverService;

        @PostMapping(value = "/create/{busdriver}", produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity createBusdriver(@PathVariable String busdriver) {
            System.out.println("Entered Value: " + busdriver);
            ResponseObj responseObj = ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Busdriver created!");
            Busdriver savedBusdriver;
            if (busdriver == null || busdriver.trim().isEmpty() || busdriver.trim().equalsIgnoreCase("null")) {
                responseObj.setResponseCode(HttpStatus.PRECONDITION_FAILED.toString());
                responseObj.setResponseDescription("Provide a busdriver!");
            } else {
                savedBusdriver = busdriverService.retrieveByDesc(busdriver);
                if (savedBusdriver != null) {
                    responseObj.setResponseDescription("Busdriver already exist!");
                } else {
                    savedBusdriver = BusdriverFactory.buildDriver("", "", "");
                    savedBusdriver = busdriverService.create("", savedBusdriver);
                }
                responseObj.setResponse(savedBusdriver);
            }
            return ResponseEntity.ok(responseObj);
        }

        @GetMapping(value = "/getall", produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity getAll(){
            ResponseObj responseObj = ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Success");
            Set<Busdriver> busdrivers = (Set<Busdriver>) busdriverService.getAll();
            responseObj.setResponse(busdrivers);
            return ResponseEntity.ok(responseObj);
        }
    }

//    public class BusdriverController {
//        @Autowired
//        @Qualifier("BusDriverServeImpl")
//        private BusdriverService service;
//
//        @PostMapping("/create")
//        @ResponseBody
//        public Busdriver create(String s, Busdriver busdriver) {
//            return this.service.create(s, busdriver);
//        }
//
//        @PostMapping("/update")
//        @ResponseBody
//        public Busdriver update(String s, Busdriver busdriver) {
//            return this.service.update(s, busdriver);
//        }
//
//        @PostMapping("/delete/id")
//        @ResponseBody
//        public Busdriver delete(String id) {
//            return this.service.delete(id);
//        }
//
//        @PostMapping("/read/id")
//        @ResponseBody
//        public Busdriver read(String id) {
//            return this.service.read(id);
//        }
//
//        @PostMapping("/read/all")
//        @ResponseBody
//        public Collection<Busdriver> getAll() {
//            return this.service.getAll();
//        }
//
//
//    }
