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

    
    @GetMapping(value = "/send-mail/{to}")
    public void sendEmail(@RequestBody String msg, @PathVariable String to) {
        serviceProviderService.sendEmail(msg, to);
    }

    @GetMapping(value = "/send-mail/{mail-id}/generateOTP")
    public ResponseEntity<String> generateOTP(@PathVariable("mail-id") final String mailId) {
        return new ResponseEntity<>(serviceProviderService.generateOtpAndSave(mailId), HttpStatus.OK);
    }

    @GetMapping(value = "/send-mail/{mail-id}/{otp}/validateOTP")
    public ResponseEntity<String> validateOTP(@PathVariable("mail-id") final String mailId,
                                              @PathVariable("otp") final String otp) {
        var validationResponse = serviceProviderService.validateOtpAndDelete(mailId, otp);
        if ("ACCEPTED".equals(validationResponse)) {
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(HttpStatus.valueOf("WRONG PASSWORD"));
        }
    }
}
