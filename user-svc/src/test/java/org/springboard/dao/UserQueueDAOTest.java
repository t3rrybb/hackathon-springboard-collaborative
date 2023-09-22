package org.springboard.dao;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.services.dynamodbv2.model.ResourceInUseException;

import com.amazonaws.services.dynamodbv2.util.TableUtils;
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

            tableRequest.setProvisionedThroughput(new ProvisionedThroughput(5L, 5L));

            amazonDynamoDB.createTable(tableRequest);
            TableUtils.createTableIfNotExists(amazonDynamoDB, tableRequest);
        } catch (ResourceInUseException e) {
            // Do nothing, table already created
        }
        try {
            //dynamoDBMapper.batchDelete(userQueueDAO.findAll());
        } catch (Exception ex) {
            // table might have been created just now
        }
    }

    @Test
    public void insertSomeEntries() {
        UserQueue user1 = new UserQueue(UserStatus.APPROVED, "T2", "12345", "", "");
        userQueueDAO.save(user1);

        UserQueue user2 = new UserQueue(UserStatus.QUEUED, "Muhesh", "124", "", "");
        //userQueueDAO.save(user2);

        List<UserQueue> result = userQueueDAO.findAll();

        assertFalse(result.isEmpty());
    }
}