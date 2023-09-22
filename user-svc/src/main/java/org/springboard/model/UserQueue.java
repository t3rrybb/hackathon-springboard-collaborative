package org.springboard.model;

import com.amazonaws.services.dynamodbv2.datamodeling.*;

import java.util.Date;

@DynamoDBTable(tableName="UserQueue")
public class UserQueue {

    private String id;
    private UserStatus status;
    private Date createdDate;
    private String name;
    private String mobileNumber;
    private String email;
    private String comments;

    @DynamoDBHashKey(attributeName = "ID")
    @DynamoDBAutoGeneratedKey
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @DynamoDBTypeConvertedEnum
    @DynamoDBAttribute(attributeName = "User Status")
    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

    @DynamoDBAttribute(attributeName = "Creation date")
    @DynamoDBAutoGeneratedTimestamp
    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @DynamoDBAttribute(attributeName = "Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @DynamoDBAttribute(attributeName = "Mobile Number")
    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    @DynamoDBAttribute(attributeName = "EMAIL")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @DynamoDBAttribute(attributeName = "Comments")
    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public UserQueue() {

    }

    public UserQueue(String id, UserStatus status, Date createdDate, String name, String mobileNumber, String email, String comments) {
        this.id = id;
        this.status = status;
        this.createdDate = createdDate;
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.comments = comments;
    }

    public UserQueue(UserStatus status, String name, String mobileNumber, String email, String comments) {
        this.status = status;
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "UserQueue{" +
                "id='" + id + '\'' +
                ", status=" + status +
                ", createdDate='" + createdDate + '\'' +
                ", name='" + name + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", email='" + email + '\'' +
                ", comments='" + comments + '\'' +
                '}';
    }
}
