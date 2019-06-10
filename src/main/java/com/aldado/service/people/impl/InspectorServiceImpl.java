package com.aldado.service.people.impl;

import com.aldado.domain.people.Inspector;
import com.aldado.repository.people.InspectorRepository;
import com.aldado.repository.people.impl.InspectorRepositoryImpl;
import com.aldado.service.people.InspectorService;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service("InspectorServiceImpl")
public class InspectorServiceImpl implements InspectorService {

//    @Autowired
    private static InspectorServiceImpl service = null;
    private InspectorRepository repository;

    private InspectorServiceImpl(){
        this.repository = InspectorRepositoryImpl.getRepository();
    }
    public static InspectorServiceImpl getService(){
        if (service == null) service = new InspectorServiceImpl();
        return service;
    }

    @Override
    public Inspector create(String s, Inspector inspector) {
        return this.repository.create(s, inspector);
    }

    @Override
    public Inspector update(String s, Inspector inspector) {
        return this.repository.update(s, inspector);
    }

    @Override
    public Inspector delete(String id) {
        return this.repository.delete(id);
    }

    @Override
    public Inspector read(String id) {
        return this.repository.read(id);
    }

    @Override
    public Collection<Inspector> getAll() {
        return this.repository.getAll();
    }
}
