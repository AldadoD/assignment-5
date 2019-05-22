package com.aldado.repository.admin;

import com.aldado.domain.admin.Tickets;
import com.aldado.repository.ARepository;

import java.util.Collection;

public interface TicketsRepository extends ARepository<String, Tickets> {

    Collection<Tickets> getAll();
}
