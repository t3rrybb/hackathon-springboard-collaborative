package org.springboard.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@DynamoDBTable(tableName="UserQueue")
@NoArgsConstructor
@Getter
@Setter
public class UserQueue {

    @DynamoDBHashKey
    @DynamoDBAutoGeneratedKey
    private String id;

    @DynamoDBAttribute
    private UserStatus status;

    @DynamoDBAttribute
    private String name;

    @DynamoDBAttribute
    private String mobileNumber;

    @DynamoDBAttribute
    private String email;

    @DynamoDBAttribute
    private String comments;

    public UserQueue(UserStatus status, String name, String mobileNumber, String email, String comments) {
        this.status = status;
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.comments = comments;
    }
}
