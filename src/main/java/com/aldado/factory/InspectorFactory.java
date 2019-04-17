package com.aldado.factory;

import com.aldado.domain.Inspector;


public class InspectorFactory {

    public static Inspector getInspector(String firstName, String lastName,String id, boolean validTicket) {
        return new Inspector.Builder().inspectorFirstName(firstName).inspectorLastName(lastName).id(id).validTicket(validTicket).build();
    }
}
