package com.aldado.repository.people.impl;

import com.aldado.domain.people.Name;
import com.aldado.repository.people.NameRepository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class NameRepositoryImpl implements NameRepository {

    private static NameRepository repository = null;
    private Map<String, Name> map = new HashMap<>();

    public static NameRepository getRepository(){
        if (repository == null) repository = new NameRepositoryImpl();
        return repository;
    }

    @Override
    public Collection<Name> getAll() {
        return map.values();
    }

    @Override
    public Name create(String s, Name name) {
        map.put(s,  name);

        return name;
    }

    @Override
    public Name update(String s, Name name) {
        map.remove(s);
        map.put(s,  name);
        return name;
    }

    @Override
    public Name delete(String id) {
        if (map.containsKey(id)) {
            map.remove(id);
        }

        return map.remove(id);
    }

    @Override
    public Name read(String id) {
        return map.get(id);
    }
}
