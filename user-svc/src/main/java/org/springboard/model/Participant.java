package org.springboard.model;

import com.amazonaws.services.dynamodbv2.datamodeling.*;

import java.util.Objects;

@DynamoDBTable(tableName = "participant")
public class Participant {

    private String id;

    String firstName;

    String lastName;

    String email;

    String phone;

    Status status;

    String DOB;

    String comments;

    public Participant(String id, String firstName, String lastName,
                       String email, String phone, Status status, String DOB, String comments) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.status = status;
        this.DOB = DOB;
        this.comments = comments;
    }

    public Participant(String firstName, String lastName, String email,
                       String phone, Status status, String DOB, String comments) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.status = status;
        this.DOB = DOB;
        this.comments = comments;
    }

    public Participant() {
    }

    public Participant updateParticipant(Participant updatedParticipantInfo){
        if(Objects.nonNull(updatedParticipantInfo.getFirstName()))
            this.firstName = updatedParticipantInfo.getFirstName();

        if(Objects.nonNull(updatedParticipantInfo.getLastName()))
            this.lastName = updatedParticipantInfo.getLastName();

        if(Objects.nonNull(updatedParticipantInfo.getEmail()))
            this.email = updatedParticipantInfo.getEmail();

        if(Objects.nonNull(updatedParticipantInfo.getPhone()))
            this.phone = updatedParticipantInfo.getPhone();

        if(Objects.nonNull(updatedParticipantInfo.getStatus()))
            this.status = updatedParticipantInfo.getStatus();

        if(Objects.nonNull(updatedParticipantInfo.getDOB()))
            this.DOB = updatedParticipantInfo.getDOB();

        if (Objects.nonNull(updatedParticipantInfo.getComments()))
            this.comments = updatedParticipantInfo.getComments();

        return this;
    }

    @DynamoDBHashKey
    @DynamoDBAutoGeneratedKey
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @DynamoDBAttribute
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @DynamoDBAttribute
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @DynamoDBAttribute
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @DynamoDBAttribute
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @DynamoDBTypeConvertedEnum
    @DynamoDBAttribute
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @DynamoDBAttribute
    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    @DynamoDBAttribute
    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
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
