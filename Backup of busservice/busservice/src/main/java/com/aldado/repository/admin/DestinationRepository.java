package com.aldado.repository.admin;

import com.aldado.domain.admin.Destination;
import com.aldado.repository.ARepository;

import java.util.Collection;

public interface DestinationRepository extends ARepository<String, Destination> {

    Collection<Destination> getAll();
}
