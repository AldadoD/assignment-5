package com.aldado.factory.people;

import com.aldado.domain.people.Name;

public class NameFactory {

    public static Name getName(String firstName, String lastName) {
        return new Name.Builder().firstName(firstName).lastName(lastName).build();
    }
}
