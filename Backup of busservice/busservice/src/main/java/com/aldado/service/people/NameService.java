package com.aldado.service.people;

import com.aldado.domain.people.Name;
import com.aldado.service.AService;

import java.util.Collection;

public interface NameService extends AService<String, Name> {

    Collection<Name> getAll();
}
