package com.aldado.repository.admin;

import com.aldado.domain.admin.TicketSales;
import com.aldado.repository.ARepository;

import java.util.Collection;

public interface TicketSalesRepository extends ARepository<String, TicketSales> {

    Collection<TicketSales> getAll();
}
