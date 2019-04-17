package com.aldado.domain;

public class Name {

    private String firstName, lastName;

    private Name(){

    }
    private Name(Builder builder){
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public static class Builder{
        private String firstName;
        private String lastName;

        public Name.Builder firstName(String firstName){
            this.firstName = firstName;
            return this;
    }
        public Name.Builder lastName(String lastName){
            this.lastName = lastName;
            return this;

    }
    public Name build(){
            return new Name(this);
        }
    }

    @Override
    public String toString() {
        return "Name{" + "firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + '}';
    }
}
