package com.aldado.factory;

import com.aldado.domain.Routes;
import com.aldado.util.Misc;

public class RoutesFactory {

    public static Routes getRoutes(String routeName) {
        return new Routes.Builder().routeId(Misc.generateId()).routeName(routeName).build();
    }
}
