package com.aldado.repository.people;

import com.aldado.domain.people.Name;
import com.aldado.repository.ARepository;

import java.util.Collection;

public interface NameRepository extends ARepository<String, Name> {

    Collection<Name> getAll();
}
