package com.aldado.domain.admin;

public class Destination {

    private String name, id;

    private Destination(){

    }
    private Destination(Builder builder){
        this.name = builder.name;
        this.id = builder.id;
    }
    public String getName(){
        return name;
    }
    public String getId(){
        return id;
    }
    public static class Builder{
        private String name;
        private String id;

        public Destination.Builder name(String name){
            this.name = name;
            return this;
        }
        public Destination.Builder id(String id){
            this.id = id;
           return this;

        }
        public Builder copy(Destination destination) {
            this.id = destination.id;
            this.name = destination.name;


            return this;
        }
        public Destination build(){
            return new Destination(this);
        }
    }

    @Override
    public String toString() {
        return "Destination{" + "Dest Name = '" + name + '\'' + ", Dest id = '" + id + '\'' + '}';
    }
}
