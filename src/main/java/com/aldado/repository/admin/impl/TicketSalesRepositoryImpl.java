package com.aldado.repository.admin.impl;

import com.aldado.domain.admin.TicketSales;
import com.aldado.repository.admin.TicketSalesRepository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class TicketSalesRepositoryImpl implements TicketSalesRepository{

    private static TicketSalesRepositoryImpl repository = null;
    private Map<String, TicketSales> map = new HashMap<>();

    public static TicketSalesRepositoryImpl getRepository(){
        if (repository == null) repository = new TicketSalesRepositoryImpl();
        return repository;
    }
    @Override
    public Collection<TicketSales> getAll() {
        return map.values();
    }

    @Override
    public TicketSales create(String s, TicketSales ticketSales) {
        map.put(s, ticketSales);
        return ticketSales;
    }

    @Override
    public TicketSales update(String s, TicketSales ticketSales) {
        map.remove(s);
        map.put(s, ticketSales);
        return ticketSales;
    }

    @Override
    public TicketSales delete(String id) {
        return map.remove(id);
    }

    @Override
    public TicketSales read(String id) {
        return map.get(id);
    }

}
