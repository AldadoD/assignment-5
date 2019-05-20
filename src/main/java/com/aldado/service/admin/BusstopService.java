package com.aldado.service.admin;

import com.aldado.domain.admin.Busstop;
import com.aldado.service.AService;

import java.util.Collection;

public interface BusstopService extends AService<String, Busstop> {

        Collection<Busstop> getAll();
        }
