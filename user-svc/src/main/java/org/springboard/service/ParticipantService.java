package org.springboard.service;

import org.springboard.dao.ParticipantDao;
import org.springboard.model.Participant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ParticipantService {

    @Autowired
    ParticipantDao participantDao;


    public Participant addParticipant(Participant participant){
        return participantDao.save(participant);
    }
    public Participant getParticipant(String id){
        return participantDao.findById(id).orElse(null);
    }

    public Participant updateParticipant(Participant oldParticipant, String id){
        var oldParticipantInfo = getParticipant(id);
        if(Objects.isNull(oldParticipantInfo)) return addParticipant(oldParticipant);
        var updatedParticipantInfo = oldParticipantInfo.updateParticipant(oldParticipant);
        return addParticipant(updatedParticipantInfo);
    }

    public Participant deleteParticipant(String id){
        var participant = participantDao.findById(id);
        if(participant.isPresent()){
            participant.get().setStatus(Participant.Status.INACTIVE);
            participantDao.save(participant.get());
            return participant.get();
        }
        return null;
    }
}
