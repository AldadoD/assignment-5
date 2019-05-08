package com.aldado.domain.people;

public class Identification {

    private String id;

    private Identification(){

    }
    private Identification(Builder builder){
        this.id = builder.id;
    }

    public String getId(){
        return id;
    }
    public static class Builder{
        private String id;

        public Builder id(String id){
            this.id = id;
            return this;

        }

        public Builder copy(Identification identification) {
            this.id = identification.id;

            return this;
        }
        public Identification build(){
            return new Identification(this);
        }
    }

    @Override
    public String toString() {
        return "Identification{" + "id='" + id + '\'' + '}';
    }
}
