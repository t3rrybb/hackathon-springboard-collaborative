package org.springboard.service;

import org.springboard.model.ServiceProvider;

import java.util.List;

public interface ServiceProviderService {

    public List<ServiceProvider> getAllProviders();
    
    public void sendEmail(String msg, String to);
}
