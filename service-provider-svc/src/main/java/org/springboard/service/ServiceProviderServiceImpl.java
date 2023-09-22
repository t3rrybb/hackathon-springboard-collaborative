package org.springboard.service;

import org.springboard.dao.ServiceProviderDao;
import org.springboard.model.ServiceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.mail.SimpleEmail;

import java.util.List;
import java.util.Objects;

@Service
public class ServiceProviderServiceImpl implements ServiceProviderService {

    @Autowired
    private ServiceProviderDao serviceProviderDao;
    @Override
    public List<ServiceProvider> getAllServiceProviders() {
        return serviceProviderDao.findAll();
    }

    @Override
    public ServiceProvider findServiceProviderById(String id) {
        return serviceProviderDao.findById(id).orElse(null);
    }

    @Override
    public ServiceProvider updateServiceProviderById(ServiceProvider newServiceProviderInfo, String id) {
        var oldServiceProviderInfo = findServiceProviderById(id);
        if(Objects.isNull(oldServiceProviderInfo)) return addServiceProvider(newServiceProviderInfo);
        var updatedParticipantInfo = oldServiceProviderInfo.updateServiceProvider(newServiceProviderInfo);
        return addServiceProvider(updatedParticipantInfo);
    }

    @Override
    public ServiceProvider deleteServiceProviderById(String id) {
        var serviceProvider = serviceProviderDao.findById(id);
        if(serviceProvider.isPresent()){
            serviceProvider.get().setActive(false);
            serviceProviderDao.save(serviceProvider.get());
            return serviceProvider.get();
        }
        return null;
    }

    @Override
    public ServiceProvider addServiceProvider(ServiceProvider serviceProvider) {
        return serviceProviderDao.save(serviceProvider);
    }

    @Override
    public void sendEmail(String msg, String to) {
        try {
            SimpleEmail mail = new SimpleEmail();
            mail.setMsg(msg);
            mail.setHostName("local");
            mail.setFrom("tsc-login-otp@no-reply.com");
            mail.addTo(to);
            mail.send();
        } catch (Exception exception) {
            System.err.println("Mail send failed to " + to);
        }
        
    }
}
