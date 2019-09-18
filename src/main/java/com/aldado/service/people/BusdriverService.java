package com.aldado.service.people;

import com.aldado.domain.people.Busdriver;
import com.aldado.service.AService;

import java.util.Collection;

public interface BusdriverService extends AService<String, Busdriver> {

        Collection<Busdriver> getAll();
        Busdriver retrieveByDesc(String busDesc);

        }
