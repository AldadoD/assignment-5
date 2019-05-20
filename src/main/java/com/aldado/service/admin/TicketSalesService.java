package com.aldado.service.admin;

import com.aldado.domain.admin.TicketSales;
import com.aldado.service.AService;

import java.util.Collection;

public interface TicketSalesService extends AService<String, TicketSales> {

    Collection<TicketSales> getAll();
}
