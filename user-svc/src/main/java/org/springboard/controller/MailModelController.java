package org.springboard.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springboard.model.MailModel;
import org.springboard.dao.MailModelDAO;

@CrossOrigin
@RestController
public class MailModelController {
    
    @Autowired
    MailModelDAO mailModelDao;
    
    @GetMapping("/profile/{emailId}")
    public MailModel getProfileById(@PathVariable("emailId") final String emailId){
        return mailModelDao.findById(emailId).get();
    }
    
    @PostMapping(value = "/profile", consumes = "application/json")
    public MailModel addProfile(@RequestBody MailModel mailModel){
        return mailModelDao.save(mailModel);
    }
    
    
}
