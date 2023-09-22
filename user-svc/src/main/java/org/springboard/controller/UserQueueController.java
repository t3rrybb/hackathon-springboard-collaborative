package org.springboard.controller;

import org.springboard.model.UserQueue;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springboard.dao.UserQueueDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserQueueController {

    @Autowired
    UserQueueDAO userQueueDAO;

    @RequestMapping(path="/userQueue/allUsers", method=RequestMethod.GET)
    public @ResponseBody List<UserQueue> findAll() {
        return userQueueDAO.findAll();
    }
}
