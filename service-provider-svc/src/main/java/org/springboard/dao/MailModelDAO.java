package org.springboard.dao;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springboard.model.MailModel;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

@EnableScan
public interface MailModelDAO extends CrudRepository<MailModel, String> {

    Optional<MailModel> findByMailId(String mailId);

}
