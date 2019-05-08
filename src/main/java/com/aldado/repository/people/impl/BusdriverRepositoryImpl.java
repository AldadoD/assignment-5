package com.aldado.repository.people.impl;

import com.aldado.domain.people.Busdriver;
import com.aldado.repository.people.BusdriverRepository;

import java.util.*;

public class BusdriverRepositoryImpl implements BusdriverRepository {
    private static BusdriverRepository repository = null;
    private Map<String, Busdriver> map = new HashMap<>();

    public static BusdriverRepository getRepository(){
        if (repository == null) repository = new BusdriverRepositoryImpl();
        return repository;
    }

    @Override
    public Collection<Busdriver> getAll() {
        return map.values();
    }

    @Override
    public Busdriver create(String s, Busdriver busdriver) {
        map.put(s,  busdriver);

        return busdriver;
    }

    @Override
    public Busdriver update(String s, Busdriver busdriver) {
        map.remove(s);
        map.put(s,  busdriver);
        return busdriver;
    }

    @Override
    public Busdriver delete(String id) {
        if (map.containsKey(id)) {
            map.remove(id);
        }

        return map.remove(id);
    }

    @Override
    public Busdriver read(String id) {
        return map.get(id);
    }
}
