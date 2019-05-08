package com.aldado.repository.admin.impl;

import com.aldado.domain.admin.Bus;
import com.aldado.repository.admin.BusRepository;

import java.util.*;

public class BusRepositoryImpl implements BusRepository {

    private static BusRepository repository = null;
    private Map<String, Bus> map = new HashMap();

    public static BusRepository getRepository(){
        if (repository == null) repository = new BusRepositoryImpl();
        return repository;
    }


    @Override
    public Collection<Bus> getAll() {
        return map.values();
    }

    @Override
    public Bus create(String s, Bus bus) {
        map.put(s, bus);
        return bus;
    }

    @Override
    public Bus update(String s, Bus bus) {
        if (map.containsKey(s)) {
            map.remove(s);
        }

        map.put(s, bus);

        return bus;
    }

    @Override
    public Bus delete(String s) {
        return  map.remove(s);
    }

    @Override
    public Bus read(String id) {
        return map.get(id);
    }
}
