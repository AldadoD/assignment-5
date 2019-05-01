package com.aldado.domain.admin;

public class Busstop {

    private  String code;


    private Busstop(){

    }
    private Busstop(Builder builder){
        this.code = builder.code;

    }

    public String getCode() {
        return code;
    }


    public static class Builder {

        private String code;


        public Busstop.Builder code(String code) {
            this.code = code;
            return this;
        }

        public Busstop build(){
            return new Busstop(this);
        }
    }

    @Override
    public String toString() {
        return "Busstop{" + "Code = " + code  + '}';
    }
}
