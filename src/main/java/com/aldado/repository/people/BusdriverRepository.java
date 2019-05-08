package com.aldado.repository.people;

import com.aldado.domain.people.Busdriver;
import com.aldado.repository.ARepository;

import java.util.Collection;

public interface BusdriverRepository extends ARepository<String, Busdriver> {

     Collection<Busdriver> getAll();

}