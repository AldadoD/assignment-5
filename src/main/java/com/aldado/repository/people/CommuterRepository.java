package com.aldado.repository.people;

import com.aldado.domain.people.Commuter;
import com.aldado.repository.ARepository;

import java.util.Collection;

public interface CommuterRepository extends ARepository<String, Commuter> {

    Collection<Commuter> getAll();
}
