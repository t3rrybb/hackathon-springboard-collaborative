package org.springboard.controller;

import com.amazonaws.services.s3.AmazonS3Client;
import org.springboard.model.ServiceProviderModel;
import org.springboard.service.ServiceProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springboard.model.MailModel;

import java.util.List;
import java.util.Objects;

@CrossOrigin
@RestController
public class ServiceProviderController {

    @Autowired
    private ServiceProviderService serviceProviderService;
    
    @Autowired
    private MailModelController mailModelController;


    @PostMapping(value = "/service-providers", consumes = "application/json")
    public ResponseEntity<ServiceProviderModel> addServiceProvider(@RequestBody ServiceProviderModel serviceProvider){
        var RegisteredParticipant = serviceProviderService.addServiceProvider(serviceProvider);
        mailModelController.addProfile(new MailModel(serviceProvider.getEmail()
                                    ,null
                                    ,serviceProvider.getId()
                                    ,MailModel.UserType.SERVICE_PROVIDER));
        return new ResponseEntity<>(RegisteredParticipant, HttpStatus.OK);
    }

    @GetMapping(value = "/service-providers/{id}")
    public  ResponseEntity<ServiceProviderModel> findServiceProviderById(@PathVariable("id") final String id){
        var participant = serviceProviderService.findServiceProviderById(id);
        if(Objects.isNull(participant)) return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(participant, HttpStatus.OK);
    }

    @PutMapping(value = "/service-providers/{id}", consumes = "application/json")
    public ResponseEntity<ServiceProviderModel> updateServiceProviderById(@RequestBody ServiceProviderModel serviceProvider, @PathVariable("id") final String id){
        var responseParticipant = serviceProviderService.updateServiceProviderById(serviceProvider, id);
        return new ResponseEntity<>(responseParticipant, HttpStatus.OK);
    }

    @DeleteMapping(value ="/service-providers/{id}")
    public ResponseEntity<ServiceProviderModel> deleteServiceProviderById(@PathVariable("id") final String id){
        var participant = serviceProviderService.deleteServiceProviderById(id);
        if(Objects.isNull(participant)) return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(participant, HttpStatus.OK);
    }
    @GetMapping(value = "/service-providers/all", produces = { "application/json"})
    public ResponseEntity<List<ServiceProviderModel>> getAllServiceProviders() {
        ResponseEntity<List<ServiceProviderModel>> response = new ResponseEntity<>(serviceProviderService.getAllServiceProviders(), HttpStatus.OK);
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
