package com.aldado.repository.people.impl;

import com.aldado.domain.people.Inspector;
import com.aldado.repository.people.InspectorRepository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class InspectorRepositoryImpl implements InspectorRepository {

    private static InspectorRepositoryImpl repository = null;
    private Map<String, Inspector> map = new HashMap<>();

    public static InspectorRepositoryImpl getRepository(){
        if (repository == null) repository = new InspectorRepositoryImpl();
        return repository;
    }

    @Override
    public Collection<Inspector> getAll() {
        return map.values();
    }

    @Override
    public Inspector create(String s, Inspector commuter) {
        map.put(s,  commuter);

        return commuter;
    }

    @Override
    public Inspector update(String s, Inspector inspector) {
        map.remove(s);
        map.put(s,  inspector);
        return inspector;
    }

    @Override
    public Inspector delete(String id) {
        if (map.containsKey(id)) {
            map.remove(id);
        }

        return map.remove(id);
    }

    @Override
    public Inspector read(String id) {
        return map.get(id);
    }
}
