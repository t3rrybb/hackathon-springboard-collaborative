package org.springboard.model;

import com.amazonaws.services.dynamodbv2.datamodeling.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@DynamoDBTable(tableName = "participant")
public class Participant {

    private String id;

    String cabin;
    String firstName;

    String lastName;

    String email;

    String phone;

    Status status;

    String dob;

    String comments;

    Map<String, String> subscribed;

    List<String> need;

    List<String> referredTo;

    public Participant(String id, String cabin, String firstName, String lastName,
                       String email, String phone, Status status, String dob,
                       String comments, Map<String, String> subscribed, List<String> need,
                       List<String> referredTo) {
        this.id = id;
        this.cabin = cabin;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.status = status;
        this.dob = dob;
        this.comments = comments;
        this.subscribed = subscribed;
        this.need = need;
        this.referredTo = referredTo;
    }
    
    public Participant(String cabin, String firstName, String lastName, String email,
                       String phone, Status status, String dob, String comments,
                       Map<String, String> subscribed, List<String> need, List<String> referredTo) {
        this.cabin = cabin;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.status = status;
        this.dob = dob;
        this.comments = comments;
        this.subscribed = subscribed;
        this.need = need;
        this.referredTo = referredTo;
    }

    public Participant() {
    }

    public Participant updateParticipant(Participant updatedParticipantInfo) {
        if (Objects.nonNull(updatedParticipantInfo.getCabin()))
            this.cabin = updatedParticipantInfo.getCabin();

        if (Objects.nonNull(updatedParticipantInfo.getFirstName()))
            this.firstName = updatedParticipantInfo.getFirstName();

        if (Objects.nonNull(updatedParticipantInfo.getLastName()))
            this.lastName = updatedParticipantInfo.getLastName();

        if (Objects.nonNull(updatedParticipantInfo.getEmail()))
            this.email = updatedParticipantInfo.getEmail();

        if (Objects.nonNull(updatedParticipantInfo.getPhone()))
            this.phone = updatedParticipantInfo.getPhone();

        if (Objects.nonNull(updatedParticipantInfo.getStatus()))
            this.status = updatedParticipantInfo.getStatus();

        if (Objects.nonNull(updatedParticipantInfo.getDob()))
            this.dob = updatedParticipantInfo.getDob();

        if (Objects.nonNull(updatedParticipantInfo.getComments()))
            this.comments = updatedParticipantInfo.getComments();

        if (Objects.nonNull(updatedParticipantInfo.getSubscribed())){
            if(Objects.nonNull(this.subscribed)){
                this.subscribed.putAll(updatedParticipantInfo.getSubscribed());
            }else{
                this.subscribed = updatedParticipantInfo.getSubscribed();
            }
        }

        if (Objects.nonNull(updatedParticipantInfo.getNeed())){
            if(Objects.nonNull(this.need)){
                this.need.addAll(updatedParticipantInfo.getNeed());
            }else{
                this.need = updatedParticipantInfo.getNeed();
            }
        }

        if (Objects.nonNull(updatedParticipantInfo.getReferredTo())){
            if(Objects.nonNull(this.referredTo)){
                this.referredTo.addAll(updatedParticipantInfo.getReferredTo());
            }else{
                this.referredTo = updatedParticipantInfo.getReferredTo();
            }
        }

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
    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    @DynamoDBAttribute
    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @DynamoDBAttribute
    public String getCabin() {
        return cabin;
    }

    public void setCabin(String cabin) {
        this.cabin = cabin;
    }

    @DynamoDBAttribute
    public Map<String, String> getSubscribed() {
        return subscribed;
    }

    public void setSubscribed(Map<String, String> subscribed) {
        this.subscribed = subscribed;
    }

    @DynamoDBAttribute
    public List<String> getNeed() {
        return need;
    }

    public void setNeed(List<String> need) {
        this.need = need;
    }

    @DynamoDBAttribute
    public List<String> getReferredTo() {
        return referredTo;
    }

    public void setReferredTo(List<String> referredTo) {
        this.referredTo = referredTo;
    }

    public enum Status {
        ACTIVE("ACTIVE"),
        INACTIVE("INACTIVE");

        private final String state;

        public String getState() {
            return state;
        }

        Status(String state) {
            this.state = state;
        }
    }
}
