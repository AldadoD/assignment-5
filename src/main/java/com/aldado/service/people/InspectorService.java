package com.aldado.service.people;

import com.aldado.domain.people.Inspector;
import com.aldado.service.AService;

import java.util.Collection;

public interface InspectorService extends AService<String, Inspector> {

    Collection<Inspector> getAll();
}