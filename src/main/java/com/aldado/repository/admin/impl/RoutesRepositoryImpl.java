package com.aldado.repository.admin.impl;

import com.aldado.domain.admin.Routes;
import com.aldado.repository.admin.RoutesRepository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class RoutesRepositoryImpl implements RoutesRepository {

    private static RoutesRepository repository = null;
    private Map<String, Routes> map = new HashMap<>();

    public static RoutesRepository getRepository(){
        if(repository == null) repository = new RoutesRepositoryImpl();
        return repository;

    }

    @Override
    public Collection<Routes> getAll() {
        return map.values();
    }

    @Override
    public Routes create(String s, Routes routes) {
        map.put(s, routes);
        return routes;
    }

    @Override
    public Routes update(String s, Routes routes) {
        map.remove(s);
        map.put(s, routes);
        return routes;
    }

    @Override
    public Routes delete(String id) {
        return map.remove(id);
    }

    @Override
    public Routes read(String id) {
        return map.get(id);
    }
}
