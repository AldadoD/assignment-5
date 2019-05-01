package com.aldado.domain.admin;

public class TicketSales {

    private int ticketPrice;
    private String destination;

    private TicketSales(){

    }
    private TicketSales(Builder builder){
        this.ticketPrice = builder.ticketPrice;
        this.destination = builder.destination;
    }

    public int getTicketPrice(){
        return ticketPrice;
    }
    public static class Builder{
        public String destination;
        private int ticketPrice;

        public Builder tickePrice(int ticketPrice) {
            this.ticketPrice = ticketPrice;
            return this;
        }
        public Builder destination(String destination){
            this.destination = destination;
            return this;
        }
        public TicketSales build(){
            return new TicketSales(this);
        }
    }

    @Override
    public String toString() {
        return "Ticket Sales{" + "Ticket Price = " + ticketPrice + ", Destination = '" + destination + '\'' + '}';
    }
}
