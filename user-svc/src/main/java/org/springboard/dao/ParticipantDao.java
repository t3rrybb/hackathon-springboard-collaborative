package org.springboard.dao;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springboard.model.Participant;
import org.springboard.model.UserQueue;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@EnableScan
public interface ParticipantDao extends CrudRepository<Participant, String> {

    Optional<Participant> findById(String id);

    List<Participant> findAll();

    Participant save(Participant participant);

}