package com.aldado.repository.admin.impl;

import com.aldado.domain.admin.Bus;
import com.aldado.repository.admin.BusRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository

public class BusRepositoryImpl implements BusRepository {

    private static BusRepository busRepository;

    private Set<Bus> busDB;

    private BusRepositoryImpl() {
        this.busDB = new HashSet<>();
    }

    public static BusRepository getBusRepository() {
        if (busRepository == null) busRepository = new BusRepositoryImpl();
        return busRepository;
    }

    @Override
    public Bus create(String s, Bus bus) {
        this.busDB.add(bus);
        return bus;
    }

    @Override
    public Bus read(String s) {
        return this.busDB.stream().filter(bus -> bus.getId().equalsIgnoreCase(s)).findAny().orElse(null);
    }

    @Override
    public Bus update(String s, Bus bus) {
        Bus g = read(bus.getId());
        if (g != null) {
            delete(g.getId());
            return create(s, bus);
        }
        return null;
    }

    @Override
    public Bus delete(String s) {
        Bus bus = read(s);
        this.busDB.remove(bus);
        return bus;
    }

    @Override
    public Bus retrieveByDesc(String busDesc) {
        return this.busDB.stream().filter(bus -> bus.getDesc().equalsIgnoreCase(busDesc)).findAny().orElse(null);
    }

    @Override
    public Set<Bus> getAll() {
        return this.busDB;
    }
}


//public class BusRepositoryImpl implements BusRepository {
//
//    private static BusRepositoryImpl repository = null;
//    private Map<String, Bus> map = new HashMap();
//
//    public static BusRepositoryImpl getRepository(){
//        if (repository == null) repository = new BusRepositoryImpl();
//        return repository;
//    }
//
//
//    @Override
//    public Bus retrieveByDesc(String busDesc) {
//        return this.busDB.stream().filter(bus -> bus.getDesc().equalsIgnoreCase(busDesc)).findAny().orElse(null);
//    }
//
//    @Override
//    public Collection<Bus> getAll() {
//        return map.values();
//    }
//
//    @Override
//    public Bus create(String s, Bus bus) {
//        map.put(s, bus);
//        return bus;
//    }
//
//    @Override
//    public Bus update(String s, Bus bus) {
//        if (map.containsKey(s)) {
//            map.remove(s);
//        }
//
//        map.put(s, bus);
//
//        return bus;
//    }
//
//    @Override
//    public Bus delete(String s) {
//        return  map.remove(s);
//    }
//
//    @Override
//    public Bus read(String id) {
//        return map.get(id);
//    }
//}
