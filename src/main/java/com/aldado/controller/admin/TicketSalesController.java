package com.aldado.controller.admin;

import com.aldado.domain.admin.TicketSales;
import com.aldado.service.admin.TicketSalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/ticketSales")
public class TicketSalesController {
    @Autowired
    //@Qualifier("TicketSalesServiceImpl")
    private TicketSalesService service;

    @PostMapping("/create")
    @ResponseBody
    public TicketSales create(String s, TicketSales ticketSales) {
        return this.service.create(s, ticketSales);
    }

    @PostMapping("/update")
    @ResponseBody
    public TicketSales update(String s, TicketSales ticketSales) {
        return this.service.update(s, ticketSales);
    }

    @PostMapping("/delete/id")
    @ResponseBody
    public TicketSales delete(String id) {
        return this.service.delete(id);
    }

    @PostMapping("/read/id")
    @ResponseBody
    public TicketSales read(String id) {
        return this.service.read(id);
    }

    @PostMapping("/read/all")
    @ResponseBody
    public Collection<TicketSales> getAll() {
        return this.service.getAll();
    }


}

