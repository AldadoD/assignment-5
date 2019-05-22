package com.aldado.service.people;

import com.aldado.domain.people.Identification;
import com.aldado.service.AService;

import java.util.Collection;

public interface IdentificationService extends AService<String, Identification> {

    Collection<Identification> getAll();
}


