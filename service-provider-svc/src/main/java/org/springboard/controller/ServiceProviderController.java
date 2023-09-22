package org.springboard.controller;

import org.springboard.model.ServiceProvider;
import org.springboard.service.ServiceProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
public class ServiceProviderController {

    @Autowired
    private ServiceProviderService serviceProviderService;

    @PostMapping(value = "/service-providers", consumes = "application/json")
    public ResponseEntity<ServiceProvider> addServiceProvider(@RequestBody ServiceProvider serviceProvider){
        var RegisteredParticipant = serviceProviderService.addServiceProvider(serviceProvider);
        return new ResponseEntity<>(RegisteredParticipant, HttpStatus.OK);
    }

    @GetMapping(value = "/service-providers/{id}")
    public  ResponseEntity<ServiceProvider> findServiceProviderById(@PathVariable("id") final String id){
        var participant = serviceProviderService.findServiceProviderById(id);
        if(Objects.isNull(participant)) return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(participant, HttpStatus.OK);
    }

    @PutMapping(value = "/service-providers/{id}", consumes = "application/json")
    public ResponseEntity<ServiceProvider> updateServiceProviderById(@RequestBody ServiceProvider serviceProvider, @PathVariable("id") final String id){
        var responseParticipant = serviceProviderService.updateServiceProviderById(serviceProvider, id);
        return new ResponseEntity<>(responseParticipant, HttpStatus.OK);
    }

    @DeleteMapping(value ="/service-providers/{id}")
    public ResponseEntity<ServiceProvider> deleteServiceProviderById(@PathVariable("id") final String id){
        var participant = serviceProviderService.deleteServiceProviderById(id);
        if(Objects.isNull(participant)) return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(participant, HttpStatus.OK);
    }
    @GetMapping(value = "/service-providers/all", produces = { "application/json"})
    public ResponseEntity<List<ServiceProvider>> getAllServiceProviders() {
        ResponseEntity<List<ServiceProvider>> response = new ResponseEntity<>(serviceProviderService.getAllServiceProviders(), HttpStatus.OK);
        return response;
    }

    
    @RequestMapping(value = "/send-mail/{to}")
    public void sendEmail(@RequestBody String msg, @PathVariable String to) {
        serviceProviderService.sendEmail(msg, to);
    }
}
