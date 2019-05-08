package com.aldado.repository.admin;

import com.aldado.domain.admin.Routes;
import com.aldado.repository.ARepository;

import java.util.Collection;

public interface RoutesRepository extends ARepository<String, Routes> {

    Collection<Routes> getAll();
}
