package com.aldado.repository.admin;

import com.aldado.domain.admin.Busstop;
import com.aldado.repository.ARepository;

import java.util.Collection;

public interface BusstopRepository extends ARepository<String, Busstop> {

    Collection<Busstop> getAll();
}
