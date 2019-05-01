package com.aldado.repository.people.impl;

import com.aldado.domain.Busdriver;
import com.aldado.repository.people.BusdriverRepository;

import java.util.HashSet;
import java.util.Set;

public class BusdriverRepositoryImpl implements BusdriverRepository {
    private static BusdriverRepository repository = null;
    private Set<Busdriver> busdriver;

    private BusdriverRepositoryImpl() {
        this.busdriver = new HashSet<>();
    }


    public static BusdriverRepository getRepository(){
        if (repository == null) repository = new BusdriverRepositoryImpl();
        return repository;
    }


    public Busdriver create(Busdriver busdriver) {
        this.busdriver.add(busdriver);
        return busdriver;
    }


    public void delete(String busdriver) {
        this.busdriver.remove(busdriver);
    }


    public Busdriver read(String driverId) {
        return null;
    }


    public Busdriver update(Busdriver busdriver) {
        // find the student, update it and return the updated student

        return null;
    }

    public Set<Busdriver> getAll() {
        return this.busdriver;
    }
}
