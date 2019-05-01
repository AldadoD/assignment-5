package com.aldado.repository.admin.impl;

import com.aldado.domain.admin.Bus;
import com.aldado.repository.admin.BusRepository;

import java.util.HashSet;
import java.util.Set;

public class BusRepositoryImpl implements BusRepository {

    private static BusRepository repository = null;
    private Set<Bus> bus;

    private BusRepositoryImpl() {
        this.bus = new HashSet<>();
    }

    public static BusRepository getRepository(){
        if (repository == null) repository = new BusRepositoryImpl();
        return repository;
    }



    @Override
    public Bus create(Bus bus) {
        this.bus.add(bus);
        return bus;
    }

    @Override
    public Bus update(Bus bus) {
        return null;
    }

    @Override
    public void delete(String s) {
        this.bus.remove(bus);
    }

    @Override
    public Bus read(String s) {
        return null;
    }
    @Override
    public Set<Bus> getAll() {
        return this.bus;
    }

}
