package com.aldado.domain.admin;


import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class TicketSales {

    private String ticketPrice;
    private String destination;

    private TicketSales(){

    }
    private TicketSales(Builder builder){
        this.ticketPrice = builder.ticketPrice;
        this.destination = builder.destination;
    }

    public String getTicketPrice(){
        return ticketPrice;
    }
    public static class Builder{
        public String destination;
        private String ticketPrice;

        public Builder ticketPrice(String ticketPrice) {
            this.ticketPrice = ticketPrice;
            return this;
        }
        public Builder destination(String destination){
            this.destination = destination;
            return this;
        }
        public Builder copy(TicketSales ticketSales) {
            this.ticketPrice = ticketSales.ticketPrice;
            this.destination = ticketSales.destination;


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
