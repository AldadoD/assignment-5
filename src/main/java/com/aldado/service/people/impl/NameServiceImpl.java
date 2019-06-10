package com.aldado.service.people.impl;

import com.aldado.domain.people.Name;
import com.aldado.repository.people.NameRepository;
import com.aldado.repository.people.impl.NameRepositoryImpl;
import com.aldado.service.people.NameService;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service("NameServiceImpl")
public class NameServiceImpl implements NameService {

//    @Autowired
    private static NameServiceImpl service = null;
    private NameRepository repository;

    private NameServiceImpl(){
        this.repository = NameRepositoryImpl.getRepository();
    }
    public static NameServiceImpl getService(){
        if (service == null) service = new NameServiceImpl();
        return service;
    }

    @Override
    public Name create(String s, Name name) {
        return this.repository.create(s, name);
    }

    @Override
    public Name update(String s, Name name) {
        return this.repository.update(s, name);
    }

    @Override
    public Name delete(String id) {
        return this.repository.delete(id);
    }

    @Override
    public Name read(String id) {
        return this.repository.read(id);
    }

    @Override
    public Collection<Name> getAll() {
        return this.repository.getAll();
    }
}
