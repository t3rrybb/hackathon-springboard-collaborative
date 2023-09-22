package org.springboard.service;

import org.springboard.model.ServiceProvider;

import java.util.List;

public interface ServiceProviderService {

    public List<ServiceProvider> getAllServiceProviders();

    public ServiceProvider findServiceProviderById(String id);

    public ServiceProvider updateServiceProviderById(ServiceProvider serviceProvider,String id);

    public ServiceProvider deleteServiceProviderById(String id);

    public ServiceProvider addServiceProvider(ServiceProvider serviceProvider);
    
    public void sendEmail(String msg, String to);

    public String generateOtpAndSave(String mailId);

    public String validateOtpAndDelete(String mailId, String otp);
}
