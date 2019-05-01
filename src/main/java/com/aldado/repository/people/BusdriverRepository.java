package com.aldado.repository.people;

import com.aldado.domain.people.Busdriver;
import com.aldado.repository.ARepository;

import java.util.Set;

public interface BusdriverRepository extends ARepository<Busdriver, String> {

     Set<Busdriver> getAll();

}