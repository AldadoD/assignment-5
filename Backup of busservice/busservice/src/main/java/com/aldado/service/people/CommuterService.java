package com.aldado.service.people;

import com.aldado.domain.people.Commuter;
import com.aldado.service.AService;

import java.util.Collection;

public interface CommuterService extends AService<String, Commuter> {

        Collection<Commuter> getAll();
        }
