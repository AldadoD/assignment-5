package com.aldado.service.admin;

import com.aldado.domain.admin.Destination;
import com.aldado.service.AService;

import java.util.Collection;

public interface DestinationService extends AService<String, Destination> {

    Collection<Destination> getAll();
}
