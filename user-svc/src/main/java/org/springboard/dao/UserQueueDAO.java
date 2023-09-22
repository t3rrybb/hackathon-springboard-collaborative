package org.springboard.dao;

import java.util.List;
import java.util.Optional;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springboard.model.UserQueue;
import org.springboard.model.UserStatus;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface UserQueueDAO extends CrudRepository<UserQueue, String> {

    Optional<UserQueue> findById(String id);

    List<UserQueue> findAll();

    List<UserQueue> findByStatus(UserStatus userStatus);

}
