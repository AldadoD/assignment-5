package com.aldado.domain.people;

public class Commuter {

    private String commuterId;
    private boolean hasTicket;

    private Commuter(){

    }
    private Commuter(Builder builder){
        this.hasTicket = builder.hasTicket;
        this.commuterId = builder.commuterId;
    }

    public boolean getHasTicket(){
        return hasTicket;
    }
    public String getCommuterId(){
        return  commuterId;
    }

    public static class Builder{

        public String commuterId;
        public boolean hasTicket;


        public Builder hasTicket(boolean hasTicket) {
            this.hasTicket = hasTicket;
            return this;
        }
        public Builder commuterId(String commuterId) {
            this.commuterId = commuterId;
            return this;
        }
        public Builder copy(Commuter commuter) {
            this.commuterId = commuter.commuterId;
            this.hasTicket = commuter.hasTicket;


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
