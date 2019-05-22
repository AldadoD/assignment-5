package com.aldado.service.admin;

import com.aldado.domain.admin.Routes;
import com.aldado.service.AService;

import java.util.Collection;

public interface RoutesService extends AService<String, Routes> {

    Collection<Routes> getAll();
}
