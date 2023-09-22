package org.springboard.service;

import org.springboard.model.ServiceProviderModel;

import java.util.List;

public interface ServiceProviderService {

    public List<ServiceProviderModel> getAllServiceProviders();

    public ServiceProviderModel findServiceProviderById(String id);

    public ServiceProviderModel updateServiceProviderById(ServiceProviderModel serviceProvider, String id);

    public ServiceProviderModel deleteServiceProviderById(String id);

    public ServiceProviderModel addServiceProvider(ServiceProviderModel serviceProvider);

    public ServiceProviderModel updateServiceProviderByName(String name, String consentFormUrl);
    
    public void sendEmail(String msg, String to);

    public String generateOtpAndSave(String mailId);

    public String validateOtpAndDelete(String mailId, String otp);
}
