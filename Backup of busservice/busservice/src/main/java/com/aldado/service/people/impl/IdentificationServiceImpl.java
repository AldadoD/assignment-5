package com.aldado.service.people.impl;

import com.aldado.domain.people.Identification;
import com.aldado.repository.people.IdentificationRepository;
import com.aldado.repository.people.impl.IdentificationRepositoryImpl;
import com.aldado.service.people.IdentificationService;

import java.util.Collection;

public class IdentificationServiceImpl implements IdentificationService {

    private static IdentificationServiceImpl service = null;
    private IdentificationRepository repository;

    private IdentificationServiceImpl(){
        this.repository = IdentificationRepositoryImpl.getRepository();
    }
    public static IdentificationServiceImpl getService(){
        if (service == null) service = new IdentificationServiceImpl();
        return service;
    }

    @Override
    public Identification create(String s, Identification identification) {
        return this.repository.create(s, identification);
    }

    @Override
    public Identification update(String s, Identification identification) {
        return this.repository.update(s, identification);
    }

    @Override
    public Identification delete(String id) {
        return this.repository.delete(id);
    }

    @Override
    public Identification read(String id) {
        return this.repository.read(id);
    }

    @Override
    public Collection<Identification> getAll() {
        return this.repository.getAll();
    }
}
