package com.aldado.service.admin.impl;

import com.aldado.domain.admin.TicketSales;
import com.aldado.repository.admin.TicketSalesRepository;
import com.aldado.repository.admin.impl.TicketSalesRepositoryImpl;
import com.aldado.service.admin.TicketSalesService;

import java.util.Collection;

public class TicketSalesServiceImpl implements TicketSalesService {


    private static TicketSalesServiceImpl service = null;
    private TicketSalesRepository repository;

    private TicketSalesServiceImpl(){
        this.repository = TicketSalesRepositoryImpl.getRepository();
    }
    public static TicketSalesServiceImpl getService(){
        if (service == null) service = new TicketSalesServiceImpl();
        return service;
    }
    @Override
    public TicketSales create(String s, TicketSales ticketSales) {
        return this.repository.create(s, ticketSales);
    }

    @Override
    public TicketSales update(String s, TicketSales ticketSales) {
        return this.repository.update(s, ticketSales);
    }

    @Override
    public TicketSales delete(String id) {
        return this.repository.delete(id);
    }

    @Override
    public TicketSales read(String id) {
        return this.repository.read(id);
    }

    @Override
    public Collection<TicketSales> getAll() {
        return this.repository.getAll();
    }

}
