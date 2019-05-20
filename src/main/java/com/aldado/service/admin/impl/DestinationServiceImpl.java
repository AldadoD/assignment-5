package com.aldado.service.admin.impl;

import com.aldado.domain.admin.Destination;
import com.aldado.repository.admin.DestinationRepository;
import com.aldado.repository.admin.impl.DestinationRepositoryImpl;
import com.aldado.service.admin.DestinationService;

import java.util.Collection;

public class DestinationServiceImpl implements DestinationService {


    private static DestinationServiceImpl service = null;
    private DestinationRepository repository;

    private DestinationServiceImpl(){
        this.repository = DestinationRepositoryImpl.getRepository();
    }
    public static DestinationServiceImpl getService(){
        if (service == null) service = new DestinationServiceImpl();
        return service;
    }
    @Override
    public Destination create(String s, Destination destination) {
        return this.repository.create(s, destination);
    }

    @Override
    public Destination update(String s, Destination destination) {
        return this.repository.update(s, destination);
    }

    @Override
    public Destination delete(String id) {
        return this.repository.delete(id);
    }

    @Override
    public Destination read(String id) {
        return this.repository.delete(id);
    }

    @Override
    public Collection<Destination> getAll() {
        return this.repository.getAll();
    }

}
