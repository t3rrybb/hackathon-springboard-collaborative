package org.springboard.controller;

import org.springboard.model.Participant;
import org.springboard.service.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
public class ParticipantController {

    @Autowired
    ParticipantService participantService;

    @PostMapping(value = "/user", consumes = "application/json")
    public ResponseEntity<Participant> addParticipant(@RequestBody Participant participant){
        var RegisteredParticipant = participantService.addParticipant(participant);
        return new ResponseEntity<>(RegisteredParticipant, HttpStatus.OK);
    }


    @GetMapping(value = "/user/{id}")
    public  ResponseEntity<Participant> findParticipantById(@PathVariable("id") final String id){
        var participant = participantService.findParticipantById(id);
        if(Objects.isNull(participant)) return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(participant, HttpStatus.OK);
    }

    @PutMapping(value = "/user/{id}", consumes = "application/json")
    public ResponseEntity<Participant> updateParticipantById(@RequestBody Participant participant, @PathVariable("id") final String id){
        var responseParticipant = participantService.updateParticipantById(participant, id);
        return new ResponseEntity<>(responseParticipant, HttpStatus.OK);
    }

    @DeleteMapping(value ="/user/{id}")
    public ResponseEntity<Participant> deleteParticipantById(@PathVariable("id") final String id){
        var participant = participantService.deleteParticipantById(id);
        if(Objects.isNull(participant)) return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(participant, HttpStatus.OK);
    }

    @GetMapping(value = "/user/all")
    public  ResponseEntity<List<Participant>> getAllParticipant(){
        return new ResponseEntity<>(participantService.getAllParticipant(), HttpStatus.OK);
    }


    
}
