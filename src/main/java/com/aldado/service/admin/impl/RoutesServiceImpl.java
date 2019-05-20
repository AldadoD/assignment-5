package com.aldado.service.admin.impl;

import com.aldado.domain.admin.Routes;
import com.aldado.repository.admin.RoutesRepository;
import com.aldado.repository.admin.impl.RoutesRepositoryImpl;
import com.aldado.service.admin.RoutesService;

import java.util.Collection;

public class RoutesServiceImpl implements RoutesService {


    private static RoutesServiceImpl service = null;
    private RoutesRepository repository;

    private RoutesServiceImpl(){
        this.repository = RoutesRepositoryImpl.getRepository();
    }
    public static RoutesServiceImpl getService(){
        if (service == null) service = new RoutesServiceImpl();
        return service;
    }
    @Override
    public Routes create(String s, Routes routes) {
        return this.repository.create(s, routes);
    }

    @Override
    public Routes update(String s, Routes routes) {
        return this.repository.update(s, routes);
    }

    @Override
    public Routes delete(String id) {
        return this.repository.delete(id);
    }

    @Override
    public Routes read(String id) {
        return this.repository.read(id);
    }

    @Override
    public Collection<Routes> getAll() {
        return this.repository.getAll();
    }

}
