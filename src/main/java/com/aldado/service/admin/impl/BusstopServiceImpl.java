package com.aldado.service.admin.impl;

import com.aldado.domain.admin.Busstop;
import com.aldado.repository.admin.BusstopRepository;
import com.aldado.repository.admin.impl.BusstopRepositoryImpl;
import com.aldado.service.admin.BusstopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service("BusstopServiceImpl")
public class BusstopServiceImpl implements BusstopService {

    @Autowired
    private static BusstopServiceImpl service = null;
    private BusstopRepository repository;

    private BusstopServiceImpl(){
        this.repository = BusstopRepositoryImpl.getRepository();
    }
    public static BusstopServiceImpl getService(){
        if (service == null) service = new BusstopServiceImpl();
        return service;
    }

    @Override
    public Busstop create(String s, Busstop busstop) {
        return this.repository.create(s, busstop);
    }

    @Override
    public Busstop update(String s, Busstop busstop) {
        return this.repository.update(s, busstop);
    }

    @Override
    public Busstop delete(String id) {
        return this.repository.delete(id);
    }

    @Override
    public Busstop read(String id) {
        return this.repository.read(id);
    }

    @Override
    public Collection<Busstop> getAll() {
        return this.repository.getAll();
    }

}
