package com.aldado.service.admin;

import com.aldado.domain.admin.Bus;
import com.aldado.service.AService;

import java.util.Collection;

public interface BusService extends AService<String, Bus> {

    Collection<Bus> getAll();

    Bus retrieveByDesc(String busDesc);
}
