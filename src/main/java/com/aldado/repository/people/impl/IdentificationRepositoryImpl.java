package com.aldado.repository.people.impl;

import com.aldado.domain.people.Identification;
import com.aldado.repository.people.IdentificationRepository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class IdentificationRepositoryImpl implements IdentificationRepository {

    private static IdentificationRepository repository = null;
    private Map<String, Identification> map = new HashMap<>();

    public static IdentificationRepository getRepository(){
        if(repository == null) repository = new IdentificationRepositoryImpl();
        return repository;

    }

    @Override
    public Collection<Identification> getAll() {
        return map.values();
    }

    @Override
    public Identification create(String s, Identification identification) {
        map.put(s, identification);
        return identification;
    }

    @Override
    public Identification update(String s, Identification identification) {
        map.remove(s);
        map.put(s, identification);
        return identification;
    }

    @Override
    public Identification delete(String s) {
        return map.remove(s);
    }

    @Override
    public Identification read(String id) {
        return map.get(id);
    }
}
