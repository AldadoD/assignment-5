package com.aldado.factory;

import com.aldado.domain.Inspector;
import com.aldado.util.Misc;


public class InspectorFactory {

    public static Inspector getInspector(String firstName, String lastName,String id, boolean validTicket) {
        return new Inspector.Builder().inspectorFirstName(firstName).inspectorLastName(lastName).id(Misc.generateId()).validTicket(validTicket).build();
    }
}
