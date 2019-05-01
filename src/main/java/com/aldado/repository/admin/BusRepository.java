package com.aldado.repository.admin;

import com.aldado.domain.Bus;
import com.aldado.repository.ARepository;

import java.util.Set;

public interface BusRepository extends ARepository<Bus, String> {

        Set<Bus> getAll();
}
