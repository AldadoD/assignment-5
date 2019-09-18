package com.aldado.controller.admin;

import com.aldado.domain.ResponseObj;
import com.aldado.domain.admin.Bus;
import com.aldado.factory.ResponseObjFactory;
import com.aldado.factory.admin.BusFactory;
import com.aldado.service.admin.impl.BusServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/bus")

public class BusController {

    @Autowired
    BusServiceImpl busService;

    @PostMapping(value = "/create/{bus}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createBus(@PathVariable String bus) {
        System.out.println("Entered Value: " + bus);
        ResponseObj responseObj = ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Bus created!");
        Bus savedBus;
        if (bus == null || bus.trim().isEmpty() || bus.trim().equalsIgnoreCase("null")) {
            responseObj.setResponseCode(HttpStatus.PRECONDITION_FAILED.toString());
            responseObj.setResponseDescription("Provide a bus!");
        } else {
            savedBus = busService.retrieveByDesc(bus);
            if (savedBus != null) {
                responseObj.setResponseDescription("Bus already exist!");
            } else {
                savedBus = BusFactory.getBus("", true);
                savedBus = busService.create("", savedBus);
            }
            responseObj.setResponse(savedBus);
        }
        return ResponseEntity.ok(responseObj);
    }

    @GetMapping(value = "/getall", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAll(){
        ResponseObj responseObj = ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Success");
        Set<Bus> buss = (Set<Bus>) busService.getAll();
        responseObj.setResponse(buss);
        return ResponseEntity.ok(responseObj);
    }
}


//public class BusController {
//    @Autowired
//    //@Qualifier("BusServiceImpl")
//    private BusService service;
//
//    @PostMapping("/create")
//    @ResponseBody
//    public Bus create(String s, Bus bus) {
//        return this.service.create(s, bus);
//    }
//
//    @PostMapping("/update")
//    @ResponseBody
//    public Bus update(String s, Bus bus) {
//        return this.service.update(s, bus);
//    }
//
//    @PostMapping("/delete/id")
//    @ResponseBody
//    public Bus delete(String id) {
//        return this.service.delete(id);
//    }
//
//    @PostMapping("/read/id")
//    @ResponseBody
//    public Bus read(String id) {
//        return this.service.read(id);
//    }
//
//    @PostMapping("/read/all")
//    @ResponseBody
//    public Collection<Bus> getAll() {
//        return this.service.getAll();
//    }
//
//
//}
