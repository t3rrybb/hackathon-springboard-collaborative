package org.springboard.controller;

import org.springboard.model.UserQueue;
import org.springboard.service.UserQueueService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
public class UserQueueController {

    @Autowired
    UserQueueService userQueueService;

    @RequestMapping(path="/userQueue", method=RequestMethod.GET)
    public @ResponseBody List<UserQueue> findAll() {
        return userQueueService.findAllUsers();
    }

    @RequestMapping(path="/userQueue/{status}", method=RequestMethod.GET)
    public @ResponseBody List<UserQueue> findAllQueuedUsers(@PathVariable("status") final String status) {
        return userQueueService.findUsersWithSpecificStatus(status);
    }

    @PostMapping(value = "/userQueue", consumes = "application/json")
    public ResponseEntity<UserQueue> addUserQueue(@RequestBody UserQueue userQueue){
        var queuedUser = userQueueService.addUserQueueData(userQueue);
        return new ResponseEntity<>(queuedUser, HttpStatus.OK);
    }

    @PutMapping(value = "/userQueue/{id}", consumes = "application/json")
    public ResponseEntity<String> updateQueuedUser(@RequestBody UserQueue userQueue,
                                                         @PathVariable("id") final String id){
        var queuedUser = userQueueService.updateQueuedUser(userQueue, id);
        return new ResponseEntity<>(queuedUser, HttpStatus.OK);
    }

    @DeleteMapping(value ="/userQueue/{id}")
    public ResponseEntity<String> deleteQueuedUser(@PathVariable("id") final String id){
        var deletedQueuedUser = userQueueService.deleteQueuedUser(id);
        return new ResponseEntity<>(deletedQueuedUser, HttpStatus.OK);
    }
}
