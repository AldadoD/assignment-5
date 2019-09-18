package com.aldado.repository.admin;

import com.aldado.domain.admin.Bus;
import com.aldado.repository.ARepository;

import java.util.Collection;

public interface BusRepository extends ARepository<String, Bus> {



        Collection<Bus> getAll();

        Bus retrieveByDesc(String busDesc);
}
