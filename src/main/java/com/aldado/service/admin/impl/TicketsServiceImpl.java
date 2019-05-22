package com.aldado.service.admin.impl;

import com.aldado.domain.admin.Tickets;
import com.aldado.repository.admin.TicketsRepository;
import com.aldado.repository.admin.impl.TicketsRepositoryImpl;
import com.aldado.service.admin.TicketsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service("TicketsServiceImpl")
public class TicketsServiceImpl implements TicketsService {

    @Autowired
    private static TicketsServiceImpl service = null;
    private TicketsRepository repository;

    private TicketsServiceImpl(){
        this.repository = TicketsRepositoryImpl.getRepository();
    }
    public static TicketsServiceImpl getService(){
        if (service == null) service = new TicketsServiceImpl();
        return service;
    }

    @Override
    public Tickets create(String s, Tickets tickets) {
        return this.repository.create(s, tickets);
    }

    @Override
    public Tickets update(String s, Tickets tickets) {
        return this.repository.update(s, tickets);
    }

    @Override
    public Tickets delete(String id) {
        return this.repository.delete(id);
    }

    @Override
    public Tickets read(String id) {
        return this.repository.read(id);
    }

    @Override
    public Collection<Tickets> getAll() {
        return this.repository.getAll();
    }
}
