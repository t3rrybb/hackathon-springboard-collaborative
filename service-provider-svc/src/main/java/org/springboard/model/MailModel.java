package org.springboard.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "mailOTP")
public class MailModel {

    private String mailId;

    private String otp;
    
    private String userId;
    
    private UserType userType;

    @DynamoDBHashKey(attributeName = "EMAIL")
    public String getMailId() {
        return mailId;
    }

    public void setMailId(String mailId) {
        this.mailId = mailId;
    }
    
    @DynamoDBAttribute(attributeName = "OTP")
    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    @DynamoDBAttribute(attributeName = "USERID")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
    

    @DynamoDBAttribute(attributeName = "USERTYPE")
    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public MailModel() {

    }
    
    public MailModel(String mailId, String otp) {
        this.mailId = mailId;
        this.otp = otp;
    }

    public MailModel(String mailId, String otp,String userId,UserType userType) {
        this.mailId = mailId;
        this.otp = otp;
        this.userId = userId;
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "MailModel{" +
                "mailId='" + mailId + '\'' +
                ", otp='" + otp + '\'' +
                '}';
    }
    
    public enum UserType {
        TSC("TSC"),
        SERVICE_PROVIDER("SERVICE_PROVIDER"),
        PARTICIPANT("PARTICIPANT");

        private final String type;

        public String getState() {
            return type;
        }

        UserType(String type) {
            this.type = type;
        }
    }
}
