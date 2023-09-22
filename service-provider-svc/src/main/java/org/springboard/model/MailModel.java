package org.springboard.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "mailOTP")
public class MailModel {

    private String mailId;

    private String otp;

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

    public MailModel() {

    }

    public MailModel(String mailId, String otp) {
        this.mailId = mailId;
        this.otp = otp;
    }

    @Override
    public String toString() {
        return "MailModel{" +
                "mailId='" + mailId + '\'' +
                ", otp='" + otp + '\'' +
                '}';
    }
}
