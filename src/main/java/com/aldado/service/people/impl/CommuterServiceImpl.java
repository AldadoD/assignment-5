package com.aldado.service.people.impl;

import com.aldado.domain.people.Commuter;
import com.aldado.repository.people.CommuterRepository;
import com.aldado.repository.people.impl.CommuterRepositoryImpl;
import com.aldado.service.people.CommuterService;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service("CommuterServiceImpl")
public class CommuterServiceImpl implements CommuterService {

//    @Autowired

    private static CommuterServiceImpl service = null;
    private CommuterRepository repository;

    private CommuterServiceImpl(){
        this.repository = CommuterRepositoryImpl.getRepository();
    }
    public static CommuterServiceImpl getService(){
        if (service == null) service = new CommuterServiceImpl();
        return service;
    }


    @Override
    public Commuter create(String s, Commuter commuter) {
        return this.repository.create(s, commuter);
    }

    @Override
    public Commuter update(String s, Commuter commuter) {
        return this.repository.update(s, commuter);
    }

    @Override
    public Commuter delete(String id) {
        return this.repository.delete(id);
    }

    @Override
    public Commuter read(String id) {
        return this.repository.read(id);
    }

    @Override
    public Collection<Commuter> getAll() {
        return this.repository.getAll();
    }
}
