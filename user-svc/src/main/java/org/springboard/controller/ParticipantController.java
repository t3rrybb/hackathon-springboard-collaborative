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
    public  ResponseEntity<Participant> getParticipant(@PathVariable("id") final String id){
        var participant = participantService.getParticipant(id);
        if(Objects.isNull(participant)) return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(participant, HttpStatus.OK);
    }

    @PutMapping(value = "/user/{id}", consumes = "application/json")
    public ResponseEntity<Participant> updateParticipant(@RequestBody Participant participant, @PathVariable("id") final String id){
        var responseParticipant = participantService.updateParticipant(participant, id);
        return new ResponseEntity<>(responseParticipant, HttpStatus.OK);
    }

    @DeleteMapping(value ="/user/{id}")
    public ResponseEntity<Participant> deleteParticipant(@PathVariable("id") final String id){
        var participant = participantService.deleteParticipant(id);
        if(Objects.isNull(participant)) return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(participant, HttpStatus.OK);
    }

    @GetMapping(value = "/user/all")
    public  ResponseEntity<List<Participant>> getParticipant(){
        return new ResponseEntity<>(participantService.getAllParticipant(), HttpStatus.OK);
    }


    
}
