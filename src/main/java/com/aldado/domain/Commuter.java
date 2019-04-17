package com.aldado.domain;

public class Commuter {

    private boolean hasTicket;

    private Commuter(){

    }
    private Commuter(Builder builder){
        this.hasTicket = builder.hasTicket;
    }

    private boolean gethasTicket(){
        return hasTicket;
    }
    public static class Builder{

        private boolean hasTicket;

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
        return "Commuter{" + "hasTicket=" + hasTicket + '}';
    }
}
