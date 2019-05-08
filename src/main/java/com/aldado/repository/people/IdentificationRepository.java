package com.aldado.repository.people;

import com.aldado.domain.people.Identification;
import com.aldado.repository.ARepository;

import java.util.Collection;

public interface IdentificationRepository extends ARepository<String, Identification> {

    Collection<Identification> getAll();
}
