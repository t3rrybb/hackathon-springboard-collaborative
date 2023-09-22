package org.springboard.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "participant")
public class Participant {

    private String id;

    String firstName;

    String lastName;

    String email;

    String phone;

    Status status;

    String DOB;

    public Participant(String id, String firstName, String lastName, String email, String phone, Status status, String DOB) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.status = status;
        this.DOB = DOB;
    }

    public Participant(String firstName, String lastName, String email, String phone, Status status, String DOB) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.status = status;
        this.DOB = DOB;
    }

    public Participant() {
    }

    public Participant updateParticipant(Participant updatedParticipantInfo){
        this.firstName = updatedParticipantInfo.getFirstName();
        this.lastName = updatedParticipantInfo.getLastName();
        this.email = updatedParticipantInfo.getEmail();
        this.phone = updatedParticipantInfo.getPhone();
        this.status = updatedParticipantInfo.getStatus();
        this.DOB = updatedParticipantInfo.getDOB();
        return this;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public enum Status {
        ACTIVE("ACTIVE"),
        INACTIVE("INACTIVE");

        private final String state;

        public String getState() {
            return state;
        }

        Status(String state) { this.state = state;}
    }
}
