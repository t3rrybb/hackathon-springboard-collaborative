package org.springboard;

import javax.annotation.PostConstruct;

import com.amazonaws.services.dynamodbv2.util.TableUtils;
import org.springboard.dao.UserQueueDAO;
import org.springboard.model.UserQueue;
import org.springboard.model.UserStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan("org.springboard.controller")
public class ServiceApplication {

    @Autowired
    private AmazonDynamoDB amazonDynamoDB;

    @Autowired
    UserQueueDAO userQueueDAO;

    @PostConstruct
    public void init() {

        createProductCatalogTable();
        UserQueue user1 = new UserQueue(UserStatus.QUEUED, "Vikram", "12345678", "", "");
		userQueueDAO.save(user1);

		UserQueue user2 = new UserQueue(UserStatus.RESIDENT, "Ashok", "123", "", "");
		userQueueDAO.save(user2);
    }

    public void createProductCatalogTable() {
        try {
			DynamoDBMapper dynamoDBMapper = new DynamoDBMapper(amazonDynamoDB);
            CreateTableRequest tableRequest = dynamoDBMapper.
                    generateCreateTableRequest(UserQueue.class);
            tableRequest.setProvisionedThroughput(
					new ProvisionedThroughput(1L, 1L));
            TableUtils.createTableIfNotExists(amazonDynamoDB, tableRequest);
        } catch (Exception e) {
			System.err.println("Error during table creation ... " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(ServiceApplication.class, args);
    }

}
