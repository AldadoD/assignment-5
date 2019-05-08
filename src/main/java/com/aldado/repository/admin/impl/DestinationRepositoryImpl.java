package com.aldado.repository.admin.impl;

import com.aldado.domain.admin.Destination;
import com.aldado.repository.admin.DestinationRepository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class DestinationRepositoryImpl implements DestinationRepository {

    private static DestinationRepository repository = null;
    private Map<String, Destination> map = new HashMap<>();

    public static DestinationRepository getRepository(){
        if(repository == null) repository = new DestinationRepositoryImpl();
        return repository;

    }

    @Override
    public Collection<Destination> getAll() {
        return map.values();
    }

    @Override
    public Destination create(String s, Destination destination) {
        map.put(s, destination);
        return destination;
    }

    @Override
    public Destination update(String s, Destination destination) {
        map.remove(s);
        map.put(s, destination);
        return destination;
    }

    @Override
    public Destination delete(String s) {
        return map.remove(s);
    }

    @Override
    public Destination read(String id) {
        return map.get(id);
    }
}
