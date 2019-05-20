package com.aldado.service.admin;

import com.aldado.domain.admin.Tickets;
import com.aldado.service.AService;

import java.util.Collection;

public interface TicketsService extends AService<String, Tickets> {

    Collection<Tickets> getAll();
}
