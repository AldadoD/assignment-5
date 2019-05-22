package com.aldado.repository.people;

import com.aldado.domain.people.Inspector;
import com.aldado.repository.ARepository;

import java.util.Collection;

public interface InspectorRepository extends ARepository<String, Inspector> {

    Collection<Inspector> getAll();
}
