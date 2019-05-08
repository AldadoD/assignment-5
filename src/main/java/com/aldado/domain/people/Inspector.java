package com.aldado.domain.people;

public class Inspector {

    private  String id, inspectorFirstName, inspectorLastName;
    private boolean validTicket;


    private Inspector(){

    }
    private Inspector(Builder builder){
        this.id = builder.id;
        this.inspectorFirstName = builder.inspectorFirstName;
        this.inspectorLastName = builder.inspectorLastName;
        this.validTicket = builder.validTicket;

    }

    public String getId() {
        return id;
    }

    public String getInspectorFirstName() {
        return inspectorFirstName;
    }

    public String getInspectorLastName() {
        return inspectorLastName;
    }
    public boolean getValidTicket() {
        return validTicket;
    }
    public static class Builder {

        private String id;
        private String inspectorFirstName;
        private String inspectorLastName;
        private boolean validTicket;

//        private Set<Routes> route;

        public Inspector.Builder id(String id) {
            this.id = id;
            return this;
        }

        public Inspector.Builder inspectorFirstName(String inspectorFirstName) {
            this.inspectorFirstName = inspectorFirstName;
            return this;
        }

        public Inspector.Builder inspectorLastName(String inspectorLastName) {
            this.inspectorLastName = inspectorLastName;
            return this;
        }
        public Inspector.Builder validTicket(boolean validTicket) {
            this.validTicket = validTicket;
            return this;
        }
        public Builder copy(Inspector inspector) {
            this.id = inspector.id;
            this.inspectorFirstName = inspector.inspectorFirstName;
            this.inspectorLastName = inspector.inspectorLastName;
            this.validTicket = inspector.validTicket;


            return this;
        }

        public Inspector build(){
            return new Inspector(this);
        }
    }

    @Override
    public String toString() {
        return "Inspector{" + "Id = '" + id + '\'' + ",Inspector's First Name = '" + inspectorFirstName + '\'' + ", Inspector's Last Name = '" + inspectorLastName + '\'' + ", Ticket is valid = " + validTicket + '}';
    }
}
