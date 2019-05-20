package com.aldado.repository.admin.impl;

import com.aldado.domain.admin.Busstop;
import com.aldado.repository.admin.BusstopRepository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class BusstopRepositoryImpl implements BusstopRepository {

    private static BusstopRepositoryImpl repository = null;
    private Map<String, Busstop> map = new HashMap<>();

    public static BusstopRepositoryImpl getRepository(){
        if (repository == null) repository = new BusstopRepositoryImpl();
        return repository;
    }
    @Override
    public Collection<Busstop> getAll() {
        return map.values();
    }

    @Override
    public Busstop create(String s, Busstop busstop) {
        map.put(s, busstop);
        return busstop;
    }

    @Override
    public Busstop update(String s, Busstop busstop) {
            map.remove(s);
            map.put(s, busstop);
            return busstop;
    }

    @Override
    public Busstop delete(String id) {
        return map.remove(id);
    }

    @Override
    public Busstop read(String id) {
        return map.get(id);
    }
}
