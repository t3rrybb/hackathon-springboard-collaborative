package org.springboard.controller;

import org.springboard.model.UserQueue;
import org.springboard.service.UserQueueService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Objects;

@CrossOrigin
@RestController
public class UserQueueController {

    @Autowired
    UserQueueService userQueueService;

    @GetMapping(path="/userQueue")
    public @ResponseBody ResponseEntity<List<UserQueue>> findAll() {
        return new ResponseEntity<>(userQueueService.findAllUsers(), HttpStatus.OK);
    }

    @GetMapping(path="/userQueue/{id}")
    public @ResponseBody ResponseEntity<UserQueue> findUserById(@PathVariable("id") final String id) {
        var queuedUser = userQueueService.findUserById(id);
        if (Objects.isNull(queuedUser)) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(queuedUser, HttpStatus.OK);
    }

    @GetMapping(path="/userQueue/allUsers/{status}")
    public @ResponseBody ResponseEntity<List<UserQueue>> findAllQueuedUsers(@PathVariable("status")
                                                                                final String status) {
        var queuedUsersList = userQueueService.findUsersWithSpecificStatus(status);
        if (queuedUsersList.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(queuedUsersList, HttpStatus.OK);
    }

    @PostMapping(path="/userQueue", consumes = "application/json")
    public ResponseEntity<UserQueue> updateQueuedUserPost(@RequestBody UserQueue userQueue){
        var queuedUser = userQueueService.addUserQueueData(userQueue);
        return new ResponseEntity<>(queuedUser, HttpStatus.OK);
    }

    @PutMapping(path="/userQueue/{id}", consumes = "application/json")
    public ResponseEntity<String> updateQueuedUserById(@RequestBody UserQueue userQueue,
                                                       @PathVariable("id") final String id){
        var queuedUser = userQueueService.updateQueuedUser(userQueue, id);
        return new ResponseEntity<>(queuedUser, HttpStatus.OK);
    }

    @DeleteMapping(path="/userQueue/{id}")
    public ResponseEntity<String> deleteQueuedUserById(@PathVariable("id") final String id){
        var deletedQueuedUser = userQueueService.deleteQueuedUser(id);
        return new ResponseEntity<>(deletedQueuedUser, HttpStatus.OK);
    }
}
