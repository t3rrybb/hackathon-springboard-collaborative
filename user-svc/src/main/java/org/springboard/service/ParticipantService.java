package org.springboard.service;

import org.springboard.dao.ParticipantDao;
import org.springboard.model.Participant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ParticipantService {

    @Autowired
    ParticipantDao participantDao;


    public Participant addParticipant(Participant participant){
        return participantDao.save(participant);
    }
    public Participant findParticipantById(String id){
        return participantDao.findById(id).orElse(null);
    }
    public List<Participant> getAllParticipant(){
        return participantDao.findAll();
    }


    public Participant updateParticipantById(Participant newParticipantInfo, String id){
        var oldParticipantInfo = findParticipantById(id);
        if(Objects.isNull(oldParticipantInfo)) return addParticipant(newParticipantInfo);
        var updatedParticipantInfo = oldParticipantInfo.updateParticipant(newParticipantInfo);
        return addParticipant(updatedParticipantInfo);
    }

    public Participant deleteParticipantById(String id){
        var participant = participantDao.findById(id);
        if(participant.isPresent()){
            participant.get().setStatus(Participant.Status.INACTIVE);
            participantDao.save(participant.get());
            return participant.get();
        }
        return null;
    }
}
