package com.aldado.repository.people.impl;

import com.aldado.domain.people.Commuter;
import com.aldado.repository.people.CommuterRepository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CommuterRepositoryImpl implements CommuterRepository {

    private static CommuterRepository repository = null;
    private Map<String, Commuter> map = new HashMap<>();

    public static CommuterRepository getRepository(){
        if (repository == null) repository = new CommuterRepositoryImpl();
        return repository;
    }

    @Override
    public Collection<Commuter> getAll() {
        return map.values();
    }

    @Override
    public Commuter create(String s, Commuter commuter) {
        map.put(s,  commuter);

        return commuter;
    }

    @Override
    public Commuter update(String s, Commuter commuter) {
        map.remove(s);
        map.put(s,  commuter);
        return commuter;
    }

    @Override
    public Commuter delete(String id) {
        if (map.containsKey(id)) {
            map.remove(id);
        }

        return map.remove(id);
    }

    @Override
    public Commuter read(String id) {
        return map.get(id);
    }
}
