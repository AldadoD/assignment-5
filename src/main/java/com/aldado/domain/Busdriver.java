package com.aldado.domain;

import java.util.Objects;
import java.util.Set;

public class Busdriver {

    private  String driverId, driverFirstName, driverLastName;
    private Set<Routes> route;

    private Busdriver(){//this is the line i should check

    }
    private Busdriver(Builder builder){
        this.driverId = builder.driverId;
        this.driverFirstName = builder.driverFirstName;
        this.driverLastName = builder.driverLastName;

    }

    public String getDriverId() {
        return driverId;
    }

    public String getDriverFirstName() {
        return driverFirstName;
    }

    public String getDriverLastName() {
        return driverLastName;
    }
//   @Override
//    public int compareTo(Busdriver o) {
//        return this.driverId.compareTo(o.driverId);
//    }


    public static class Builder {

        private String driverId, driverFirstName, driverLastName;

        private Set<Routes> route;

        public Builder driverId( String driverId) {
            this.driverId = driverId;
            return this;
        }

        public Builder driverFirstName( String driverFirstName) {
            this.driverFirstName = driverFirstName;
            return this;
        }

        public Builder driverLastName( String driverLastName) {
            this.driverLastName = driverLastName;
            return this;
        }

        public Builder copy(Busdriver busdriver) {
            this.driverId = busdriver.driverId;
            this.driverLastName = busdriver.driverLastName;
            this.driverFirstName = busdriver.driverFirstName;

            return this;
        }

        public Busdriver build(){
            return new Busdriver(this);
        }

        }
    @Override
    public String toString() {
        return "Driver{" + "Driver's Id = '" + driverId + '\'' + ", Driver's First Name = '" + driverFirstName + '\'' + ", Driver's Last Name = " + driverLastName + '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Busdriver busdriver = (Busdriver) o;
        return driverId.equals(busdriver.driverId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(driverId);
    }
}
