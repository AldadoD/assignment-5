package com.aldado.repository.admin.impl;

import com.aldado.domain.admin.Tickets;
import com.aldado.repository.admin.TicketsRepository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class TicketsRepositoryImpl implements TicketsRepository{

    private static TicketsRepositoryImpl repository = null;
    private Map<String, Tickets> map = new HashMap<>();

    public static TicketsRepositoryImpl getRepository(){
        if (repository == null) repository = new TicketsRepositoryImpl();
        return repository;
    }
    @Override
    public Collection<Tickets> getAll() {
        return map.values();
    }

    @Override
    public Tickets create(String s, Tickets tickets) {
        map.put(s, tickets);
        return tickets;
    }

    @Override
    public Tickets update(String s, Tickets tickets) {
        map.remove(s);
        map.put(s, tickets);
        return tickets;
    }

    @Override
    public Tickets delete(String id) {
        return map.remove(id);
    }

    @Override
    public Tickets read(String id) {
        return map.get(id);
    }

}
