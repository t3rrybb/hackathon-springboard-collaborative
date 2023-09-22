package org.springboard.dao;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.services.dynamodbv2.model.ResourceInUseException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springboard.ServiceApplication;
import org.springboard.controller.UserQueueController;
import org.springboard.model.UserQueue;
import org.springboard.model.UserStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = ServiceApplication.class)
@WebAppConfiguration
@TestPropertySource(properties = {"amazon.aws.accesskey=AKIAWQRWDGA46XT7O5DT", "amazon.aws.secretkey=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" })
public class UserQueueDAOTest {

    private DynamoDBMapper dynamoDBMapper;

    @Autowired
    private AmazonDynamoDB amazonDynamoDB;

    @Autowired
    UserQueueDAO userQueueDAO;

    @Autowired
    UserQueueController userQueueController;

    @BeforeEach
    public void setup() {

        try {
            dynamoDBMapper = new DynamoDBMapper(amazonDynamoDB);

            CreateTableRequest tableRequest = dynamoDBMapper.generateCreateTableRequest(UserQueue.class);

            tableRequest.setProvisionedThroughput(new ProvisionedThroughput(1L, 1L));

            amazonDynamoDB.createTable(tableRequest);
        } catch (ResourceInUseException e) {
            // Do nothing, table already created
        }

        // TODO How to handle different environments. i.e. AVOID deleting all entries in BookInfo on table
        dynamoDBMapper.batchDelete(userQueueDAO.findAll());
    }

    @Test
    public void insertSomeEntries() {
        UserQueue user1 = new UserQueue(UserStatus.QUEUED, "Vikram", "12345678", "", "");
        userQueueDAO.save(user1);

        UserQueue user2 = new UserQueue(UserStatus.QUEUED, "Ashok", "123", "", "");
        userQueueDAO.save(user2);

        List<UserQueue> result = (List<UserQueue>) userQueueDAO.findAll();

        assertTrue( result.size() > 0 );
    }
}