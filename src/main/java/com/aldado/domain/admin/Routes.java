package com.aldado.domain.admin;

public class Routes {

    private String routeId, routeName;

    private Routes(){

    }
    private Routes(Builder builder){
        this.routeId = builder.routeId;
        this.routeName = builder.routeName;
    }

    public String getRouteId() {
        return routeId;
    }

    public String getRouteName() {
        return routeName;
    }
    public static class Builder{

        private String routeId, routeName;

        public Builder routeId(String routeId) {
            this.routeId = routeId;
            return this;
        }

        public Builder routeName(String routeName) {
            this.routeName = routeName;
            return this;
        }
        public Builder copy(Routes routes) {
            this.routeId = routes.routeId;
            this.routeName = routes.routeName;


            return this;
        }
        public Routes build() {
            return new Routes(this);
        }

    }

    @Override
    public String toString() {
        return "Route{" + "Route Id = '" + routeId + '\'' + ", Route Name = '" + routeName + '\'' + '}';
    }
}
