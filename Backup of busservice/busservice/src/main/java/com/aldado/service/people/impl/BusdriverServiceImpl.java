package com.aldado.service.people.impl;

import com.aldado.domain.people.Busdriver;
import com.aldado.repository.people.BusdriverRepository;
import com.aldado.repository.people.impl.BusdriverRepositoryImpl;
import com.aldado.service.people.BusdriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service("BusDriverServeImpl")
public class BusdriverServiceImpl implements BusdriverService {

    @Autowired
    @Qualifier("InMemory1")

    private static BusdriverServiceImpl service = null;
    private BusdriverRepository repository;

    private BusdriverServiceImpl(){
        this.repository = BusdriverRepositoryImpl.getRepository();
    }
    public static BusdriverServiceImpl getService(){
        if (service == null) service = new BusdriverServiceImpl();
        return service;
    }

    @Override
    public Busdriver create(String s, Busdriver busdriver) {
        return this.repository.create(s, busdriver);
    }

    @Override
    public Busdriver update(String s, Busdriver busdriver) {
        return this.repository.update(s, busdriver);
    }

    @Override
    public Busdriver delete(String id) {
        return this.repository.delete(id);
    }

    @Override
    public Busdriver read(String id) {
        return this.repository.read(id);
    }

    @Override
    public Collection<Busdriver> getAll() {
        return this.repository.getAll();
    }
}
