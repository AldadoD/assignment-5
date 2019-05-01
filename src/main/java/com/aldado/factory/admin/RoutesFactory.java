package com.aldado.factory.admin;

import com.aldado.domain.admin.Routes;
import com.aldado.util.Misc;

public class RoutesFactory {

    public static Routes getRoutes(String routeName) {
        return new Routes.Builder().routeId(Misc.generateId()).routeName(routeName).build();
    }
}
