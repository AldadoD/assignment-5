package com.aldado.domain.admin;

import java.util.Objects;
import java.util.Set;

public class Bus {

    private String id;
    private boolean serviceDue;
    private Set<Routes> route;

    private Bus(){

    }
    private Bus(Builder builder){
        this.id = builder.id;
        this.serviceDue = builder.serviceDue;

    }

    public String getId() {
        return id;
    }

    public boolean getServiceDue() {
        return serviceDue;
    }
    public static class Builder {

        private String id;
        private boolean serviceDue;
        private Set<Routes> route;



        public Builder id( String id) {
            this.id = id;
            return this;
        }

        public Builder serviceDue(boolean serviceDue) {
            this.serviceDue = serviceDue;
            return this;
        }
        public Builder copy(Bus bus) {
            this.id = bus.id;
            this.serviceDue = bus.serviceDue;


            return this;
        }

        public Bus build(){
            return new Bus(this);
        }


    }

    @Override
    public String toString() {
        return "Bus{" + "Id = '" + id + '\'' + ", Service is due = " + serviceDue + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bus bus = (Bus) o;
        return id.equals(bus.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}