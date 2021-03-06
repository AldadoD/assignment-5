package com.aldado.service.admin.impl;

import com.aldado.domain.admin.Bus;
import com.aldado.repository.admin.BusRepository;
//import com.aldado.repository.admin.impl.BusRepositoryImpl;
import com.aldado.repository.admin.impl.*;
import com.aldado.service.admin.BusService;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service("BusServiceImpl")
public class BusServiceImpl implements BusService {
//    @Autowired

    private static BusServiceImpl service = null;
    private BusRepository repository;

    private BusServiceImpl(){
        this.repository = BusRepositoryImpl.getBusRepository();
    }
    public static BusServiceImpl getService(){
        if (service == null) service = new BusServiceImpl();
        return service;
    }

    @Override
    public Bus create(String s, Bus bus) {
        return this.repository.create(s, bus);
    }

    @Override
    public Bus update(String s, Bus bus) {
        return this.repository.update(s, bus);
    }

    @Override
    public Bus delete(String id) {
        return this.repository.delete(id);
    }

    @Override
    public Bus read(String id) {
        return this.repository.read(id);
    }

    @Override
    public Bus retrieveByDesc(String busDesc) {
        return this.repository.retrieveByDesc(busDesc);
    }

    @Override
    public Collection<Bus> getAll() {
        return this.repository.getAll();
    }


}
