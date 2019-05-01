package com.aldado.domain;

import java.util.Objects;

public class Commuter {

    private boolean hasTicket;

    private Commuter(){

    }
    private Commuter(Builder builder){
        this.hasTicket = builder.hasTicket;
    }

    private boolean getHasTicket(){
        return hasTicket;
    }

    public static class Builder{

        public boolean hasTicket;

        public Commuter.Builder hasTicket(boolean hasTicket) {
            this.hasTicket = hasTicket;
            return this;
        }

        public Commuter build(){
            return new Commuter(this);
        }
    }

    @Override
    public String toString() {
        return "Commuter{" + "has a valid ticket = " + hasTicket + '}';
    }
}
