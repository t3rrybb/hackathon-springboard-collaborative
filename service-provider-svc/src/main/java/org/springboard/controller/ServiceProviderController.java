package org.springboard.controller;

import org.springboard.model.ServiceProvider;
import org.springboard.service.ServiceProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ServiceProviderController {

    @Autowired
    private ServiceProviderService service;
    @GetMapping(value = "/service-providers/all", produces = { "application/json"})
    public ResponseEntity<List<ServiceProvider>> getAllProviders() {
        ResponseEntity<List<ServiceProvider>> response = new ResponseEntity<>(service.getAllProviders(), HttpStatus.OK);
        return response;
    }
    
    @RequestMapping(value = "/send-mail/{to}")
    public void sendEmail(@RequestBody String msg, @PathVariable String to) {
        service.sendEmail(msg, to);
    }
}
